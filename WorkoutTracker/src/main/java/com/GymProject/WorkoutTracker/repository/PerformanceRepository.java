package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.performances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends JpaRepository<performances, Integer> {
}
