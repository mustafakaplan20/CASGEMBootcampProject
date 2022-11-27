package com.kodlamaio.bootcampProject.entities.users;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name = "dateOfBirth")
	private LocalDate dateOfBirth;
	@Column(name="nationalId")
	private String nationalId;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;



}
