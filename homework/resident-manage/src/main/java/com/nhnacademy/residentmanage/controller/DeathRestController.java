package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.death.DeathModifyRequest;
import com.nhnacademy.residentmanage.domain.death.DeathRegisterRequest;
import com.nhnacademy.residentmanage.domain.death.DeathResponse;
import com.nhnacademy.residentmanage.exception.ValidationFailedException;
import com.nhnacademy.residentmanage.service.DeathService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/residents/{serialNumber}/death")
@RequiredArgsConstructor
public class DeathRestController {
    private final DeathService deathService;

    @PostMapping
    public DeathResponse register(@PathVariable("serialNumber") long serialNumber,
                                  @Valid @RequestBody DeathRegisterRequest death,
                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return deathService.registerDeath(serialNumber, death);
    }

    @PutMapping("/{targetSerialNumber}")
    public DeathResponse modifyDeath(@PathVariable("serialNumber") long serialNumber,
                                     @PathVariable("targetSerialNumber") long targetSerialNumber,
                                     @Valid @RequestBody DeathModifyRequest death,
                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return deathService.modifyDeath(serialNumber, targetSerialNumber, death);
    }

    @DeleteMapping("/{targetSerialNumber}")
    public void deleteDeath(@PathVariable("serialNumber") long serialNumber,
                                   @PathVariable("targetSerialNumber") long targetSerialNumber){
        deathService.deleteDeath(serialNumber, targetSerialNumber);
    }
}
