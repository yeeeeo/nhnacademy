package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.domain.household.HouseholdDto;
import com.nhnacademy.residentmanage.domain.household.HouseholdModifyRequest;
import com.nhnacademy.residentmanage.domain.household.HouseholdRegisterRequest;
import com.nhnacademy.residentmanage.domain.household.HouseholdResponse;
import com.nhnacademy.residentmanage.entity.Household;
import com.nhnacademy.residentmanage.entity.Resident;
import com.nhnacademy.residentmanage.repository.HouseholdRepository;
import com.nhnacademy.residentmanage.utils.HouseholdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class HouseholdService {
    @Autowired
    private HouseholdRepository householdRepository;
    private final ResidentService residentService;
    private HouseholdUtils householdUtils = new HouseholdUtils();

    public Household getHousehold(long householdSerialNumber){
        return householdRepository.getHousehold(householdSerialNumber).get(0);
    }

    public HouseholdDto getHouseholdDto(long serialNumber){
        return householdRepository.getHouseholdDto(serialNumber);
    }
    @Transactional
    public HouseholdResponse registerHousehold(HouseholdRegisterRequest request){
        Resident householdResident = residentService.getResidentByNameAndRegistrationNumber(request.getHouseholdName(), request.getHouseholdRegistrationNumber());
        Household household = householdUtils.householdRegisterRequestToHousehold(request, householdResident);
        householdRepository.saveAndFlush(household);

        return householdUtils.householdToHouseholdResponse(household);
    }

    @Transactional
    public HouseholdResponse modifyHousehold(long householdSerialNumber, HouseholdModifyRequest request){
        Household household = householdRepository.getHousehold(householdSerialNumber).get(0);
        household = householdUtils.householdModifyRequestToHousehold(household, request);
        householdRepository.saveAndFlush(household);
        return householdUtils.householdToHouseholdResponse(household);
    }

    @Transactional
    public void deleteHousehold(long householdSerialNumber){
        Household household = householdRepository.getHousehold(householdSerialNumber).get(0);
        householdRepository.delete(household);
    }
}
