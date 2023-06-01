package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.birth.BirthModifyRequest;
import com.nhnacademy.residentmanage.domain.birth.BirthRegisterRequest;
import com.nhnacademy.residentmanage.domain.birth.BirthResponse;
import com.nhnacademy.residentmanage.exception.ValidationFailedException;
import com.nhnacademy.residentmanage.service.BirthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/residents/{serialNumber}/birth")
@RequiredArgsConstructor
public class BirthRestController {
    private final BirthService birthService;

    @PostMapping
    public BirthResponse registerBirth(@PathVariable("serialNumber") long serialNumber,
                                       @Valid @RequestBody BirthRegisterRequest birth,
                                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return birthService.registerBirth(serialNumber, birth);
    }

    @PutMapping("/{targetSerialNumber}")
    public BirthResponse modifyBirth(@PathVariable("serialNumber") long serialNumber,
                                       @PathVariable("targetSerialNumber") long targetSerialNumber,
                                       @Valid @RequestBody BirthModifyRequest birth,
                                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return birthService.modifyBirth(serialNumber, targetSerialNumber, birth);
    }

    @DeleteMapping("/{targetSerialNumber}")
    public void deleteBirth(@PathVariable("serialNumber") long serialNumber,
                                   @PathVariable("targetSerialNumber") long targetSerialNumber){
        birthService.deleteBirth(serialNumber, targetSerialNumber);
    }
}
