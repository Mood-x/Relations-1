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
import com.example.school_management.DTO.AddressDTO;
import com.example.school_management.Service.AddressService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService; 

    @GetMapping
    public ResponseEntity getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddress()); 
    }

    @PostMapping
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.ok(new ApiResponse("Added teacher address")); 
    }

    @PutMapping
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.ok(new ApiResponse("Update address successfuly")); 
    }

    @DeleteMapping
    public ResponseEntity deleteAddress(@RequestParam Integer teacherId){
        addressService.deleteAddress(teacherId);
        return ResponseEntity.ok(new ApiResponse("Delete address successfuly")); 
    }


    @GetMapping("/{teacherId}/details")
    public ResponseEntity getTeacherDetails(@PathVariable Integer teacherId){
        return ResponseEntity.ok(addressService.getTeacherDetails(teacherId)); 
    }
}
