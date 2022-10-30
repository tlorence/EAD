package com.example.fuelApp.repositories;

import com.example.fuelApp.Models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    @Query("{fuelType:?0,stationID:?1}")
    List<Customer> customerFindByFuelType(String fuelType,String stationID);
}