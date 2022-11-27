package com.kodlamaio.bootcampProject.business.requests.bootcamps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {
    private int instructorId;
    private String name;
    private int state;
    private LocalDate startDate;
    private LocalDate endDate;
}
