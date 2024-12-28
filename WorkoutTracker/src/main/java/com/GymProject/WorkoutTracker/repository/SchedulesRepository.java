package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.schedules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulesRepository extends JpaRepository<schedules, Integer> {
}
