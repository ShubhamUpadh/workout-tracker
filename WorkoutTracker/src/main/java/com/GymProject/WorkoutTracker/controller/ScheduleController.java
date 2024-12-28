package com.GymProject.WorkoutTracker.controller;


import com.GymProject.WorkoutTracker.dto.SchedulePostRequest;
import com.GymProject.WorkoutTracker.model.schedules;
import com.GymProject.WorkoutTracker.service.AddScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    AddScheduleService addScheduleService;

    @PostMapping("/addSchedule")
    public schedules addSchedule(@RequestBody SchedulePostRequest request){
        return addScheduleService.AddSchedule(request);
    }
}
