package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.domain.household_composition_resident.HouseholdCompositionResidentDto;
import com.nhnacademy.residentmanage.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {
    @Query(value = "select hcr " +
            "from HouseholdCompositionResident hcr " +
            "join Household h on hcr.household.householdSerialNumber = h.householdSerialNumber " +
            "join Resident r on hcr.resident.residentSerialNumber = r.residentSerialNumber " +
            "where hcr.household.householdSerialNumber = ?1")
    List<HouseholdCompositionResidentDto> getHouseholdCompositionResidentDto(long householdSerialNumber);
}
