package com.nhnacademy.residentmanage.domain.household;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class HouseholdRegisterRequest {
    @NotBlank
    private String householdName;
    @NotBlank
    private String householdRegistrationNumber;
    @NotBlank
    private String householdCompositionDate;
    @NotBlank
    private String householdCompositionReason;
    @NotBlank
    private String currentHouseMovementAddress;
}
