package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.domain.family_relationship.FamilyDto;
import com.nhnacademy.residentmanage.domain.family_relationship.FamilyRelationshipDto;
import com.nhnacademy.residentmanage.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {
        @Query(value = "select f " +
                "from FamilyRelationship f " +
                "join Resident r1 on f.baseResident.residentSerialNumber = r1.residentSerialNumber " +
                "join Resident r2 on f.baseResident.residentSerialNumber = r2.residentSerialNumber " +
                "where f.baseResident.residentSerialNumber = ?1 " +
                "and f.familyResident.residentSerialNumber = ?2")
        FamilyRelationship getFamilyRelationship(long baseResident, long familyResident);

        @Query(value = "select f " +
                "from FamilyRelationship f " +
                "join Resident r1 on f.baseResident.residentSerialNumber = r1.residentSerialNumber " +
                "join Resident r2 on f.baseResident.residentSerialNumber = r2.residentSerialNumber " +
                "where f.baseResident.residentSerialNumber = ?1 ")
        List<FamilyRelationshipDto> getFamilyRelationshipList(long baseResident);

        @Query(value = "select f " +
                "from FamilyRelationship f " +
                "join Resident r1 on f.baseResident.residentSerialNumber = r1.residentSerialNumber " +
                "where f.baseResident.residentSerialNumber = ?1 ")
        List<FamilyDto> getFamilyDto(long baseSerialNumber);

}

