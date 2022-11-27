package com.kodlamaio.bootcampProject.business.responses.blacklists;

import com.kodlamaio.bootcampProject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBlacklistResponse {
    private int id;
    private LocalDate date;
    private String reason;
    private Applicant applicant;
}
