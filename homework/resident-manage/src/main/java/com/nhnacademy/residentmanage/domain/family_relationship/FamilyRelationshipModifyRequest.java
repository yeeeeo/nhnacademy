package com.nhnacademy.residentmanage.domain.family_relationship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class FamilyRelationshipModifyRequest {
    @NotBlank
    private String relationShip;
}
