package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.entity.Household;
import com.nhnacademy.residentmanage.entity.QHousehold;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class HouseholdRepositoryImpl extends QuerydslRepositorySupport implements HouseholdRepositoryCustom{
    public HouseholdRepositoryImpl() {
        super(Household.class);
    }

    @Override
    public List<Household> getHousehold(long householdSerialNumber) {
        QHousehold household = QHousehold.household;
        return from(household)
                .where(household.householdSerialNumber.eq(householdSerialNumber))
                .select(household)
                .fetch();
    }
}
