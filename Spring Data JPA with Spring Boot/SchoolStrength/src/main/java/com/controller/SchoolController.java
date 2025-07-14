package com.controller;

import com.bean.School;
import com.dao.SchoolDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    private SchoolDAO schoolDAO;

    @PostMapping("/addSchool")
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        return new ResponseEntity<>(schoolDAO.addSchool(school), HttpStatus.OK);
    }

    @GetMapping("/schoolWithMaximumStudents/{city}")
    public ResponseEntity<List<School>> schoolWithMaximumStudents(@PathVariable String city) {
        return new ResponseEntity<>(schoolDAO.schoolWithMaximumStudents(city), HttpStatus.OK);
    }
}