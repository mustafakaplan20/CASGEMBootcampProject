package com.kodlamaio.bootcampProject.business.responses.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponse {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String position;
	private String nationalId;
}
