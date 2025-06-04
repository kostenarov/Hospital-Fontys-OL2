package com.kostenarov.Hospital.Dao.ServiceImpl;

import com.kostenarov.Hospital.Dao.BloodGroupService;
import com.kostenarov.Hospital.Entity.BloodGroup;
import com.kostenarov.Hospital.Repository.BloodGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodGroupServiceImpl implements BloodGroupService {
    private final BloodGroupRepository bloodGroupRepository;

    @Override
    public void addBloodGroup(BloodGroup type) {
        if (type == null || type.getType() == null || type.getType().isEmpty()) {
            throw new IllegalArgumentException("Blood group type cannot be null or empty");
        }
        List<BloodGroup> existingGroups = bloodGroupRepository.findAll();
        if(existingGroups.contains(type)) {
            throw new IllegalArgumentException("Blood group with type " + type + " already exists");
        }

        bloodGroupRepository.save(type);
    }

    @Override
    public void deleteBloodGroup(Long id) {
        if (id == null || !bloodGroupRepository.existsById(id)) {
            throw new IllegalArgumentException("Blood group with ID " + id + " does not exist");
        }
        bloodGroupRepository.deleteById(id);

    }

    @Override
    public String getBloodGroupById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return bloodGroupRepository.findById(id)
                .map(BloodGroup::getType)
                .orElseThrow(() -> new IllegalArgumentException("Blood group with ID " + id + " does not exist"));
    }

    @Override
    public HashSet<String> getAllBloodGroups() {
        HashSet<String> bloodGroups = new HashSet<>();
        List<BloodGroup> groups = bloodGroupRepository.findAll();
        for (BloodGroup group : groups) {
            bloodGroups.add(group.getType());
        }
        return bloodGroups;
    }
}
