package com.crs.controller;

import com.crs.entity.Course;
import com.crs.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.OK);
    }

    @GetMapping("/viewMostEnrolledCourse")
    public ResponseEntity<Course> viewMostEnrolledCourse() {
        return new ResponseEntity<>(courseService.viewMostEnrolledCourse(), HttpStatus.OK);
    }
}