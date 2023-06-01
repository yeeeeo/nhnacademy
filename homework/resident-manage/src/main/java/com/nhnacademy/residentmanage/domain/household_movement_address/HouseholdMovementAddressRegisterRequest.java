package com.nhnacademy.residentmanage.domain.household_movement_address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class HouseholdMovementAddressRegisterRequest {
    @NotBlank
    private String houseMovementReportDate;
    @NotBlank
    private String houseMovementAddress;
    @NotBlank
    private String lastAddressYn;
}
