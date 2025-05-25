package com.kostenarov.Hospital.Dao;

import com.kostenarov.Hospital.Entity.Patient;

import java.util.HashSet;

public interface PatientService {
    HashSet<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient savePatient(Patient patient);

    void deletePatient(Long id);

    void addDoctorToPatient(Long patientId, Long doctorId);

    void removeDoctorFromPatient(Long patientId, Long doctorId);

    void addDiagnosisToPatient(Long patientId, String diagnosis);

    void removeDiagnosisFromPatient(Long patientId, String diagnosis);

    HashSet<Patient> getPatientsByNames(String name, String surname);

    HashSet<Patient> getPatientsByBloodGroup(String bloodGroupName);

    HashSet<Patient> getPatientsBySmokerStatus(boolean isSmoker);

    HashSet<Patient> getPatientsByDoctorId(Long doctorId);

    HashSet<Patient> getPatientsByDiagnosis(String diagnosis);
}
