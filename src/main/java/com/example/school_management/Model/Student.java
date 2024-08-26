package com.example.school_management.Model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @NotEmpty(message = "Student name should be not empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String name; 
    
    @NotNull
    @Column(columnDefinition = "int not null")
    private int age; 

    @NotEmpty(message = "Major should be not empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses; 
    
}
