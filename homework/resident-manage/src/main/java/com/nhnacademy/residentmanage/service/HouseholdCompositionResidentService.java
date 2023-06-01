package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.domain.household_composition_resident.HouseholdCompositionResidentDto;
import com.nhnacademy.residentmanage.entity.HouseholdCompositionResident;
import com.nhnacademy.residentmanage.repository.HouseholdCompositionResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseholdCompositionResidentService {
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;
    public List<HouseholdCompositionResidentDto> getHouseholdCompositionResidentDto(long householdSerialNumber){
        return householdCompositionResidentRepository.getHouseholdCompositionResidentDto(householdSerialNumber);
    }
}
