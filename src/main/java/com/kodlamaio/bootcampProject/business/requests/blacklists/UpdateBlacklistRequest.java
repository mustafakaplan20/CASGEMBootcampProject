package com.kodlamaio.bootcampProject.business.requests.blacklists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistRequest {
    private int id;
    @NotNull(message = "Please Control The Date!")
    private LocalDate date;
    @NotBlank(message = "Please Write a Reason!")
    @Length(min = 5, max = 50, message = "Please Check Your Written Reason!")
    private String reason;
    private int applicantId;
}
