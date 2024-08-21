package com.example.school_management.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.school_management.API.ApiResponse;
import com.example.school_management.Model.Teacher;
import com.example.school_management.Service.TeacherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService; 


    @GetMapping
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.ok(teacherService.getAllTeachers()); 
    }

    @PostMapping
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok(new ApiResponse("Added Teacher Successfuly")); 
    }

    @PutMapping
    public ResponseEntity updateTeacher(@RequestParam Integer id, @Valid @RequestBody Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.ok(new ApiResponse("Updated Teacher Successfuly")); 
    }

    @DeleteMapping
    public ResponseEntity deleteTeacher(@RequestParam Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok(new ApiResponse("Deleted Teacher Successfuly")); 
    }
}
