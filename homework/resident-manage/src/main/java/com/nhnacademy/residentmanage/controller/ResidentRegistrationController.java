package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.certificate.CertificateDto;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipDto;
import com.nhnacademy.residentmanage.domain.household.HouseholdDto;
import com.nhnacademy.residentmanage.domain.household_composition_resident.HouseholdCompositionResidentDto;
import com.nhnacademy.residentmanage.domain.household_movement_address.HouseholdMovementAddressDto;
import com.nhnacademy.residentmanage.service.CertificateService;
import com.nhnacademy.residentmanage.service.HouseholdCompositionResidentService;
import com.nhnacademy.residentmanage.service.HouseholdMovementAddressService;
import com.nhnacademy.residentmanage.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/certificate/residentRegistration")
@RequiredArgsConstructor
public class ResidentRegistrationController {
    private final CertificateService certificateService;
    private final HouseholdService householdService;
    private final HouseholdMovementAddressService householdMovementAddressService;
    private final HouseholdCompositionResidentService householdCompositionResidentService;

    @GetMapping
    public String getFamilyRelationship(Model model, String id){
        CertificateDto certificateIssue = certificateService.getResidentRegistrationCertificateIssue(Long.parseLong(id));
        HouseholdDto household = householdService.getHouseholdDto(Long.parseLong(id));
        List<HouseholdMovementAddressDto> householdMovementAddressList = householdMovementAddressService.getHouseholdMovementAddressDto(household.getHouseholdSerialNumber());
        List<HouseholdCompositionResidentDto> householdCompositionResidentList = householdCompositionResidentService.getHouseholdCompositionResidentDto(household.getHouseholdSerialNumber());
        certificateService.registerCertificate(Long.parseLong(id), "주민등록등본", LocalDate.now());

        model.addAttribute("certificateIssue", certificateIssue);
        model.addAttribute("household", household);
        model.addAttribute("householdMovementAddressList", householdMovementAddressList);
        model.addAttribute("householdCompositionResidentList", householdCompositionResidentList);
        return "residentRegistration";
    }
}
