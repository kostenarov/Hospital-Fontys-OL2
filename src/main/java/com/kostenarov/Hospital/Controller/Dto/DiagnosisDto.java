package com.kostenarov.Hospital.Controller.Dto;

import lombok.Data;

@Data
public class DiagnosisDto {
    private Long id;
    private String name;
    private String description;

    public DiagnosisDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public DiagnosisDto() {
        // Default constructor
    }

    public String getFullName() {
        return name + " - " + description;
    }
}
