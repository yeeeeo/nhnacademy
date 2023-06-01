package com.nhnacademy.residentmanage.domain.family_relationship;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public interface FamilyRelationshipDto {
    FamilyRelationshipDto.BaseResident getBaseResident();
    FamilyRelationshipDto.FamilyResident getFamilyResident();
    String getFamilyRelationshipCode();
    interface BaseResident{
        long getResidentSerialNumber();
        String getName();
        LocalDateTime getBirthDate();
        String getResidentRegistrationNumber();
        String getGenderCode();
        String getRegistrationBaseAddress();
    }
    interface FamilyResident{
        long getResidentSerialNumber();
        String getName();
        LocalDateTime getBirthDate();
        String getResidentRegistrationNumber();
        String getGenderCode();
        String getRegistrationBaseAddress();
    }
}
