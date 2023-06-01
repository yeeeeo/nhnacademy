package com.nhnacademy.residentmanage.domain.death;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DeathResponse {
    private String type;
    private String deathName;
    private String reportName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deathReportDate;
    private String reportRelationShip;
    private String reportEmailAddress;
    private String reportPhoneNumber;
}
