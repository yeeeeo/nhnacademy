package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.domain.birth.BirthDto;
import com.nhnacademy.residentmanage.domain.birth.BirthModifyRequest;
import com.nhnacademy.residentmanage.domain.birth.BirthRegisterRequest;
import com.nhnacademy.residentmanage.domain.birth.BirthResponse;
import com.nhnacademy.residentmanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentRegisterRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentRegisterResponse;
import com.nhnacademy.residentmanage.entity.BirthDeathReportResident;
import com.nhnacademy.residentmanage.entity.Resident;
import com.nhnacademy.residentmanage.repository.BirthDeathRepository;
import com.nhnacademy.residentmanage.utils.BirthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class BirthService {
    private final BirthDeathRepository birthDeathRepository;
    private final ResidentService residentService;
    private final FamilyRelationshipService familyRelationshipService;
    private BirthUtils birthUtils = new BirthUtils();

    public BirthDeathReportResident getBirthResident(long serialNumber){
        return birthDeathRepository.getBirthDeathResident(serialNumber, "출생");
    }
    public BirthDto getBirthDto(long serialNumber){
        return birthDeathRepository.getBirthDto(serialNumber, "출생");
    }
    @Transactional
    public BirthResponse registerBirth(long serialNumber, BirthRegisterRequest birth){
        ResidentRegisterRequest birthResident = birthUtils.birthRegisterRequestToResidentRegisterRequest(birth);
        ResidentRegisterResponse registerResponse = residentService.registerResident(birthResident);
        Resident reportResident = residentService.getResidentBySerialNumber(serialNumber);
        Resident getBirthResident = residentService.getResidentBySerialNumber(registerResponse.getResidentSerialNumber());

        BirthDeathReportResident birthDeathReportResident = birthUtils.residentToBirthDeathReportResident(getBirthResident, reportResident, birth);
        birthDeathRepository.save(birthDeathReportResident);

        Resident father = residentService.getResidentByNameAndRegistrationNumber(birth.getFatherName(), birth.getFatherRegistrationNumber());
        Resident mother = residentService.getResidentByNameAndRegistrationNumber(birth.getMotherName(), birth.getMotherRegistrationNumber());

        familyRelationshipService.registerResident(getBirthResident.getResidentSerialNumber(),
                birthUtils.residentToFamilyRelationshipRegisterRequest(father, "father"));

        familyRelationshipService.registerResident(getBirthResident.getResidentSerialNumber(),
                birthUtils.residentToFamilyRelationshipRegisterRequest(mother, "mother"));

        familyRelationshipService.registerResident(father.getResidentSerialNumber(),
                birthUtils.residentToFamilyRelationshipRegisterRequest(getBirthResident, "child"));

        familyRelationshipService.registerResident(mother.getResidentSerialNumber(),
                birthUtils.residentToFamilyRelationshipRegisterRequest(getBirthResident, "child"));

        return birthUtils.birthDeathReportResidentToBirthResponse(birthDeathReportResident);
    }

    @Transactional
    public BirthResponse modifyBirth(long serialNumber, long targetSerialNumber, BirthModifyRequest request){
        BirthDeathReportResident birthDeathReportResident = birthUtils.birthModifyRequestToBirthDeathReportResident(
                birthDeathRepository.getBirthDeathReportResident(targetSerialNumber, serialNumber), request);
        birthDeathRepository.save(birthDeathReportResident);

        ResidentModifyRequest residentModifyRequest = birthUtils.birthModifyRequestToBirthResidentModifyRequest(request);
        residentService.modifyResident(targetSerialNumber, residentModifyRequest);

        return birthUtils.birthDeathReportResidentToBirthResponse(birthDeathReportResident);
    }

    @Transactional
    public void deleteBirth(long serialNumber, long targetSerialNumber){
        BirthDeathReportResident baseResident = birthDeathRepository.getBirthDeathReportResident(targetSerialNumber, serialNumber);
        birthDeathRepository.delete(baseResident);
    }
}
