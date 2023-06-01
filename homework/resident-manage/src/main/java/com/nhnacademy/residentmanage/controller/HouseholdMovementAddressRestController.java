package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressModifyRequest;
import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressRegisterRequest;
import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressResponse;
import com.nhnacademy.residentmanage.exception.ValidationFailedException;
import com.nhnacademy.residentmanage.service.HouseholdMovementAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/household/{householdSerialNumber}/movement")
@RequiredArgsConstructor
public class HouseholdMovementAddressRestController {
    private final HouseholdMovementAddressService householdMovementAddressService;

    @PostMapping
    public HouseholdMovementAddressResponse registerHouseholdMovementAddress(@PathVariable("householdSerialNumber") long householdSerialNumber,
                                                                             @Valid @RequestBody HouseholdMovementAddressRegisterRequest householdMovementAddress,
                                                                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return householdMovementAddressService.registerHouseholdMovementAddress(householdSerialNumber, householdMovementAddress);
    }
    @PutMapping("/{reportDate}")
    public HouseholdMovementAddressResponse modifyHouseholdMovementAddress(@PathVariable("householdSerialNumber") long householdSerialNumber,
                                                                           @PathVariable("reportDate") String reportDate,
                                                                           @Valid @RequestBody HouseholdMovementAddressModifyRequest householdMovementAddress,
                                                                           BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(reportDate, formatter);
        return householdMovementAddressService.modifyHouseholdMovementAddress(householdSerialNumber, date, householdMovementAddress);
    }

    @DeleteMapping("/{reportDate}")
    public void deleteHouseholdMovementAddress(@PathVariable("householdSerialNumber") long householdSerialNumber,
                                               @PathVariable("reportDate") String reportDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(reportDate, formatter);
        householdMovementAddressService.deleteHouseholdMovementAddress(householdSerialNumber, date);
    }
}
