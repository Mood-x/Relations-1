package com.example.school_management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school_management.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

    Optional<Course> findCourseById(Integer id); 
}
