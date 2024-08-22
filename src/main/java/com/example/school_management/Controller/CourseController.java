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
import com.example.school_management.Model.Course;
import com.example.school_management.Service.CourseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService; 

    @GetMapping
    public ResponseEntity getCourses(){
        return ResponseEntity.ok(courseService.getCourses()); 
    }

    @PostMapping
    public ResponseEntity addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.ok(new ApiResponse("Course added")); 
    }


    @PutMapping
    public ResponseEntity updateCourse(@RequestParam Integer id, @Valid @RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.ok(new ApiResponse("Course updated")); 
    }


    @DeleteMapping
    public ResponseEntity deleteCourse(@RequestParam Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok(new ApiResponse("Course deleted")); 
    }

    @PutMapping("/{teacherId}/assign-to/{courseId}")
    public ResponseEntity assignToTecher(@PathVariable Integer teacherId, @PathVariable Integer courseId){
        courseService.assignToTeacher(teacherId, courseId);
        return ResponseEntity.ok(new ApiResponse("Course assign to " + teacherId)); 
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity returnTeacherClass(@PathVariable Integer courseId){
        return ResponseEntity.ok(new ApiResponse("Teacher name: " + courseService.returnTeacherClass(courseId))); 
    }
}
