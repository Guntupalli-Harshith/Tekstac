package com.dao;

import com.bean.School;
import com.bean.Student;
import com.repository.SchoolRepository;
import com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchoolDAO {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    public School addSchool(School school){
        return schoolRepository.save(school);
    }

    public List<Student> registerStudentToSchool(String schoolId, List<Student> students) {
        School school = schoolRepository.findById(schoolId).orElse(null);
        if (school == null) return null;

        for (Student student : students) {
            student.setSchool(school);
            school.getStudentList().add(student);
        }

        schoolRepository.save(school);
        return students;
    }

    public List<School> schoolWithMaximumStudents(String city){
        return schoolRepository.findSchoolsWithMaxStudentsInCity(city);
    }
}