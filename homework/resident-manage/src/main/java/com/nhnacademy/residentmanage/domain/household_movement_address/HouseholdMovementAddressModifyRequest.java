package com.nhnacademy.residentmanage.domain.household_movement_address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseholdMovementAddressModifyRequest {
    private String houseMovementReportDate;
    private String houseMovementAddress;
}
