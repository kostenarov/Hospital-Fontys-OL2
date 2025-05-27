package com.kostenarov.Hospital.Dao;

import com.kostenarov.Hospital.Entity.BloodGroup;

import java.util.HashSet;

public interface BloodGroupService {
    public void addBloodGroup(BloodGroup type);
    public void deleteBloodGroup(Long id);
    public String getBloodGroupById(Long id);
    public HashSet<String> getAllBloodGroups();
}
