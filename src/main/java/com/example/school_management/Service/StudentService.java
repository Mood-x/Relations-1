package com.example.school_management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.school_management.API.ApiException;
import com.example.school_management.Model.Course;
import com.example.school_management.Model.Student;
import com.example.school_management.Repository.CourseRepository;
import com.example.school_management.Repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository; 
    private final CourseRepository courseRepository; 


    public List<Student> getStudents(){
        return studentRepository.findAll(); 
    }


    public void addStudent(Student student){
        studentRepository.save(student); 
    }

    public void updateStudent(Integer id, Student updateStudent){
        Student student = studentRepository.findStudentById(id)
            .orElseThrow(() -> new ApiException("STUDENT NOT FOUND")); 

        student.setName(updateStudent.getName());
        student.setAge(updateStudent.getAge());
        student.setMajor(updateStudent.getMajor());

        studentRepository.save(student); 
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id)
            .orElseThrow(() -> new ApiException("STUDENT NOT FOUND")); 
        studentRepository.delete(student); 
    }
    

    public void assignStudentToCourse(Integer studentId, Integer courseId){
        Student student = studentRepository.findStudentById(studentId)
            .orElseThrow(() -> new ApiException("STUDENT NOT FOUND")); 

        Course course = courseRepository.findCourseById(courseId)
            .orElseThrow(() -> new ApiException("COURSE NOT FOUND")); 

        student.getCourses().add(course); 
        course.getStudents().add(student); 

        studentRepository.save(student);
        courseRepository.save(course);  
    }

    public Student changeStudentMajor(Integer studentId, String major){
        Student student = studentRepository.findStudentById(studentId)
            .orElseThrow(() -> new ApiException("STUDENT NOT FOUND"));

        student.setMajor(major);
        student.getCourses().clear();
        return studentRepository.save(student);
    }
}