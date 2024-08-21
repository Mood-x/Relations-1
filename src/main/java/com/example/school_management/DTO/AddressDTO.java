package com.example.school_management.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id; 

    @NotEmpty(message = "Area should be not empty")
    private String area; 

    @NotEmpty(message = "Street should be not empty")
    private String street; 

    @NotNull
    @Positive
    private Integer buildingNumber; 
}
