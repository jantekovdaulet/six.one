package kz.bitlab.spring.six.one.spring.demo.six.one.repositories;

import kz.bitlab.spring.six.one.spring.demo.six.one.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ApplicationRepository extends JpaRepository<ApplicationRequest, Long> {

    List<ApplicationRequest> findApplicationRequestByHandledIsFalse();
    List<ApplicationRequest> findApplicationRequestByHandledIsTrue();

}
