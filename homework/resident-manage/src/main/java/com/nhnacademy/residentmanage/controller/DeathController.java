package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.death.DeathDto;
import com.nhnacademy.residentmanage.service.CertificateService;
import com.nhnacademy.residentmanage.service.DeathService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/certificate/death")
@RequiredArgsConstructor
public class DeathController {
    private final DeathService deathService;
    private final CertificateService certificateService;
    @GetMapping
    public String getDeath(Model model, String id){
        DeathDto death = deathService.getDeathDto(Long.parseLong(id));
        certificateService.registerCertificate(Long.parseLong(id), "사망신고서", LocalDate.now());
        model.addAttribute("death", death);
        return "death";
    }
}
