package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressDto;
import com.nhnacademy.residentmanage.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk> {
    @Query(value = "select hma " +
            "from HouseholdMovementAddress hma " +
            "join Household h on hma.household.householdSerialNumber = h.householdSerialNumber " +
            "where hma.household.householdSerialNumber = ?1 " +
            "and hma.pk.houseMovementReportDate = ?2")
    HouseholdMovementAddress getHouseholdMovementAddress(long householdSerialNumber, LocalDate houseMovementReportDate);

    @Modifying
    @Transactional
    @Query(value = "update HouseholdMovementAddress hma " +
            "set hma.lastAddressYn = 'N'")
    void setLastAddressNo();

    @Query(value = "select hma " +
            "from HouseholdMovementAddress hma " +
            "where hma.pk.householdSerialNumber = ?1 " +
            "order by hma.pk.houseMovementReportDate desc ")
    List<HouseholdMovementAddressDto> getHouseholdMovementAddressDto(long householdSerialNumber);
}
