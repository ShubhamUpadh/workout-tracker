package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<users, Long> {
}
