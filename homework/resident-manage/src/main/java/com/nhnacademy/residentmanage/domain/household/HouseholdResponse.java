package com.nhnacademy.residentmanage.domain.household;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class HouseholdResponse {
    private long householdSerialNumber;
    private String householdName;
    private String householdRegistrationNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate householdCompositionDate;
    private String householdCompositionReason;
    private String currentHouseMovementAddress;
}
