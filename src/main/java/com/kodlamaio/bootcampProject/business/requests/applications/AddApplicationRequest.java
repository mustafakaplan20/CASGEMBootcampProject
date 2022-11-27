package com.kodlamaio.bootcampProject.business.requests.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddApplicationRequest {
    @NotNull
    private int bootcampId;
    @NotNull
    private int applicantId;
    @NotNull
    private int state;
}
