package com.nhnacademy.residentmanage.domain.household_movement_address;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class HouseholdMovementAddressResponse {
    private long householdSerialNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate houseMovementReportDate;
    private String houseMovementAddress;
    private String lastAddressYn;
}
