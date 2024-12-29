package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.muscle_targeted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleTargetedRepository extends JpaRepository<muscle_targeted,Long> {
}
