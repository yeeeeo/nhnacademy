package com.nhnacademy.residentmanage.domain.household;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HouseholdModifyRequest {
    private String householdCompositionDate;
    private String householdCompositionReason;
    private String currentHouseMovementAddress;
}
