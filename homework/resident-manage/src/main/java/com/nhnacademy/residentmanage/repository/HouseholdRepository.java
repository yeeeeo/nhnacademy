package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.domain.household.HouseholdDto;
import com.nhnacademy.residentmanage.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdRepository extends JpaRepository<Household, Long>, HouseholdRepositoryCustom {
    @Query(value = "select h " +
            "from Household h " +
            "join Resident r on h.householdResident.residentSerialNumber = r.residentSerialNumber " +
            "where h.householdResident.residentSerialNumber = ?1")
    HouseholdDto getHouseholdDto(long serialNumber);
}
