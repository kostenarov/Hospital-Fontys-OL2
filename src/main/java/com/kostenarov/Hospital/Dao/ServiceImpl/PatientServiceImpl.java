package com.kostenarov.Hospital.Dao.ServiceImpl;

import com.kostenarov.Hospital.Entity.Patient;
import com.kostenarov.Hospital.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements com.kostenarov.Hospital.Dao.PatientService {
    private final PatientRepository patientRepository;

    @Override
    public HashSet<Patient> getAllPatients() {
        HashSet<Patient> patients = new HashSet<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient savePatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        if (id == null || !patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Patient with ID " + id + " does not exist");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public void addDoctorToPatient(Long patientId, Long doctorId) {

    }

    @Override
    public void removeDoctorFromPatient(Long patientId, Long doctorId) {

    }

    @Override
    public void addDiagnosisToPatient(Long patientId, String diagnosis) {

    }

    @Override
    public void removeDiagnosisFromPatient(Long patientId, String diagnosis) {

    }

    @Override
    public HashSet<Patient> getPatientsByNames(String name, String surname) {
        return null;
    }

    @Override
    public HashSet<Patient> getPatientsByBloodGroup(String bloodGroupName) {
        return null;
    }

    @Override
    public HashSet<Patient> getPatientsBySmokerStatus(boolean isSmoker) {
        return null;
    }

    @Override
    public HashSet<Patient> getPatientsByDoctorId(Long doctorId) {
        return null;
    }

    @Override
    public HashSet<Patient> getPatientsByDiagnosis(String diagnosis) {
        return null;
    }

    // Implement methods from PatientService interface here
    // For example:
    // @Override
    // public Patient findById(Long id) {
    //     // Logic to find a patient by ID
    // }

    // @Override
    // public void save(Patient patient) {
    //     // Logic to save a patient
    // }

    // Add any additional methods or logic specific to PatientServiceImpl
}
