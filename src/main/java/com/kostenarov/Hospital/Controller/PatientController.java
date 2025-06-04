package com.kostenarov.Hospital.Controller;

import com.kostenarov.Hospital.Controller.Dto.PatientDto;
import com.kostenarov.Hospital.Dao.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hospital/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody PatientDto patientDto) {
        if (patientDto == null) {
            return ResponseEntity.badRequest().body("Patient data cannot be null");
        }
        try {
            patientService.savePatient(patientDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Patient added successfully");
    }
}
