package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.certificate.CertificateDto;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipDto;
import com.nhnacademy.residentmanage.entity.FamilyRelationship;
import com.nhnacademy.residentmanage.entity.Resident;
import com.nhnacademy.residentmanage.service.CertificateService;
import com.nhnacademy.residentmanage.service.FamilyRelationshipService;
import com.nhnacademy.residentmanage.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/certificate/familyRelationship")
@RequiredArgsConstructor
public class FamilyRelationshipController {
    private final CertificateService certificateService;
    private final FamilyRelationshipService familyRelationshipService;
    @GetMapping
    public String getFamilyRelationship(Model model, String id){
        certificateService.registerCertificate(Long.parseLong(id), "가족관계증명서", LocalDate.now());
        CertificateDto certificateIssue = certificateService.getFamilyRelationshipCertificateIssue(Long.parseLong(id));
        List<FamilyRelationshipDto> familyRelationshipDtoList = familyRelationshipService.getFamilyRelationshipList(Long.parseLong(id));
        FamilyRelationshipDto.BaseResident baseResident = null;
        for (FamilyRelationshipDto f : familyRelationshipDtoList){
            if (f.getBaseResident().getResidentSerialNumber() == Long.parseLong(id)){
                baseResident = f.getBaseResident();
            }

        }

        model.addAttribute("familyRelationshipDtoList", familyRelationshipDtoList);
        model.addAttribute("certificateIssue", certificateIssue);
        model.addAttribute("baseResident", baseResident);
        return "familyRelationship";
    }
}
