package com.kodlamaio.bootcampProject.business.requests.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
	private int userId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	private String email;
	@NotNull
	@Pattern(regexp = "/^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$/",message = "Your Password Should Contain Minimum 8 characters, at least 1 letter and 1 number")
	private String password;
	private String position;
	@Size(min=11,max=11,message = "Please Check Your National ID!")
	private String nationalId;
}
