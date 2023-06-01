package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressDto;
import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressModifyRequest;
import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressRegisterRequest;
import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressResponse;
import com.nhnacademy.residentmanage.entity.Household;
import com.nhnacademy.residentmanage.entity.HouseholdMovementAddress;
import com.nhnacademy.residentmanage.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.residentmanage.utils.HouseholdMovementAddressUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class HouseholdMovementAddressService {
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;
    private final HouseholdService householdService;
    private HouseholdMovementAddressUtils householdMovementAddressUtils = new HouseholdMovementAddressUtils();

    public List<HouseholdMovementAddressDto> getHouseholdMovementAddressDto(long householdSerialNumber){
        return householdMovementAddressRepository.getHouseholdMovementAddressDto(householdSerialNumber);
    }
    @Transactional
    public HouseholdMovementAddressResponse registerHouseholdMovementAddress(long householdSerialNumber, HouseholdMovementAddressRegisterRequest request){
        householdMovementAddressRepository.setLastAddressNo();
        Household household = householdService.getHousehold(householdSerialNumber);
        HouseholdMovementAddress householdMovementAddress = householdMovementAddressUtils.HouseholdMovementAddressRegisterRequestToHouseholdMovementAddress(householdSerialNumber, request, household);
        householdMovementAddressRepository.save(householdMovementAddress);
        return householdMovementAddressUtils.householdMovementAddressToHouseholdMovementAddressResponse(householdMovementAddress);
    }

    @Transactional
    public HouseholdMovementAddressResponse modifyHouseholdMovementAddress(long householdSerialNumber, LocalDate reportDate, HouseholdMovementAddressModifyRequest request){
        HouseholdMovementAddress householdMovementAddress = householdMovementAddressRepository.getHouseholdMovementAddress(householdSerialNumber, reportDate);
        householdMovementAddress = householdMovementAddressUtils.householdMovementAddressModifyRequestToHouseholdMovementAddress(householdMovementAddress, request);
        householdMovementAddressRepository.saveAndFlush(householdMovementAddress);
        return householdMovementAddressUtils.householdMovementAddressToHouseholdMovementAddressResponse(householdMovementAddress);
    }

    @Transactional
    public void deleteHouseholdMovementAddress(long householdSerialNumber, LocalDate reportDate){
        HouseholdMovementAddress householdMovementAddress = householdMovementAddressRepository.getHouseholdMovementAddress(householdSerialNumber, reportDate);
        householdMovementAddressRepository.delete(householdMovementAddress);
    }
}
