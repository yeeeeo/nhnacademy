package com.nhnacademy.residentmanage.utils;

import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressModifyRequest;
import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressRegisterRequest;
import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressResponse;
import com.nhnacademy.residentmanage.entity.Household;
import com.nhnacademy.residentmanage.entity.HouseholdMovementAddress;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class HouseholdMovementAddressUtils {
    public HouseholdMovementAddress HouseholdMovementAddressRegisterRequestToHouseholdMovementAddress(long householdSerialNumber, HouseholdMovementAddressRegisterRequest request, Household household){
        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(request.getHouseMovementReportDate(), formatter);
        householdMovementAddress.setPk(new HouseholdMovementAddress.Pk(householdSerialNumber, date));
        householdMovementAddress.setHousehold(household);
        householdMovementAddress.setHouseMovementAddress(request.getHouseMovementAddress());
        householdMovementAddress.setLastAddressYn(request.getLastAddressYn());
        return householdMovementAddress;
    }
    public HouseholdMovementAddressResponse householdMovementAddressToHouseholdMovementAddressResponse(HouseholdMovementAddress householdMovementAddress){
        HouseholdMovementAddressResponse response = new HouseholdMovementAddressResponse();
        response.setHouseholdSerialNumber(householdMovementAddress.getPk().getHouseholdSerialNumber());
        response.setHouseMovementReportDate(householdMovementAddress.getPk().getHouseMovementReportDate());
        response.setHouseMovementAddress(householdMovementAddress.getHouseMovementAddress());
        response.setLastAddressYn(householdMovementAddress.getLastAddressYn());
        return response;
    }

    public HouseholdMovementAddress householdMovementAddressModifyRequestToHouseholdMovementAddress(HouseholdMovementAddress householdMovementAddress, HouseholdMovementAddressModifyRequest request){
        if (Objects.nonNull(request.getHouseMovementReportDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate date = LocalDate.parse(request.getHouseMovementReportDate(), formatter);
            householdMovementAddress.setPk(new HouseholdMovementAddress.Pk(householdMovementAddress.getPk().getHouseholdSerialNumber(), date));
        }
        if (Objects.nonNull(request.getHouseMovementAddress())){
            householdMovementAddress.setHouseMovementAddress(request.getHouseMovementAddress());
        }
        return householdMovementAddress;
    }
}
