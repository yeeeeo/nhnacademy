package com.nhnacademy.residentmanage.utils;

import com.nhnacademy.residentmanage.domain.birth.BirthModifyRequest;
import com.nhnacademy.residentmanage.domain.death.DeathModifyRequest;
import com.nhnacademy.residentmanage.domain.death.DeathRegisterRequest;
import com.nhnacademy.residentmanage.domain.death.DeathResponse;
import com.nhnacademy.residentmanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.residentmanage.entity.BirthDeathReportResident;
import com.nhnacademy.residentmanage.entity.Resident;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DeathUtils {
    public BirthDeathReportResident deathRegisterRequestToBirthDeathReportResident(Resident deathResident, Resident reportResident, DeathRegisterRequest request){
        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
        birthDeathReportResident.setPk(new BirthDeathReportResident.Pk(deathResident.getResidentSerialNumber(), "사망"));
        birthDeathReportResident.setResident(deathResident);
        birthDeathReportResident.setReportResident(reportResident);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate birthReportDate = LocalDate.parse(request.getDeathReportDate(), formatter);
        birthDeathReportResident.setBirthDeathReportDate(birthReportDate);
        birthDeathReportResident.setDeathReportQualificationsCode(request.getReportRelationShip());
        if (Objects.nonNull(request.getReportEmailAddress())){
            birthDeathReportResident.setEmailAddress(request.getReportEmailAddress());
        }
        birthDeathReportResident.setPhoneNumber(request.getReportPhoneNumber());
        return birthDeathReportResident;
    }

    public DeathResponse birthDeathReportResidentToDeathResponse(BirthDeathReportResident birthDeathReportResident){
        DeathResponse deathResponse = new DeathResponse();
        deathResponse.setType(birthDeathReportResident.getPk().getBirthDeathTypeCode());
        deathResponse.setDeathName(birthDeathReportResident.getResident().getName());
        deathResponse.setReportName(birthDeathReportResident.getReportResident().getName());
        deathResponse.setDeathReportDate(birthDeathReportResident.getBirthDeathReportDate());
        deathResponse.setReportRelationShip(birthDeathReportResident.getDeathReportQualificationsCode());
        deathResponse.setReportEmailAddress(birthDeathReportResident.getEmailAddress());
        deathResponse.setReportPhoneNumber(birthDeathReportResident.getPhoneNumber());
        return deathResponse;
    }

    public BirthDeathReportResident DeathModifyRequestToBirthDeathReportResident(BirthDeathReportResident birthDeathReportResident, DeathModifyRequest request, Resident deathResident){
        if (Objects.nonNull(request.getDeathReportDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate deathReportDate = LocalDate.parse(request.getDeathReportDate(), formatter);
            birthDeathReportResident.setBirthDeathReportDate(deathReportDate);
        }
        if (Objects.nonNull(request.getDeathName())){
            deathResident.setName(request.getDeathName());
            birthDeathReportResident.setResident(deathResident);
        }
        if (Objects.nonNull(request.getDeathRegistrationNumber())){
            deathResident.setResidentRegistrationNumber(request.getDeathRegistrationNumber());
            birthDeathReportResident.setResident(deathResident);
        }
        if (Objects.nonNull(request.getDeathDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime deathDate = LocalDateTime.parse(request.getDeathDate(), formatter);
            deathResident.setDeathDate(deathDate);
            birthDeathReportResident.setResident(deathResident);
        }
        if (Objects.nonNull(request.getDeathPlace())){
            deathResident.setDeathPlaceCode(request.getDeathPlace());
            birthDeathReportResident.setResident(deathResident);
        }
        if (Objects.nonNull(request.getDeathPlaceAddress())){
            deathResident.setDeathPlaceAddress(request.getDeathPlaceAddress());
            birthDeathReportResident.setResident(deathResident);
        }
        if (Objects.nonNull(request.getReportRelationShip())){
            birthDeathReportResident.setDeathReportQualificationsCode(request.getReportRelationShip());
        }
        if (Objects.nonNull(request.getReportEmailAddress())){
            birthDeathReportResident.setEmailAddress(request.getReportEmailAddress());
        }
        if (Objects.nonNull(request.getReportPhoneNumber())){
            birthDeathReportResident.setPhoneNumber(request.getReportPhoneNumber());
        }
        return birthDeathReportResident;
    }

    public ResidentModifyRequest deathModifyRequestToResidentModifyRequest(DeathModifyRequest request){
        ResidentModifyRequest residentModifyRequest = new ResidentModifyRequest();
        if (Objects.nonNull(request.getDeathName())){
            residentModifyRequest.setName(request.getDeathName());
        }
        if (Objects.nonNull(request.getDeathRegistrationNumber())){
            residentModifyRequest.setRegistrationNumber(request.getDeathRegistrationNumber());
        }
        if (Objects.nonNull(request.getDeathDate())){
            residentModifyRequest.setDeathDate(request.getDeathDate());
        }
        if (Objects.nonNull(request.getDeathPlace())){
            residentModifyRequest.setDeathPlace(request.getDeathPlace());
        }
        if (Objects.nonNull(request.getDeathPlaceAddress())){
            residentModifyRequest.setDeathPlaceAddress(request.getDeathPlaceAddress());
        }
        return residentModifyRequest;
    }
}
