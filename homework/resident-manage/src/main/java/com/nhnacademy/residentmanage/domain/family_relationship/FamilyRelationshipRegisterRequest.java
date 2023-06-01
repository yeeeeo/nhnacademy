package com.nhnacademy.residentmanage.domain.family_relationship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class FamilyRelationshipRegisterRequest {
    @NotNull
    private long familySerialNumber;
    @NotBlank
    private String relationShip;
}
