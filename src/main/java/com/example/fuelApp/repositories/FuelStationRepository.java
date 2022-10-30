package com.example.fuelApp.repositories;


import com.example.fuelApp.Models.FuelStation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FuelStationRepository extends MongoRepository<FuelStation,String>{
}

