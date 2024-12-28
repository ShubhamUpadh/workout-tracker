package com.GymProject.WorkoutTracker.controller;


import com.GymProject.WorkoutTracker.dto.SchedulePostRequest;
import com.GymProject.WorkoutTracker.model.schedules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired


    @PostMapping("/addSchedule")
    public schedules addSchedule(SchedulePostRequest request){

    }
}
