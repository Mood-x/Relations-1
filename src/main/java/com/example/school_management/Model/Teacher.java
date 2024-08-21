package com.example.school_management.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Teacher {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @NotEmpty(message = "Name should be not empty")
    @Size(min = 3, max = 25, message = "Name length must between 3 to 25")
    @Column(columnDefinition = "varchar(25) not null")
    private String name; 


    @NotNull(message = "Age should be not null")
    @Positive
    @Column(columnDefinition = "int not null")
    private Integer age; 

    @NotEmpty(message = "Email should be not empty")
    @Size(min = 10, max = 30, message = "Email length must between 10 to 30")
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email; 

    @NotNull
    @PositiveOrZero
    @Column(columnDefinition = "double not null")
    private double salary; 


    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address; 
}
