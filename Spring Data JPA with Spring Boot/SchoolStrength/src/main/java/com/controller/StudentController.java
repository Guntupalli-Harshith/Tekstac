package com.controller;

import com.bean.Student;
import com.dao.SchoolDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private SchoolDAO schoolDAO;

    @PostMapping("/registerStudentToSchool/{schoolId}")
    public ResponseEntity<List<Student>> registerStudentToSchool(
            @PathVariable String schoolId,
            @RequestBody List<Student> students) {

        return new ResponseEntity<>(schoolDAO.registerStudentToSchool(schoolId, students), HttpStatus.OK);
    }
}