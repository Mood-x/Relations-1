package com.example.school_management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school_management.Model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

    Optional<Teacher> findTeacherById(Integer id); 
}
