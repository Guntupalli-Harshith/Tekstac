package com.crs.repository;

import com.crs.entity.Enrollment;
import com.crs.entity.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {

    List<Enrollment> findByEnrollmentDate(LocalDate date);

    @Query("SELECT e FROM Enrollment e WHERE e.course.instructor = :instructor")
    List<Enrollment> findByInstructor(@Param("instructor") String instructor);
}