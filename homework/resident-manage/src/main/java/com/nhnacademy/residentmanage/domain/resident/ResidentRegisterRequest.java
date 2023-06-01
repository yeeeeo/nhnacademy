package com.nhnacademy.residentmanage.domain.resident;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ResidentRegisterRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String registrationNumber;
    @NotBlank
    private String gender;
    @NotBlank
    private String birthDate;
    @NotBlank
    private String birthPlace;
    @NotBlank
    private String registrationBaseAddress;
}
