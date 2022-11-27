package com.kodlamaio.bootcampProject.business.responses.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllApplicationResponse {
    private int id;
    private int bootcampId;
    private int applicantId;
    private int state;
}
