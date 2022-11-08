package kz.bitlab.spring.six.one.spring.demo.six.one.services.impl;

import kz.bitlab.spring.six.one.spring.demo.six.one.models.ApplicationRequest;
import kz.bitlab.spring.six.one.spring.demo.six.one.repositories.ApplicationRepository;
import kz.bitlab.spring.six.one.spring.demo.six.one.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<ApplicationRequest> getOldApplications() {
        return applicationRepository.findApplicationRequestByHandledIsTrue();
    }

    @Override
    public ApplicationRequest addApplication(ApplicationRequest application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<ApplicationRequest> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public ApplicationRequest getApplication(Long id) {
        return applicationRepository.getOne(id);
    }

    @Override
    public List<ApplicationRequest> getNewApplications() {
        return applicationRepository.findApplicationRequestByHandledIsFalse();
    }

    @Override
    public void deleteApplication(ApplicationRequest application) {
        applicationRepository.delete(application);
    }

    @Override
    public ApplicationRequest saveApplication(ApplicationRequest application) {
        return applicationRepository.save(application);
    }
}
