package kz.bitlab.spring.six.one.spring.demo.six.one.services;

import kz.bitlab.spring.six.one.spring.demo.six.one.models.ApplicationRequest;

import java.util.List;

public interface ApplicationService {

    ApplicationRequest addApplication(ApplicationRequest application);
    List<ApplicationRequest> getAllApplications();
    ApplicationRequest getApplication(Long id);
    void deleteApplication(ApplicationRequest application);
    ApplicationRequest saveApplication(ApplicationRequest application);
    List<ApplicationRequest> getNewApplications();
    List<ApplicationRequest> getOldApplications();


}
