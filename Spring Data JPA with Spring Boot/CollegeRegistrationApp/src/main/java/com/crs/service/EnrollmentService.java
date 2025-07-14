package com.crs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.entity.Course;
import com.crs.entity.Enrollment;
import com.crs.entity.EnrollmentId;
import com.crs.entity.Student;
import com.crs.exception.InvalidEntityException;
import com.crs.repository.CourseRepository;
import com.crs.repository.EnrollmentRepository;
import com.crs.repository.StudentRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Add enrollment
    public Enrollment addEnrollment(Enrollment enrollment, int studentId, int courseId) throws InvalidEntityException {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (studentOpt.isEmpty() || courseOpt.isEmpty()) {
            throw new InvalidEntityException("Invalid student or course ID");
        }

        EnrollmentId id = new EnrollmentId(studentId, courseId);
        enrollment.setId(id);
        enrollment.setStudent(studentOpt.get());
        enrollment.setCourse(courseOpt.get());

        return enrollmentRepository.save(enrollment);
    }

    // Update grade
    public Enrollment updateStudentGrade(EnrollmentId enrollmentId, double grade) throws InvalidEntityException {
        Optional<Enrollment> enrollmentOpt = enrollmentRepository.findById(enrollmentId);
        if (enrollmentOpt.isEmpty()) {
            throw new InvalidEntityException("Enrollment not found");
        }

        Enrollment enrollment = enrollmentOpt.get();
        enrollment.setGrade(grade);
        return enrollmentRepository.save(enrollment);
    }

    // View enrollments by date
    public List<Enrollment> viewEnrollmentByDate(LocalDate enrollmentDate) {
        return enrollmentRepository.findByEnrollmentDate(enrollmentDate);
    }

    // View enrollments by instructor
    public List<Enrollment> viewEnrollmentsByInstructor(String instructorName) {
        return enrollmentRepository.findByInstructor(instructorName);
    }
}