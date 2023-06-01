package com.nhnacademy.residentmanage.domain.resident;

import com.nhnacademy.residentmanage.entity.BirthDeathReportResident;

public interface ResidentDto {
    long getResidentSerialNumber();
    String getName();
    String getResidentRegistrationNumber();
    String getGenderCode();
    BirthDeathReportResident getBirthDeathResidents();
}
