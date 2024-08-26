package com.example.school_management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school_management.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    Optional<Student> findStudentById(Integer id);
    // Optional<List<Student>> findStudentsByCourseId(Integer id); 

}
