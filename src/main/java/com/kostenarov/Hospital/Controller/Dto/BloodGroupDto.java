package com.kostenarov.Hospital.Controller.Dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class BloodGroupDto {
    private String type;

    public BloodGroupDto(String type) {
        this.type = type;
    }

    public BloodGroupDto() {
        // Default constructor
    }

    public String getType() {
        return type != null ? type : "No blood group assigned";
    }
}
