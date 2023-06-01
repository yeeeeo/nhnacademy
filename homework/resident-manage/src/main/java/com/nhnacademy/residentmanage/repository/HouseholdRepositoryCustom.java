package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.entity.Household;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface HouseholdRepositoryCustom {
    List<Household> getHousehold(long householdSerialNumber);
}
