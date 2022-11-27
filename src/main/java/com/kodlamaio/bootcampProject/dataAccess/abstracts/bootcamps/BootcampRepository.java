package com.kodlamaio.bootcampProject.dataAccess.abstracts.bootcamps;

import com.kodlamaio.bootcampProject.entities.bootcamps.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp,Integer> {
}
