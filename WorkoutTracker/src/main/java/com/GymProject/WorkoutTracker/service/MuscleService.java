package com.GymProject.WorkoutTracker.service;

import com.GymProject.WorkoutTracker.repository.MuscleTargetedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuscleService {

    @Autowired
    MuscleTargetedRepository muscleTargetedRepository;

    public void deleteAll() {
        muscleTargetedRepository.deleteAll();
    }
}
