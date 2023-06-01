package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.domain.family_relationship.*;
import com.nhnacademy.residentmanage.entity.FamilyRelationship;
import com.nhnacademy.residentmanage.entity.Resident;
import com.nhnacademy.residentmanage.repository.FamilyRelationshipRepository;
import com.nhnacademy.residentmanage.utils.FamilyRelationshipUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentService residentService;
    private FamilyRelationshipUtils familyRelationshipUtils = new FamilyRelationshipUtils();

    public List<FamilyRelationshipDto> getFamilyRelationshipList(long serialNumber){
        return familyRelationshipRepository.getFamilyRelationshipList(serialNumber);
    }

    public List<FamilyDto> getFamilyDto(long serialNumber){
        return familyRelationshipRepository.getFamilyDto(serialNumber);
    }

    @Transactional
    public FamilyRelationshipResponse registerResident(long serialNumber, FamilyRelationshipRegisterRequest request){
        Resident baseResident = residentService.getResidentBySerialNumber(serialNumber);
        Resident familyResident = residentService.getResidentBySerialNumber(request.getFamilySerialNumber());

        FamilyRelationship familyRelationship = familyRelationshipUtils.familyRelationshipRegisterRequestToFamilyRelationship(request, serialNumber, baseResident, familyResident);
        familyRelationshipRepository.saveAndFlush(familyRelationship);

        FamilyRelationship getFamilyRelationship = familyRelationshipRepository.getFamilyRelationship(familyRelationship.getBaseResident().getResidentSerialNumber(),
                                                                                                familyRelationship.getFamilyResident().getResidentSerialNumber());
        return familyRelationshipUtils.familyRelationshipToFamilyRelationshipResponse(getFamilyRelationship);
    }

    @Transactional
    public FamilyRelationshipResponse modifyRelationship(long baseResident, long familyResident, FamilyRelationshipModifyRequest request){
        FamilyRelationship familyRelationship = familyRelationshipRepository.getFamilyRelationship(baseResident, familyResident);
        if (Objects.nonNull(request.getRelationShip())){
            familyRelationship.setFamilyRelationshipCode(request.getRelationShip());
        }

        familyRelationshipRepository.saveAndFlush(familyRelationship);

        return familyRelationshipUtils.familyRelationshipToFamilyRelationshipResponse(familyRelationship);
    }

    @Transactional
    public void deleteRelationship(long baseResident, long familyResident){
        FamilyRelationship familyRelationship = familyRelationshipRepository.getFamilyRelationship(baseResident, familyResident);
        familyRelationshipRepository.delete(familyRelationship);
    }
}
