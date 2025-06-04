package com.kostenarov.Hospital.Mapper;

import com.kostenarov.Hospital.Controller.Dto.PatientDto;
import com.kostenarov.Hospital.Entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;

@Mapper
public interface PatientMapper {
    PatientMapper PATIENT_MAPPER = Mappers.getMapper(PatientMapper.class);

    PatientDto patientToPatientDto(Patient patient);
    Patient patientDtoToPatient(PatientDto patientDto);
    HashSet<PatientDto> patientsToPatientDtos(HashSet<Patient> patients);
    HashSet<Patient> patientDtosToPatients(HashSet<PatientDto> patientDtos);
}
