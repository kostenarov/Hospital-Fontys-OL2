package com.kostenarov.Hospital.Dao.ServiceImpl;

import com.kostenarov.Hospital.Controller.Dto.BloodGroupDto;
import com.kostenarov.Hospital.Dao.BloodGroupService;
import com.kostenarov.Hospital.Entity.BloodGroup;
import com.kostenarov.Hospital.Repository.BloodGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import static com.kostenarov.Hospital.Mapper.BloodGroupMapper.BLOOD_GROUP_MAPPER;

@Service
@RequiredArgsConstructor
public class BloodGroupServiceImpl implements BloodGroupService {
    private final BloodGroupRepository bloodGroupRepository;

    @Override
    public void addBloodGroup(BloodGroupDto type) {
        if (type == null || type.getType() == null || type.getType().isEmpty()) {
            throw new IllegalArgumentException("Blood group type cannot be null or empty");
        }
        BloodGroup bloodGroup = BLOOD_GROUP_MAPPER.dtoToBloodGroup(type);


        bloodGroupRepository.save(bloodGroup);
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
    public HashSet<BloodGroupDto> getAllBloodGroups() {
        List<BloodGroup> bloodGroupsList = bloodGroupRepository.findAll();
        if (bloodGroupsList.isEmpty()) {
            throw new IllegalArgumentException("No blood groups found");
        }
        HashSet<BloodGroup> bloodGroups = new HashSet<>(bloodGroupsList);
        return BLOOD_GROUP_MAPPER.bloodGroupsToDtos(bloodGroups);
    }
}
