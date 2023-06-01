package com.nhnacademy.residentmanage.domain.birth;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface BirthDto {
    LocalDate getBirthDeathReportDate();
    BirthDto.Resident getResident();
    BirthDto.ReportResident getReportResident();
    String getBirthReportQualificationsCode();
    String getEmailAddress();
    String getPhoneNumber();

    interface Resident{
        String getName();
        String getGenderCode();
        LocalDateTime getBirthDate();
        String getBirthPlaceCode();
        String getRegistrationBaseAddress();
    }
    interface ReportResident{
        String getName();
        String getResidentRegistrationNumber();

    }
}
