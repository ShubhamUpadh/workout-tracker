package com.GymProject.WorkoutTracker.controller;

import com.GymProject.WorkoutTracker.model.users;
import com.GymProject.WorkoutTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<users> getUsers(){
        return userService.getUser();
    }

    @PostMapping("/users")
    public List<users> addUsers(@RequestBody List<users> user){
        return userService.addUsers(user);
    }

}
