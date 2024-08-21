package com.example.school_management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school_management.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
    Optional<Address> findAddressById(Integer id); 

}
