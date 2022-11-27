package com.kodlamaio.bootcampProject.business.requests.blacklists;

import com.kodlamaio.bootcampProject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBlacklistRequest {
    @NotNull(message = "Please Control The Date!")
    private LocalDate date;
    @NotBlank(message = "Please Write a Reason!")
    @Length(min = 5, max = 50, message = "Please Check Your Written Reason!")
    private String reason;
    private int applicantId;
}
