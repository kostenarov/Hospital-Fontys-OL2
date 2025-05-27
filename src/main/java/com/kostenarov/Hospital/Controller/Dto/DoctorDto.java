package com.kostenarov.Hospital.Controller.Dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;

@EqualsAndHashCode(callSuper = true)
@Data
public class DoctorDto extends HumanDto{
    @Getter
    private String specialization;
    @Getter
    private HashSet<PatientDto> patients = new HashSet<>();

    public DoctorDto(String name, String surname, short age, String specialization, HashSet<PatientDto> patients) {
        super(name, surname, age);
        this.specialization = specialization;
        this.patients = patients;
    }

    public DoctorDto() {
        // Default constructor
    }

    public String getFullNameWithSpecialization() {
        return getFullName() + ", specialization: " + specialization;
    }

    public String getFullNameWithSpecializationAndPatients() {
        StringBuilder sb = new StringBuilder(getFullNameWithSpecialization());
        if (!patients.isEmpty()) {
            sb.append(", patients: ");
            for (PatientDto patient : patients) {
                sb.append(patient.getFullName()).append("; ");
            }
        } else {
            sb.append(", no patients assigned.");
        }
        return sb.toString();
    }
}
