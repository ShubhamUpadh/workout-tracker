package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepository extends JpaRepository<schedules, Integer> {
}
