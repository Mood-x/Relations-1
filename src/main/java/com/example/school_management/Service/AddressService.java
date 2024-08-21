package com.example.school_management.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.school_management.API.ApiException;
import com.example.school_management.DTO.AddressDTO;
import com.example.school_management.Model.Address;
import com.example.school_management.Model.Teacher;
import com.example.school_management.Repository.AddressRepository;
import com.example.school_management.Repository.TeacherRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository; 

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id())
            .orElseThrow(() -> new ApiException("ADDRESS NOT FOUND"));
        
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        
        addressRepository.save(address); 
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id())
            .orElseThrow(() -> new ApiException("ADDRESS NOT FOUND")); 

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address); 
    }

    @Transactional
    public void deleteAddress(Integer teacherId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId)
            .orElseThrow(() -> new ApiException("TEACHER NOT FOUND")); 

        addressRepository.delete(teacher.getAddress());
        teacher.setAddress(null);
        teacherRepository.save(teacher);
    }

    public Teacher getTeacherDetails(Integer teacherId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId)
            .orElseThrow(() -> new ApiException("TEACHER NOT FOUND")); 
        return teacher; 
    }
}
