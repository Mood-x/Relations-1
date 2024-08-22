package com.example.school_management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.school_management.API.ApiException;
import com.example.school_management.Model.Course;
import com.example.school_management.Model.Teacher;
import com.example.school_management.Repository.CourseRepository;
import com.example.school_management.Repository.TeacherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository; 
    private final TeacherRepository teacherRepository; 

    public List<Course> getCourses(){
        return courseRepository.findAll(); 
    }

    public void addCourse(Course course){
        courseRepository.save(course); 
    }

    public void updateCourse(Integer courseId,  Course updateCourse){
        Course course = courseRepository.findCourseById(courseId)
            .orElseThrow(() -> new ApiException("COURSE NOT FOUND")); 

        course.setName(updateCourse.getName());
        courseRepository.save(course); 
    }

    public void deleteCourse(Integer courseId){
        Course course = courseRepository.findCourseById(courseId)
            .orElseThrow(() -> new ApiException("COURSE NOT FOUND")); 
        courseRepository.delete(course); 
    }

    public void assignToTeacher(Integer teacherId,Integer courseId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId)
            .orElseThrow(() -> new ApiException("TEACHER NOT FOUND"));

        Course course = courseRepository.findCourseById(courseId)
            .orElseThrow(() -> new ApiException("COURSE NOT FOUND")); 

        course.setTeacher(teacher);
        courseRepository.save(course); 
    }

    public String returnTeacherClass(Integer courseId){
        Course course = courseRepository.findCourseById(courseId)
            .orElseThrow(() -> new ApiException("COURSE NOT FOUND")); 
        
        return course.getTeacher().getName(); 
    }
}
