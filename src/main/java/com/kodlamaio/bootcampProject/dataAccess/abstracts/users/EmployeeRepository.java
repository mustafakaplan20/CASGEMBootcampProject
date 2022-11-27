package com.kodlamaio.bootcampProject.dataAccess.abstracts.users;

import com.kodlamaio.bootcampProject.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.users.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    Employee findByNationalId(String nationalId);

}
