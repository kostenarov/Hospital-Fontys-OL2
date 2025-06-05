package com.kostenarov.Hospital.Controller;

import com.kostenarov.Hospital.Controller.Dto.BloodGroupDto;
import com.kostenarov.Hospital.Dao.BloodGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hospital/api/blood-groups")
@RequiredArgsConstructor
public class BloodGroupController {
    private final BloodGroupService bloodGroupService;

    @PostMapping("/add")
    public ResponseEntity<?> addBloodGroup(@RequestBody BloodGroupDto type) {
        if (type == null) {
            return ResponseEntity.badRequest().body("Blood group cannot be null");
        }
        try {
            bloodGroupService.addBloodGroup(type);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Blood group added successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBloodGroup(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID cannot be null");
        }
        try {
            bloodGroupService.deleteBloodGroup(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Blood group deleted successfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBloodGroupById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID cannot be null");
        }
        try {
            String bloodGroup = bloodGroupService.getBloodGroupById(id);
            return ResponseEntity.ok(bloodGroup);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBloodGroups() {
        try {
            return ResponseEntity.ok(bloodGroupService.getAllBloodGroups());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
