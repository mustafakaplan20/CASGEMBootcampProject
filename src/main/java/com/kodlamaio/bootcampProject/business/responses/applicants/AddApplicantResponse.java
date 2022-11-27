package com.kodlamaio.bootcampProject.business.responses.applicants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddApplicantResponse {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
	private String nationalId;
}
