package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.birth.BirthRegisterRequest;
import com.nhnacademy.residentmanage.domain.household.HouseholdModifyRequest;
import com.nhnacademy.residentmanage.domain.household.HouseholdRegisterRequest;
import com.nhnacademy.residentmanage.domain.household.HouseholdResponse;
import com.nhnacademy.residentmanage.entity.Household;
import com.nhnacademy.residentmanage.exception.ValidationFailedException;
import com.nhnacademy.residentmanage.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/household")
@RequiredArgsConstructor
public class HouseholdRestController {
    private final HouseholdService householdService;

    @PostMapping
    public HouseholdResponse registerHousehold(@Valid @RequestBody HouseholdRegisterRequest household,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return householdService.registerHousehold(household);
    }

    @PutMapping("/{householdSerialNumber}")
    public HouseholdResponse modifyHousehold(@PathVariable("householdSerialNumber") long householdSerialNumber,
                                             @Valid @RequestBody HouseholdModifyRequest household,
                                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return householdService.modifyHousehold(householdSerialNumber, household);
    }

    @DeleteMapping("/{householdSerialNumber}")
    public void deleteHousehold(@PathVariable("householdSerialNumber") long householdSerialNumber){
        householdService.deleteHousehold(householdSerialNumber);
    }
}
