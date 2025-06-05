package com.kostenarov.Hospital.Mapper;

import com.kostenarov.Hospital.Controller.Dto.BloodGroupDto;
import com.kostenarov.Hospital.Entity.BloodGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;

@Mapper
public interface BloodGroupMapper {
    BloodGroupMapper BLOOD_GROUP_MAPPER = Mappers.getMapper(BloodGroupMapper.class);

    BloodGroupDto bloodGroupToDto(BloodGroup bloodGroup);
    BloodGroup dtoToBloodGroup(BloodGroupDto bloodGroupDto);
    HashSet<BloodGroupDto> bloodGroupsToDtos(HashSet<BloodGroup> bloodGroups);
    HashSet<BloodGroup> dtosToBloodGroups(HashSet<BloodGroupDto> bloodGroupDtos);
}
