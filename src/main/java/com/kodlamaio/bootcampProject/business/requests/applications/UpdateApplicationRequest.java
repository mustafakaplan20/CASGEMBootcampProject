package com.kodlamaio.bootcampProject.business.requests.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicationRequest {
    @NotNull
    private int bootcampId;
    @NotNull
    private int userId;
    @NotNull
    private int state;
}
