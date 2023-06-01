package com.nhnacademy.residentmanage.utils;

import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipRegisterRequest;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipResponse;
import com.nhnacademy.residentmanage.entity.FamilyRelationship;
import com.nhnacademy.residentmanage.entity.Resident;

public class FamilyRelationshipUtils {
    public FamilyRelationship familyRelationshipRegisterRequestToFamilyRelationship(FamilyRelationshipRegisterRequest request,
                                                                                    long serialNumber,
                                                                                    Resident baseResident,
                                                                                    Resident familyResident){
        FamilyRelationship familyRelationship = new FamilyRelationship();
        familyRelationship.setPk(new FamilyRelationship.Pk(serialNumber, request.getFamilySerialNumber()));
        familyRelationship.setFamilyRelationshipCode(request.getRelationShip());
        familyRelationship.setBaseResident(baseResident);
        familyRelationship.setFamilyResident(familyResident);
        return familyRelationship;
    }

    public FamilyRelationshipResponse familyRelationshipToFamilyRelationshipResponse(FamilyRelationship familyRelationship){
        FamilyRelationshipResponse responseFamilyRelationship = new FamilyRelationshipResponse();
        responseFamilyRelationship.setBaseResident(familyRelationship.getBaseResident().getName());
        responseFamilyRelationship.setFamilyResident(familyRelationship.getFamilyResident().getName());
        responseFamilyRelationship.setRelationShip(familyRelationship.getFamilyRelationshipCode());
        return responseFamilyRelationship;
    }
}
