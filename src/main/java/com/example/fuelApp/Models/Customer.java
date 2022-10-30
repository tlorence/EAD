package com.example.fuelApp.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Customer {

    @Id
    public String nic;
    public String stationID;
    public String fuelType;
    public String arrivalTime;
    public String departTime;

    public Customer(String nic, String stationID, String fuelType, String arrivalTime, String departTime) {
        this.nic = nic;
        this.stationID = stationID;
        this.fuelType = fuelType;
        this.arrivalTime = arrivalTime;
        this.departTime = departTime;
    }


    public Customer() {
    }
}
