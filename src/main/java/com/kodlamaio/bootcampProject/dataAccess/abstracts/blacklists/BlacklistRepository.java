package com.kodlamaio.bootcampProject.dataAccess.abstracts.blacklists;

import com.kodlamaio.bootcampProject.entities.blacklists.Blacklist;
import com.kodlamaio.bootcampProject.entities.users.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepository extends JpaRepository<Blacklist,Integer> {
    Applicant findByApplicantId(int apllicantId);
    boolean existsBlacklistByApplicantId(int id);
}
