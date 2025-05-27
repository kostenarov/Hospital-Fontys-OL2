package com.kostenarov.Hospital.Controller.Dto;

import lombok.Data;
import lombok.Getter;

@Data
public class BloodGroupDto {
    private Long id;
    @Getter
    private String type;

    public BloodGroupDto(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public BloodGroupDto() {
        // Default constructor
    }

    public String getType() {
        return type != null ? type : "No blood group assigned";
    }
}
