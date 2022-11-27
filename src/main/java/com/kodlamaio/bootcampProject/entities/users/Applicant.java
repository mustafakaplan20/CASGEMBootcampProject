package com.kodlamaio.bootcampProject.entities.users;

import javax.persistence.*;

import com.kodlamaio.bootcampProject.entities.applications.Application;
import com.kodlamaio.bootcampProject.entities.blacklists.Blacklist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="applicants")
public class Applicant extends User{

	@Column(name="about")
	private String about;

	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;

	@OneToMany(mappedBy = "applicant")
	private List<Blacklist> blacklists;



}
