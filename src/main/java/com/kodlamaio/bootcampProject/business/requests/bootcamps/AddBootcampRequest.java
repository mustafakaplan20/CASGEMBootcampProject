package com.kodlamaio.bootcampProject.business.requests.bootcamps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBootcampRequest {
    @NotNull
    private int instructorId;
    @NotNull
    private String name;
    private int state;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
}
