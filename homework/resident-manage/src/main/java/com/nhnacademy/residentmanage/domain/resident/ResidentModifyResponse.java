package com.nhnacademy.residentmanage.domain.resident;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ResidentModifyResponse {
    private long residentSerialNumber;
    private String name;
    private String registrationNumber;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDate;
    private String birthPlace;
    private String registrationBaseAddress;
}
