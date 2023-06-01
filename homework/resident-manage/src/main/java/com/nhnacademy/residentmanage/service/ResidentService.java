package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.domain.death.DeathRegisterRequest;
import com.nhnacademy.residentmanage.domain.resident.*;
import com.nhnacademy.residentmanage.entity.Resident;
import com.nhnacademy.residentmanage.repository.ResidentRepository;
import com.nhnacademy.residentmanage.utils.ResidentUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class ResidentService {
    private final ResidentRepository residentRepository;
    private ResidentUtils residentUtils = new ResidentUtils();

    public Resident getResidentBySerialNumber(long serialNumber){
        return residentRepository.findByResidentSerialNumber(serialNumber);
    }

    public Resident getResidentByNameAndRegistrationNumber(String name, String registrationNumber){
        return residentRepository.findByNameAndResidentRegistrationNumber(name, registrationNumber);
    }

    public Resident getResidentByName(String name){
        return residentRepository.findByName(name);
    }

    public Page<ResidentDto> getResidentPage(Pageable pageable){
        return residentRepository.getAllBy(pageable);
    }
    @Transactional
    public ResidentRegisterResponse registerResident(ResidentRegisterRequest request){
        Resident resident = residentUtils.residentRegisterRequestToResident(request);
        residentRepository.saveAndFlush(resident);
        return residentUtils.residentToResidentRegisterResponse(resident);
    }

    @Transactional
    public ResidentModifyResponse modifyResident(long serialNumber, ResidentModifyRequest request){
        Resident resident = getResidentBySerialNumber(serialNumber);
        resident = residentUtils.residentModifyRequestToResident(resident, request);
        residentRepository.saveAndFlush(resident);
        return residentUtils.residentToResidentModifyResponse(resident);
    }

    @Transactional
    public void modifyDeathResident(Resident deathResident, DeathRegisterRequest request){
        deathResident = residentUtils.deathRegisterRequestToResident(deathResident, request);
        residentRepository.saveAndFlush(deathResident);
    }
}
