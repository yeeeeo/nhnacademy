package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.resident.ResidentModifyRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentModifyResponse;
import com.nhnacademy.residentmanage.domain.resident.ResidentRegisterRequest;
import com.nhnacademy.residentmanage.domain.resident.ResidentRegisterResponse;
import com.nhnacademy.residentmanage.exception.ValidationFailedException;
import com.nhnacademy.residentmanage.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/residents")
@RequiredArgsConstructor
public class ResidentRestController {
    private final ResidentService residentService;
    @PostMapping
    public ResidentRegisterResponse registerResident(@Valid @RequestBody ResidentRegisterRequest resident,
                                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return residentService.registerResident(resident);
    }

    @PutMapping("/{serialNumber}")
    public ResidentModifyResponse modifyResident(@PathVariable("serialNumber") long serialNumber,
                                                 @RequestBody ResidentModifyRequest resident){
        return residentService.modifyResident(serialNumber, resident);
    }
}
