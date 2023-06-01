package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.resident.ResidentDto;
import com.nhnacademy.residentmanage.service.ResidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = {"/",""})
@RequiredArgsConstructor
public class indexController {
    private final ResidentService residentService;
    @GetMapping
    public String getIndex(Model model, @PageableDefault(size = 5)Pageable pageable){
        Page<ResidentDto> residentPage = residentService.getResidentPage(pageable);
        model.addAttribute("residentPage", residentPage);
        return "index";
    }
}
