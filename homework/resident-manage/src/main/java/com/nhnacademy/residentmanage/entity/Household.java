package com.nhnacademy.residentmanage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Household")
public class Household {
    @Id
    @Column(name = "household_serial_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long householdSerialNumber;

    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident householdResident;

    @Column(name = "household_composition_date")
    private LocalDate householdCompositionDate;
    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;
    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

    @OneToMany(mappedBy = "household")
    private List<HouseholdMovementAddress> householdMovementAddresses;
    @OneToMany(mappedBy = "household")
    private List<HouseholdCompositionResident> householdCompositionResidents;
}
