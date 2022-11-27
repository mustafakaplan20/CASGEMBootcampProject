package com.kodlamaio.bootcampProject.entities.users;

import javax.persistence.*;

import com.kodlamaio.bootcampProject.entities.bootcamps.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="instructors")
public class Instructor extends User{

	@Column(name="companyName")
	private String companyName;

	@OneToMany(mappedBy = "instructor")
	private List<Bootcamp> bootcamps;


}
