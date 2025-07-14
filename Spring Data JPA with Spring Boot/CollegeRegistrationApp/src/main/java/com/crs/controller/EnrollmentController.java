package com.crs.controller;

import com.crs.entity.*;
import com.crs.exception.InvalidEntityException;
import com.crs.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/addEnrollment/{studentId}/{courseId}")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment,
                                                    @PathVariable int studentId,
                                                    @PathVariable int courseId) throws InvalidEntityException {
        return new ResponseEntity<>(enrollmentService.addEnrollment(enrollment, studentId, courseId), HttpStatus.OK);
    }

    @PutMapping("/updateStudentGrade/{studentId}/{courseId}/{grade}")
    public ResponseEntity<Enrollment> updateGrade(@PathVariable int studentId,
                                                  @PathVariable int courseId,
                                                  @PathVariable double grade) throws InvalidEntityException {
        EnrollmentId id = new EnrollmentId(studentId, courseId);
        return new ResponseEntity<>(enrollmentService.updateStudentGrade(id, grade), HttpStatus.OK);
    }

    @GetMapping("/viewEnrollmentByDate/{enrollmentDate}")
    public ResponseEntity<List<Enrollment>> viewEnrollmentByDate(@PathVariable String enrollmentDate) {
        return new ResponseEntity<>(enrollmentService.viewEnrollmentByDate(LocalDate.parse(enrollmentDate)), HttpStatus.OK);
    }

    @GetMapping("/viewEnrollmentsByInstructor/{instructor}")
    public ResponseEntity<List<Enrollment>> viewEnrollmentsByInstructor(@PathVariable String instructor) {
        return new ResponseEntity<>(enrollmentService.viewEnrollmentsByInstructor(instructor), HttpStatus.OK);
    }
}