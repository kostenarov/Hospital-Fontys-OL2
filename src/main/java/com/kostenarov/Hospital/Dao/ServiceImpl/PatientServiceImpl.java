package com.kostenarov.Hospital.Dao.ServiceImpl;

import com.kostenarov.Hospital.Controller.Dto.PatientDto;
import com.kostenarov.Hospital.Dao.PatientService;
import com.kostenarov.Hospital.Entity.Patient;
import com.kostenarov.Hospital.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import static com.kostenarov.Hospital.Mapper.PatientMapper.PATIENT_MAPPER;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final BedRepository bedRepository;
    private final RoomRepository roomRepository;
    private final DoctorRepository doctorRepository;
    private final DiagnosisRepository diagnosisRepository;


    @Override
    public HashSet<PatientDto> getAllPatients() {
        HashSet<Patient> patients = new HashSet<>(patientRepository.findAll());
        if (patients.isEmpty()) {
            throw new IllegalArgumentException("No patients found");
        }
        return PATIENT_MAPPER.patientsToPatientDtos(patients);
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient with ID " + id + " does not exist"));
        return PATIENT_MAPPER.patientToPatientDto(patient);
    }

    @Override
    public void savePatient(PatientDto patientDto) {
        if (patientDto == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        Patient patient = PATIENT_MAPPER.patientDtoToPatient(patientDto);
        if (patient.getId() != null && !patientRepository.existsById(patient.getId())) {
            throw new IllegalArgumentException("Patient with ID " + patient.getId() + " does not exist");
        }
        if (patient.getDoctors() != null) {
            patient.getDoctors().forEach(doctor -> {
                if (doctor.getId() != null && !doctorRepository.existsById(doctor.getId())) {
                    throw new IllegalArgumentException("Doctor with ID " + doctor.getId() + " does not exist");
                }
            });
        }
        if (patient.getDiagnoses() != null) {
            patient.getDiagnoses().forEach(diagnosis -> {
                if (!diagnosisRepository.existsByName(diagnosis.getName())) {
                    diagnosisRepository.save(diagnosis);
                }
            });
        }
        patientRepository.save(patient);
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
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient with ID " + patientId + " does not exist"));
        if (doctorRepository.existsById(doctorId)) {
            patient.getDoctors().add(doctorRepository.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Doctor with ID " + doctorId + " does not exist")));
            patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Doctor with ID " + doctorId + " does not exist");
        }
    }

    @Override
    public void removeDoctorFromPatient(Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient with ID " + patientId + " does not exist"));
        if (doctorRepository.existsById(doctorId)) {
            patient.getDoctors().removeIf(doctor -> doctor.getId().equals(doctorId));
            patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Doctor with ID " + doctorId + " does not exist");
        }

    }

    @Override
    public void addDiagnosisToPatient(Long patientId, String diagnosis) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient with ID " + patientId + " does not exist"));
        if (diagnosisRepository.existsByName(diagnosis)) {
            patient.getDiagnoses().add(diagnosisRepository.findByName(diagnosis));
            patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Diagnosis " + diagnosis + " does not exist");
        }
    }

    @Override
    public void removeDiagnosisFromPatient(Long patientId, String diagnosis) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient with ID " + patientId + " does not exist"));
        if (diagnosisRepository.existsByName(diagnosis)) {
            patient.getDiagnoses().removeIf(d -> d.getName().equals(diagnosis));
            patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Diagnosis " + diagnosis + " does not exist");
        }
    }

    @Override
    public HashSet<PatientDto> getPatientsByNames(String name, String surname) {
        return null;
    }

    @Override
    public HashSet<PatientDto> getPatientsByBloodGroup(String bloodGroupName) {
        return null;
    }

    @Override
    public HashSet<PatientDto> getPatientsBySmokerStatus(boolean isSmoker) {
        return null;
    }

    @Override
    public HashSet<PatientDto> getPatientsByDoctorId(Long doctorId) {
        return null;
    }

    @Override
    public HashSet<PatientDto> getPatientsByDiagnosis(String diagnosis) {
        Long diagnosisId = diagnosisRepository.findByName(diagnosis).getId();
        HashSet<Patient> patients = new HashSet<>();
        if (diagnosisRepository.existsByName(diagnosis)) {
            patients.addAll(patientRepository.findByDiagnoses_Id(diagnosisId));
        } else {
            throw new IllegalArgumentException("Diagnosis " + diagnosis + " does not exist");
        }
        if (patients.isEmpty()) {
            throw new IllegalArgumentException("No patients found with diagnosis " + diagnosis);
        }
        return PATIENT_MAPPER.patientsToPatientDtos(patients);
    }

    @Override
    public PatientDto getPatientByBedId(Long bedId) {
        if (!bedRepository.existsById(bedId)) {
            throw new IllegalArgumentException("Bed with ID " + bedId + " does not exist");
        }
        Patient patient = bedRepository.findById(bedId).orElseThrow(() -> new IllegalArgumentException("Bed with ID " + bedId + " does not exist")).getPatient();
        if (patient == null) {
            throw new IllegalArgumentException("No patient assigned to bed with ID " + bedId);
        }
        return PATIENT_MAPPER.patientToPatientDto(patient);
    }

    @Override
    public HashSet<PatientDto> getPatientsByRoomId(Long roomId) {
        HashSet<Patient> patients = new HashSet<>();
        roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("Room with ID " + roomId + " does not exist"))
                .getBeds().forEach(bed -> patients.add(bed.getPatient()));
        if (patients.isEmpty()) {
            throw new IllegalArgumentException("No patients found in room with ID " + roomId);
        }
        return PATIENT_MAPPER.patientsToPatientDtos(patients);
    }
}
