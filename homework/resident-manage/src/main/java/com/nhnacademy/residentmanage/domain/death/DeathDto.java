package com.nhnacademy.residentmanage.domain.death;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DeathDto {
    LocalDate getBirthDeathReportDate();
    DeathDto.Resident getResident();
    DeathDto.ReportResident getReportResident();
    String getBirthReportQualificationsCode();
    String getEmailAddress();
    String getPhoneNumber();
    interface Resident{
        String getName();
        String getResidentRegistrationNumber();
        LocalDateTime getDeathDate();
        String getDeathPlaceCode();
        String getDeathPlaceAddress();
    }
    interface ReportResident{
        String getName();
        String getResidentRegistrationNumber();
    }
}
