package com.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "stud_roll_num")
    private String studentRollNumber;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_age")
    private int studentAge;

    @Column(name = "student_gender")
    private String studentGender;

    @Column(name = "student_grade")
    private String studentGrade;

    @Column(name = "student_section")
    private String studentSection;

    @ManyToOne
    @JoinColumn(name = "schoolid") // 👈 Required by test case (NOT "school_id")
    private School school;

    // Getters and Setters

    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(String studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentSection() {
        return studentSection;
    }

    public void setStudentSection(String studentSection) {
        this.studentSection = studentSection;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}