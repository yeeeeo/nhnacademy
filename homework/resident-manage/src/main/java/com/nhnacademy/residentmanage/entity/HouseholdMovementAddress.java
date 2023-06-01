package com.nhnacademy.residentmanage.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Household_Movement_Address")
public class HouseholdMovementAddress {
    @EmbeddedId
    private Pk pk;

    @MapsId(value = "householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private long householdSerialNumber;
        @Column(name = "house_movement_report_date")
        private LocalDate houseMovementReportDate;
    }

    @Column(name = "house_movement_address")
    private String houseMovementAddress;
    @Column(name = "last_address_yn")
    private String lastAddressYn;
}
