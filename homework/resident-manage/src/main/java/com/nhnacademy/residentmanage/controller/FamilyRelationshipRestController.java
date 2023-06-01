package com.nhnacademy.residentmanage.controller;

import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipModifyRequest;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipRegisterRequest;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipResponse;
import com.nhnacademy.residentmanage.exception.ValidationFailedException;
import com.nhnacademy.residentmanage.service.FamilyRelationshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/residents/{serialNumber}/relationship")
@RequiredArgsConstructor
public class FamilyRelationshipRestController {
    private final FamilyRelationshipService familyRelationshipService;
    @PostMapping
    public FamilyRelationshipResponse registerRelationship(@PathVariable("serialNumber") long serialNumber,
                                                           @Valid @RequestBody FamilyRelationshipRegisterRequest relationship,
                                                           BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return familyRelationshipService.registerResident(serialNumber, relationship);
    }

    @PutMapping("/{familySerialNumber}")
    public FamilyRelationshipResponse modifyRelationship(@PathVariable("serialNumber") long serialNumber,
                                                         @PathVariable("familySerialNumber") long familySerialNumber,
                                                         @RequestBody FamilyRelationshipModifyRequest relationship){
        return familyRelationshipService.modifyRelationship(serialNumber, familySerialNumber, relationship);
    }

    @DeleteMapping("/{familySerialNumber}")
    public void deleteRelationship(@PathVariable("serialNumber") long serialNumber,
                                                         @PathVariable("familySerialNumber") long familySerialNumber){
        familyRelationshipService.deleteRelationship(serialNumber, familySerialNumber);
    }
}
