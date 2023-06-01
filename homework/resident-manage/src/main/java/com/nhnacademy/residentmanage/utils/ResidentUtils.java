package com.nhnacademy.residentmanage.utils;

import com.nhnacademy.residentmanage.domain.death.DeathRegisterRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentModifyResponse;
import com.nhnacademy.residentmanage.domain.resident.ResidentRegisterRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentRegisterResponse;
import com.nhnacademy.residentmanage.entity.Resident;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ResidentUtils {
    public Resident residentRegisterRequestToResident(ResidentRegisterRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime birthDate = LocalDateTime.parse(request.getBirthDate(), formatter);

        Resident resident = new Resident();
        resident.setName(request.getName());
        resident.setResidentRegistrationNumber(request.getRegistrationNumber());
        resident.setGenderCode(request.getGender());
        resident.setBirthDate(birthDate);
        resident.setBirthPlaceCode(request.getBirthPlace());
        resident.setRegistrationBaseAddress(request.getRegistrationBaseAddress());

        return resident;
    }

    public ResidentRegisterResponse residentToResidentRegisterResponse(Resident resident){
        ResidentRegisterResponse responseResident = new ResidentRegisterResponse();
        responseResident.setResidentSerialNumber(resident.getResidentSerialNumber());
        responseResident.setName(resident.getName());
        return responseResident;
    }

    public ResidentModifyResponse residentToResidentModifyResponse(Resident resident){
        ResidentModifyResponse responseResident = new ResidentModifyResponse();
        responseResident.setResidentSerialNumber(resident.getResidentSerialNumber());
        responseResident.setName(resident.getName());
        responseResident.setRegistrationNumber(resident.getResidentRegistrationNumber());
        responseResident.setGender(resident.getGenderCode());
        responseResident.setBirthDate(resident.getBirthDate());
        responseResident.setBirthPlace(resident.getBirthPlaceCode());
        responseResident.setRegistrationBaseAddress(resident.getRegistrationBaseAddress());
        return responseResident;
    }

    public Resident residentModifyRequestToResident(Resident resident, ResidentModifyRequest request){
        if (Objects.nonNull(request.getName())){
            resident.setName(request.getName());
        }
        if (Objects.nonNull(request.getRegistrationNumber())){
            resident.setResidentRegistrationNumber(request.getRegistrationNumber());
        }
        if (Objects.nonNull(request.getGender())){
            resident.setGenderCode(request.getGender());
        }
        if (Objects.nonNull(request.getBirthDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime birthReportDate = LocalDateTime.parse(request.getBirthDate(), formatter);
            resident.setBirthDate(birthReportDate);
        }
        if (Objects.nonNull(request.getBirthPlace())){
            resident.setBirthPlaceCode(request.getBirthPlace());
        }
        if (Objects.nonNull(request.getRegistrationBaseAddress())){
            resident.setRegistrationBaseAddress(request.getRegistrationBaseAddress());
        }
        if (Objects.nonNull(request.getDeathDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime deathDate = LocalDateTime.parse(request.getDeathDate(), formatter);
            resident.setDeathDate(deathDate);
        }
        if (Objects.nonNull(request.getDeathPlace())){
            resident.setDeathPlaceCode(request.getDeathPlace());
        }
        if (Objects.nonNull(request.getDeathPlaceAddress())){
            resident.setDeathPlaceAddress(request.getDeathPlaceAddress());
        }
        return resident;
    }

    public Resident deathRegisterRequestToResident(Resident deathResident, DeathRegisterRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime deathDate = LocalDateTime.parse(request.getDeathDate(), formatter);
        deathResident.setDeathDate(deathDate);
        deathResident.setDeathPlaceCode(request.getDeathPlace());
        deathResident.setDeathPlaceAddress(request.getDeathPlaceAddress());
        return deathResident;
    }
}
