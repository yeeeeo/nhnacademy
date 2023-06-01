package com.nhnacademy.residentmanage.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Family_Relationship")
public class FamilyRelationship {
    @EmbeddedId
    private Pk pk;

    @MapsId(value = "baseResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResident;

    @MapsId(value = "familyResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "family_resident_serial_number")
    private Resident familyResident;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "base_resident_serial_number")
        private long baseResidentSerialNumber;
        @Column(name = "family_resident_serial_number")
        private long familyResidentSerialNumber;
    }

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;
}
