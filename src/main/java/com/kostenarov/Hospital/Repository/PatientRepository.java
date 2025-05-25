package com.kostenarov.Hospital.Repository;

import com.kostenarov.Hospital.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    HashSet<Patient> findByNameAndSurname(String name, String surname);
    HashSet<Patient> findByBloodGroupName(String bloodGroupName);
    HashSet<Patient> findByIsSmoker(boolean isSmoker);
    HashSet<Patient> findByDoctorsId(Long doctorId);
    HashSet<Patient> findByDiagnosesId(Long diagnosisId);



    // Custom query methods can be defined here if needed
    // For example, to find patients by name or blood group, etc.
}
