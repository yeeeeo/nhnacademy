package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.domain.birth.BirthDto;
import com.nhnacademy.residentmanage.domain.death.DeathDto;
import com.nhnacademy.residentmanage.entity.BirthDeathReportResident;
import com.nhnacademy.residentmanage.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BirthDeathRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {
    @Query(value = "select b " +
            "from BirthDeathReportResident b " +
            "join Resident r1 on b.resident.residentSerialNumber = r1.residentSerialNumber " +
            "join Resident r2 on b.reportResident.residentSerialNumber = r2.residentSerialNumber " +
            "where b.resident.residentSerialNumber = ?1 " +
            "and b.reportResident.residentSerialNumber = ?2")
    BirthDeathReportResident getBirthDeathReportResident(long birth, long report);

    @Query(value = "select b " +
            "from BirthDeathReportResident b " +
            "join Resident r on b.resident.residentSerialNumber = r.residentSerialNumber " +
            "where b.Pk.residentSerialNumber = ?1 " +
            "and b.Pk.birthDeathTypeCode = ?2")
    BirthDeathReportResident getBirthDeathResident(long serialNumber, String type);

    @Query(value = "select b " +
            "from BirthDeathReportResident b " +
            "join Resident r on b.resident.residentSerialNumber = r.residentSerialNumber " +
            "where b.Pk.residentSerialNumber = ?1 " +
            "and b.Pk.birthDeathTypeCode = ?2")
    BirthDto getBirthDto(long serialNumber, String type);

    @Query(value = "select b " +
            "from BirthDeathReportResident b " +
            "join Resident r on b.resident.residentSerialNumber = r.residentSerialNumber " +
            "where b.Pk.residentSerialNumber = ?1 " +
            "and b.Pk.birthDeathTypeCode = ?2")
    DeathDto getDeathDto(long serialNumber, String type);
}
