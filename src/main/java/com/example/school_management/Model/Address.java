package com.example.school_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class Address {

    @Id
    private Integer id; 

    @NotEmpty(message = "Area should be not empty")
    private String area; 

    @NotEmpty(message = "Street should be not empty")
    private String street; 

    @NotNull
    @Positive
    private Integer buildingNumber; 

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher; 
}
