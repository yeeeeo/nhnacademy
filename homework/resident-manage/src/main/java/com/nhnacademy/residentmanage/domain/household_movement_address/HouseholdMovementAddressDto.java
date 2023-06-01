package com.nhnacademy.residentmanage.domain.household_movement_address;

import java.time.LocalDate;

public interface HouseholdMovementAddressDto {
    String getLastAddressYn();
    String getHouseMovementAddress();
    HouseholdMovementAddressDto.Pk getPk();
    interface Pk{
        LocalDate getHouseMovementReportDate();
    }
}
