package com.kostenarov.Hospital.Repository;

import com.kostenarov.Hospital.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    HashSet<Patient> findByNameAndSurname(String name, String surname);
    HashSet<Patient> findByBloodGroupType(String bloodGroupType);
    HashSet<Patient> findByIsSmoker(boolean isSmoker);
    HashSet<Patient> findByDoctors_Id(Long doctorId);
    HashSet<Patient> findByDiagnoses_Id(Long diagnosisId);


    // Custom query methods can be defined here if needed
    // For example, to find patients by name or blood group, etc.
}
