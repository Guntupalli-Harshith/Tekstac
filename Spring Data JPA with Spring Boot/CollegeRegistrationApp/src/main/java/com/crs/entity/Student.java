package com.crs.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    private int studentId;

    private String name;
    private String email;
    private String department;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    // Getters, Setters, Constructors (as provided)
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public Student() {
		
	}

	public Student(int studentId, String name, String email, String department, List<Enrollment> enrollments) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.department = department;
		this.enrollments = enrollments;
	}
    
}