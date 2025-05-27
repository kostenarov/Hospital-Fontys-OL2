package com.kostenarov.Hospital.Controller.Dto;

import jakarta.annotation.Resource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;

@EqualsAndHashCode(callSuper = true)
@Data
public class PatientDto extends HumanDto {
    private Long id;
    @Getter
    private BloodGroupDto bloodGroup;
    @Getter
    private DiagnosisDto diagnosis;
    @Getter
    private HashSet<DoctorDto> doctors = new HashSet<>();

    public PatientDto(Long id, String name, String surname, short age, BloodGroupDto bloodGroup, DiagnosisDto diagnosis, HashSet<DoctorDto> doctors) {
        super(name, surname, age);
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.diagnosis = diagnosis;
        this.doctors = doctors != null ? doctors : new HashSet<>();
    }

    public PatientDto() {
        // Default constructor
    }

    public String getFullNameWithDiagnosis() {
        return getFullName() + ", diagnosis: " + (diagnosis != null ? diagnosis.getFullName() : "No diagnosis assigned");
    }

    public String getFullNameWithBloodGroup() {
        return getFullName() + ", blood group: " + (bloodGroup != null ? bloodGroup.getType() : "No blood group assigned");
    }

    public String getFullNameWithDiagnosisAndBloodGroup() {
        return getFullNameWithDiagnosis() + ", " + getFullNameWithBloodGroup();
    }

    public String getFullNameWithAllDetails() {
        return getFullNameWithDiagnosisAndBloodGroup() + ", age: " + age;
    }

    public String GetFullNameWithAllDetailsAndDoctors() {
        StringBuilder sb = new StringBuilder(getFullNameWithAllDetails());
        if (doctors != null && !doctors.isEmpty()) {
            sb.append(", doctors: ");
            for (DoctorDto doctor : doctors) {
                sb.append(doctor.getFullNameWithSpecialization()).append("; ");
            }
        } else {
            sb.append(", no doctors assigned.");
        }
        return sb.toString();
    }
}
