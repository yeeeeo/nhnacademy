package com.nhnacademy.residentmanage.domain.resident;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ResidentModifyRequest {
    private String name;
    private String registrationNumber;
    private String gender;
    private String birthDate;
    private String birthPlace;
    private String registrationBaseAddress;
    private String deathDate;
    private String deathPlace;
    private String deathPlaceAddress;
}
