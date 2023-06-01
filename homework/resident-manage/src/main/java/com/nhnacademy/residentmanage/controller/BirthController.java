package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.birth.BirthDto;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyDto;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipDto;
import com.nhnacademy.residentmanage.service.BirthService;
import com.nhnacademy.residentmanage.service.CertificateService;
import com.nhnacademy.residentmanage.service.FamilyRelationshipService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/certificate/birth")
@RequiredArgsConstructor
public class BirthController {
    private final BirthService birthService;
    private final CertificateService certificateService;
    private final FamilyRelationshipService familyRelationshipService;
    @GetMapping
    public String getBirth(Model model, String id){
        BirthDto birth = birthService.getBirthDto(Long.parseLong(id));
        List<FamilyDto> familyList = familyRelationshipService.getFamilyDto(Long.parseLong(id));
        certificateService.registerCertificate(Long.parseLong(id), "출생신고서", LocalDate.now());
        model.addAttribute("birth", birth);
        model.addAttribute("familyList", familyList);
        return "birth";
    }
}
