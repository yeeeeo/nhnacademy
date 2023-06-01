package com.nhnacademy.residentmanage.domain.household;

import com.nhnacademy.residentmanage.entity.Household;
import com.nhnacademy.residentmanage.entity.HouseholdMovementAddress;

import java.time.LocalDate;
import java.util.List;

public interface HouseholdDto {
    long getHouseholdSerialNumber();
    HouseholdDto.HouseholdResident getHouseholdResident();
    LocalDate getHouseholdCompositionDate();
    String getHouseholdCompositionReasonCode();
    interface HouseholdResident {
        String getName();
    }

}
