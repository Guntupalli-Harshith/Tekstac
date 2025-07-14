package com.crs.repository;

import com.crs.entity.Course;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c JOIN c.enrollments e GROUP BY c ORDER BY COUNT(e) DESC LIMIT 1")
    Course findMostEnrolledCourse();
}