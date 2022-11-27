package com.kodlamaio.bootcampProject.business.responses.bootcamps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBootcampResponse {
    private int id;
    private String name;
    private String startDate;
    private String endDate;
    private int state;
    private int instructorId;
}
