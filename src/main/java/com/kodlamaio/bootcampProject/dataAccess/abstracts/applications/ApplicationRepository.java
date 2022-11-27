package com.kodlamaio.bootcampProject.dataAccess.abstracts.applications;

import com.kodlamaio.bootcampProject.entities.applications.Application;
import com.kodlamaio.bootcampProject.entities.users.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Application findApplicationByApplicantId(int applicantId);

}
