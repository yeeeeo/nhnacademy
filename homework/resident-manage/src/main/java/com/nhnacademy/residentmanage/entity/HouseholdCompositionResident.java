package com.nhnacademy.residentmanage.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Household_Composition_Resident")
public class HouseholdCompositionResident {
    @EmbeddedId
    private Pk pk;

    @MapsId(value = "householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @MapsId(value = "residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private long householdSerialNumber;
        @Column(name = "resident_serial_number")
        private String residentSerialNumber;
    }

    @Column(name = "report_date")
    private LocalDate reportDate;
    @Column(name = "household_relationship_code")
    private String householdRelationshipCode;
    @Column(name = "household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode;

}
