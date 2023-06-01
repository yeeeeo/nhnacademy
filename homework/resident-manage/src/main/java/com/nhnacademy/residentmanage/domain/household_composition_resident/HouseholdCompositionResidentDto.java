package com.nhnacademy.residentmanage.domain.household_composition_resident;

import java.time.LocalDate;

public interface HouseholdCompositionResidentDto {
    HouseholdCompositionResidentDto.Resident getResident();
    String getHouseholdRelationshipCode();
    LocalDate getReportDate();
    String getHouseholdCompositionChangeReasonCode();
    interface Resident{
        String getName();
        String getResidentRegistrationNumber();
    }
}
