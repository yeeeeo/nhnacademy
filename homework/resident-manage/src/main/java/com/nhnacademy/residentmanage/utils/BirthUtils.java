package com.nhnacademy.residentmanage.utils;

import com.nhnacademy.residentmanage.domain.birth.BirthModifyRequest;
import com.nhnacademy.residentmanage.domain.birth.BirthRegisterRequest;
import com.nhnacademy.residentmanage.domain.birth.BirthResponse;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipRegisterRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentRegisterRequest;
import com.nhnacademy.residentmanage.entity.BirthDeathReportResident;
import com.nhnacademy.residentmanage.entity.Resident;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

public class BirthUtils {
    public ResidentRegisterRequest birthRegisterRequestToResidentRegisterRequest(BirthRegisterRequest request){
        Random random = new Random();
        StringBuilder sb = new StringBuilder(14);
        sb.append(request.getBirthDate().substring(2, 8));
        sb.append("-");
        sb.append(request.getBirthGender().equals("남") ? 3 : 4);
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        String registrationNumber = sb.toString();

        ResidentRegisterRequest birthResident = new ResidentRegisterRequest();
        birthResident.setName(request.getBirthName());
        birthResident.setRegistrationNumber(registrationNumber);
        birthResident.setGender(request.getBirthGender());
        birthResident.setBirthDate(request.getBirthDate());
        birthResident.setBirthPlace(request.getBirthPlace());
        birthResident.setRegistrationBaseAddress(request.getRegistrationBaseAddress());

        return birthResident;
    }

    public BirthDeathReportResident residentToBirthDeathReportResident(Resident birthResident, Resident reportResident, BirthRegisterRequest birth){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate birthReportDate = LocalDate.parse(birth.getBirthReportDate(), formatter);
        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
        birthDeathReportResident.setPk(new BirthDeathReportResident.Pk(birthResident.getResidentSerialNumber(), "출생"));
        birthDeathReportResident.setResident(birthResident);
        birthDeathReportResident.setReportResident(reportResident);
        birthDeathReportResident.setBirthDeathReportDate(birthReportDate);
        birthDeathReportResident.setBirthReportQualificationsCode(birth.getReportRelationShip());
        birthDeathReportResident.setPhoneNumber(birth.getReportPhoneNumber());
        if (Objects.nonNull(birth.getReportEmailAddress())){
            birthDeathReportResident.setEmailAddress(birth.getReportEmailAddress());
        }
        return birthDeathReportResident;
    }

    public FamilyRelationshipRegisterRequest residentToFamilyRelationshipRegisterRequest(Resident familyResident, String relationShip){
        FamilyRelationshipRegisterRequest familyRelationshipRegisterRequest = new FamilyRelationshipRegisterRequest();
        familyRelationshipRegisterRequest.setFamilySerialNumber(familyResident.getResidentSerialNumber());
        familyRelationshipRegisterRequest.setRelationShip(relationShip);
        return familyRelationshipRegisterRequest;
    }

    public BirthResponse birthDeathReportResidentToBirthResponse(BirthDeathReportResident birthDeathReportResident){
        BirthResponse response = new BirthResponse();
        response.setType(birthDeathReportResident.getPk().getBirthDeathTypeCode());
        response.setBirthName(birthDeathReportResident.getResident().getName());
        response.setReportName(birthDeathReportResident.getReportResident().getName());
        response.setBirthReportDate(birthDeathReportResident.getBirthDeathReportDate());
        response.setReportRelationShip(birthDeathReportResident.getBirthReportQualificationsCode());
        response.setReportEmailAddress(birthDeathReportResident.getEmailAddress());
        response.setReportPhoneNumber(birthDeathReportResident.getPhoneNumber());
        return response;
    }

    public BirthDeathReportResident birthModifyRequestToBirthDeathReportResident(BirthDeathReportResident birthDeathReportResident, BirthModifyRequest request){
        if (Objects.nonNull(request.getBirthReportDate())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate birthReportDate = LocalDate.parse(request.getBirthReportDate(), formatter);
            birthDeathReportResident.setBirthDeathReportDate(birthReportDate);
        }
        if (Objects.nonNull(request.getReportRelationShip())){
            birthDeathReportResident.setBirthReportQualificationsCode(request.getReportRelationShip());
        }
        if (Objects.nonNull(request.getReportEmailAddress())){
            birthDeathReportResident.setEmailAddress(request.getReportEmailAddress());
        }
        if (Objects.nonNull(request.getReportPhoneNumber())){
            birthDeathReportResident.setPhoneNumber(request.getReportPhoneNumber());
        }

        return birthDeathReportResident;
    }

    public ResidentModifyRequest birthModifyRequestToBirthResidentModifyRequest(BirthModifyRequest request){
        ResidentModifyRequest residentModifyRequest = new ResidentModifyRequest();
        if (Objects.nonNull(request.getBirthName())){
            residentModifyRequest.setName(request.getBirthName());
        }
        if (Objects.nonNull(request.getBirthGender())){
            residentModifyRequest.setGender(request.getBirthGender());
        }
        if (Objects.nonNull(request.getBirthDate())){
            residentModifyRequest.setBirthDate(request.getBirthDate());
        }
        if (Objects.nonNull(request.getBirthPlace())){
            residentModifyRequest.setBirthPlace(request.getBirthPlace());
        }
        if (Objects.nonNull(request.getRegistrationBaseAddress())){
            residentModifyRequest.setRegistrationBaseAddress(request.getRegistrationBaseAddress());
        }
        return residentModifyRequest;
    }

}
