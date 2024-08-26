package com.example.school_management.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.school_management.API.ApiResponse;
import com.example.school_management.Model.Student;
import com.example.school_management.Service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService; 

    @GetMapping
    public ResponseEntity getStudents(){
        return ResponseEntity.ok(studentService.getStudents()); 
    }

    @PostMapping
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok(new ApiResponse("Student Added")); 
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestParam Integer id, @Valid @RequestBody Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.ok(new ApiResponse("Student updated")); 
    }

    @DeleteMapping
    public ResponseEntity deleteStudent(@RequestParam Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok(new ApiResponse("Student deleted")); 
    }


    @PostMapping("/{studentId}/assign-to/{courseId}")
    public ResponseEntity addStudent(@PathVariable Integer studentId, @PathVariable Integer courseId){
        studentService.assignStudentToCourse(studentId, courseId);
        return ResponseEntity.ok(new ApiResponse("Assigning Student to course and vice versa")); 
    }



    @PutMapping("/{studentId}/change-major/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer studentId, @PathVariable String major){
        studentService.changeStudentMajor(studentId, major); 
        return ResponseEntity.ok(new ApiResponse("Changed student major")); 
    }
}
