package com.kodlamaio.bootcampProject.business.requests.applicants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddApplicantRequest {

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	private String email;
	private String password;
	private String about;
	@Size(min=11,max=11,message = "Please Check Your National ID!")
	private String nationalId;
}
