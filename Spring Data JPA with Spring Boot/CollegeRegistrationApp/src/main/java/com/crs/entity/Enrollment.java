package com.crs.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id") // ✅ Explicit and correct
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id") // ✅ Explicit and correct
    private Course course;

    private LocalDate enrollmentDate;
    private Double grade;
    private int attendancePercentage;

    public Enrollment() {}

    public Enrollment(EnrollmentId id, Student student, Course course, LocalDate enrollmentDate, Double grade, int attendancePercentage) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
        this.attendancePercentage = attendancePercentage;
    }

    // ✅ Required public method by skeleton
    public EnrollmentId getId() {
        return id;
    }

    public void setId(EnrollmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public int getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(int attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }
}