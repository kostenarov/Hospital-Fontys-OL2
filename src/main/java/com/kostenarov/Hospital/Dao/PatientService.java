package com.kostenarov.Hospital.Dao;

import com.kostenarov.Hospital.Controller.Dto.PatientDto;
import com.kostenarov.Hospital.Entity.Patient;

import java.util.HashSet;

public interface PatientService {
    HashSet<PatientDto> getAllPatients();

    PatientDto getPatientById(Long id);

    void savePatient(PatientDto patient);

    void deletePatient(Long id);

    void addDoctorToPatient(Long patientId, Long doctorId);

    void removeDoctorFromPatient(Long patientId, Long doctorId);

    void addDiagnosisToPatient(Long patientId, String diagnosis);

    void removeDiagnosisFromPatient(Long patientId, String diagnosis);

    HashSet<PatientDto> getPatientsByNames(String name, String surname);

    HashSet<PatientDto> getPatientsByBloodGroup(String bloodGroupName);

    HashSet<PatientDto> getPatientsBySmokerStatus(boolean isSmoker);

    HashSet<PatientDto> getPatientsByDoctorId(Long doctorId);

    HashSet<PatientDto> getPatientsByDiagnosis(String diagnosis);

    PatientDto getPatientByBedId(Long bedId);

    HashSet<PatientDto> getPatientsByRoomId(Long roomId);
}
