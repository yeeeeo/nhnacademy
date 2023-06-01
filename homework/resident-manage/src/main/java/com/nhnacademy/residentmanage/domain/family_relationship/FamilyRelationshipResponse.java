package com.nhnacademy.residentmanage.domain.family_relationship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FamilyRelationshipResponse {
    private String baseResident;
    private String familyResident;
    private String relationShip;
}
