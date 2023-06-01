package com.nhnacademy.residentmanage.domain.birth;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BirthResponse {
    private String type;
    private String birthName;
    private String reportName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthReportDate;
    private String reportRelationShip;
    private String reportEmailAddress;
    private String reportPhoneNumber;
}
