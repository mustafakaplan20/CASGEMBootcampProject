package com.kodlamaio.bootcampProject.business.responses.instructors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorResponse {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String companyName;
}
