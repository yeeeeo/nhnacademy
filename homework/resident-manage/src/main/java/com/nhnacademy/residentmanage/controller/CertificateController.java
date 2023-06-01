package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.certificate.CertificateDto;
import com.nhnacademy.residentmanage.entity.BirthDeathReportResident;
import com.nhnacademy.residentmanage.entity.Resident;
import com.nhnacademy.residentmanage.service.BirthService;
import com.nhnacademy.residentmanage.service.CertificateService;
import com.nhnacademy.residentmanage.service.DeathService;
import com.nhnacademy.residentmanage.service.ResidentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/certificate")
@RequiredArgsConstructor
public class CertificateController {
    private final BirthService birthService;
    private final DeathService deathService;
    private final ResidentService residentService;
    private final CertificateService certificateService;

    @GetMapping
    public String getCertificate(Model model, String id){
        Resident resident = residentService.getResidentBySerialNumber(Long.parseLong(id));
        BirthDeathReportResident birthResident = birthService.getBirthResident(Long.parseLong(id));
        BirthDeathReportResident deathResident = deathService.getDeathResident(Long.parseLong(id));
        boolean hasBirthCertificate = false;
        boolean hasDeathCertificate = false;
        if (Objects.nonNull(birthResident)){
            hasBirthCertificate = true;
        }
        if (Objects.nonNull(deathResident)){
            hasDeathCertificate = true;
        }
        model.addAttribute("resident", resident);
        model.addAttribute("hasBirthCertificate", hasBirthCertificate);
        model.addAttribute("hasDeathCertificate", hasDeathCertificate);
        return "certificate";
    }

    @GetMapping("/list")
    public String getList(Model model, String id, @PageableDefault(size = 5)Pageable pageable){
//        List<CertificateDto> certificateList = certificateService.getCertificateDto(Long.parseLong(id));
        Page<CertificateDto> certificatePage = certificateService.getCertificatePage(pageable, Long.parseLong(id));
        model.addAttribute("certificatePage", certificatePage);
        return "list";
    }
}
