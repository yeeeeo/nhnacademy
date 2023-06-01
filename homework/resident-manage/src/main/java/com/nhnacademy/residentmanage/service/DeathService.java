package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.domain.death.DeathDto;
import com.nhnacademy.residentmanage.domain.death.DeathModifyRequest;
import com.nhnacademy.residentmanage.domain.death.DeathRegisterRequest;
import com.nhnacademy.residentmanage.domain.death.DeathResponse;
import com.nhnacademy.residentmanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.residentmanage.entity.BirthDeathReportResident;
import com.nhnacademy.residentmanage.entity.Resident;
import com.nhnacademy.residentmanage.repository.BirthDeathRepository;
import com.nhnacademy.residentmanage.utils.BirthUtils;
import com.nhnacademy.residentmanage.utils.DeathUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class DeathService {
    private final BirthDeathRepository birthDeathRepository;
    private final ResidentService residentService;
    private DeathUtils deathUtils = new DeathUtils();

    public BirthDeathReportResident getDeathResident(long serialNumber){
        return birthDeathRepository.getBirthDeathResident(serialNumber, "사망");
    }
    public DeathDto getDeathDto(long serialNumber){
        return birthDeathRepository.getDeathDto(serialNumber, "사망");
    }
    @Transactional
    public DeathResponse registerDeath(long serialNumber, DeathRegisterRequest request){
        Resident deathResident = residentService.getResidentByName(request.getDeathName());
        Resident reportResident = residentService.getResidentBySerialNumber(serialNumber);
        BirthDeathReportResident birthDeathReportResident = deathUtils.deathRegisterRequestToBirthDeathReportResident(deathResident, reportResident, request);
        birthDeathRepository.save(birthDeathReportResident);

        residentService.modifyDeathResident(deathResident,request);

        return deathUtils.birthDeathReportResidentToDeathResponse(birthDeathReportResident);
    }

    @Transactional
    public DeathResponse modifyDeath(long serialNumber, long targetSerialNumber, DeathModifyRequest request){
        Resident deathResident = residentService.getResidentBySerialNumber(targetSerialNumber);
        BirthDeathReportResident birthDeathReportResident = deathUtils.DeathModifyRequestToBirthDeathReportResident(
                birthDeathRepository.getBirthDeathReportResident(targetSerialNumber, serialNumber), request, deathResident);
        birthDeathRepository.save(birthDeathReportResident);

        ResidentModifyRequest residentModifyRequest = deathUtils.deathModifyRequestToResidentModifyRequest(request);
        residentService.modifyResident(targetSerialNumber, residentModifyRequest);

        return deathUtils.birthDeathReportResidentToDeathResponse(birthDeathReportResident);
    }

    @Transactional
    public void deleteDeath(long serialNumber, long targetSerialNumber){
        BirthDeathReportResident birthDeathReportResident = birthDeathRepository.getBirthDeathReportResident(targetSerialNumber, serialNumber);
        birthDeathRepository.delete(birthDeathReportResident);
    }
}
