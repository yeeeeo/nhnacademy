package com.nhnacademy.residentmanage.domain.family_relationship;

import com.nhnacademy.residentmanage.entity.Resident;

public interface FamilyDto {
    FamilyDto.FamilyResident getFamilyResident();
    String getFamilyRelationshipCode();
    interface FamilyResident{
        String getName();
        String getResidentRegistrationNumber();
    }

}
