package com.nhnacademy.residentmanage.domain.death;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class DeathModifyRequest {
    private String deathReportDate;
    private String deathName;
    private String deathRegistrationNumber;
    private String deathDate;
    private String deathPlace;
    private String deathPlaceAddress;
    private String reportRelationShip;
    private String reportEmailAddress;
    private String reportPhoneNumber;
}
