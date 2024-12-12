package com.GymProject.WorkoutTracker.service;

import com.GymProject.WorkoutTracker.model.users;
import com.GymProject.WorkoutTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<users> getUser() {
        return userRepository.findAll();
    }

    public List<users> addUsers(List<users> user) {
        return userRepository.saveAll(user);
    }
}
