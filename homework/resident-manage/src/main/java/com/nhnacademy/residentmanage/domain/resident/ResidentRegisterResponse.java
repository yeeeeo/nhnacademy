package com.nhnacademy.residentmanage.domain.resident;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResidentRegisterResponse {
    private long residentSerialNumber;
    private String name;
}
