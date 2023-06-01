package com.nhnacademy.residentmanage.utils;

import com.nhnacademy.residentmanage.domain.household.HouseholdModifyRequest;
import com.nhnacademy.residentmanage.domain.household.HouseholdRegisterRequest;
import com.nhnacademy.residentmanage.domain.household.HouseholdResponse;
import com.nhnacademy.residentmanage.entity.Household;
import com.nhnacademy.residentmanage.entity.Resident;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class HouseholdUtils {
    public Household householdRegisterRequestToHousehold(HouseholdRegisterRequest request, Resident householdResident){
        Household household = new Household();
        household.setHouseholdResident(householdResident);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(request.getHouseholdCompositionDate(), formatter);
        household.setHouseholdCompositionDate(date);
        household.setHouseholdCompositionReasonCode(request.getHouseholdCompositionReason());
        household.setCurrentHouseMovementAddress(request.getCurrentHouseMovementAddress());
        return household;
    }

    public HouseholdResponse householdToHouseholdResponse(Household household){
        HouseholdResponse householdResponse = new HouseholdResponse();
        householdResponse.setHouseholdSerialNumber(household.getHouseholdSerialNumber());
        householdResponse.setHouseholdName(household.getHouseholdResident().getName());
        householdResponse.setHouseholdRegistrationNumber(household.getHouseholdResident().getResidentRegistrationNumber());
        householdResponse.setHouseholdCompositionDate(household.getHouseholdCompositionDate());
        householdResponse.setHouseholdCompositionReason(household.getHouseholdCompositionReasonCode());
        householdResponse.setCurrentHouseMovementAddress(household.getCurrentHouseMovementAddress());
        return householdResponse;
    }

    public Household householdModifyRequestToHousehold(Household household, HouseholdModifyRequest request){
        if (Objects.nonNull(request.getHouseholdCompositionDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate date = LocalDate.parse(request.getHouseholdCompositionDate(), formatter);
            household.setHouseholdCompositionDate(date);
        }
        if (Objects.nonNull(request.getHouseholdCompositionReason())){
            household.setHouseholdCompositionReasonCode(request.getHouseholdCompositionReason());
        }
        if (Objects.nonNull(request.getCurrentHouseMovementAddress())){
            household.setCurrentHouseMovementAddress(request.getCurrentHouseMovementAddress());
        }
        return household;
    }
}
