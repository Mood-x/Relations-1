package com.example.school_management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.school_management.API.ApiException;
import com.example.school_management.Model.Teacher;
import com.example.school_management.Repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll(); 
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher); 
    }

    public void updateTeacher(Integer id, Teacher updateTeacher){
        Teacher teacher = teacherRepository.findTeacherById(id)
            .orElseThrow(() -> new ApiException("TEACHER NOT FOUND")); 

        teacher.setAddress(updateTeacher.getAddress());
        teacher.setAge(updateTeacher.getAge());
        teacher.setEmail(updateTeacher.getEmail());
        teacher.setSalary(updateTeacher.getSalary());
        teacherRepository.save(teacher); 
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id)
            .orElseThrow(() -> new ApiException("TEACHER NOT FOUND")); 
        teacherRepository.delete(teacher);
    }
}
