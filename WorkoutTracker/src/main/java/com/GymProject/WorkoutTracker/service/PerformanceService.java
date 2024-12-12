package com.GymProject.WorkoutTracker.service;

import com.GymProject.WorkoutTracker.model.performances;
import com.GymProject.WorkoutTracker.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {
    @Autowired
    PerformanceRepository performanceRepository;

    public performances savePerformances(performances Performance){
        return performanceRepository.save(Performance);
    }


}
