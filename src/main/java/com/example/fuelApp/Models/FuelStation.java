package com.example.fuelApp.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class FuelStation {

    @Id
    public String  stationId ;
    public String location;
    public int petrol;
    public int diesel;
    public String petrolArrivalTime;
    public String dieselArrivalTime ;
    public String petrolFinishTime;
    public String dieselFinishTime ;
    public int petrolWaitingTime;
    public int dieselWaitingTime;
    public int petrolQueue;
    public int dieselQueue;


    public FuelStation() {
    }

    public FuelStation(String stationId, String location, String petrolArrivalTime, String dieselArrivalTime, String petrolFinishTime, String dieselFinishTime) {
        this.stationId = stationId;
        this.location = location;
        this.petrolArrivalTime = petrolArrivalTime;
        this.dieselArrivalTime = dieselArrivalTime;
        this.petrolFinishTime = petrolFinishTime;
        this.dieselFinishTime = dieselFinishTime;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPetrol() {
        return petrol;
    }

    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    public int getDiesel() {
        return diesel;
    }

    public void setDiesel(int diesel) {
        this.diesel = diesel;
    }

    public String getPetrolArrivalTime() {
        return petrolArrivalTime;
    }

    public void setPetrolArrivalTime(String petrolArrivalTime) {
        this.petrolArrivalTime = petrolArrivalTime;
    }

    public String getDieselArrivalTime() {
        return dieselArrivalTime;
    }

    public void setDieselArrivalTime(String dieselArrivalTime) {
        this.dieselArrivalTime = dieselArrivalTime;
    }

    public String getPetrolFinishTime() {
        return petrolFinishTime;
    }

    public void setPetrolFinishTime(String petrolFinishTime) {
        this.petrolFinishTime = petrolFinishTime;
    }

    public String getDieselFinishTime() {
        return dieselFinishTime;
    }

    public void setDieselFinishTime(String dieselFinishTime) {
        this.dieselFinishTime = dieselFinishTime;
    }

    public int getPetrolWaitingTime() {
        return petrolWaitingTime;
    }

    public void setPetrolWaitingTime(int petrolWaitingTime) {
        this.petrolWaitingTime = petrolWaitingTime;
    }

    public int getDieselWaitingTime() {
        return dieselWaitingTime;
    }

    public void setDieselWaitingTime(int dieselWaitingTime) {
        this.dieselWaitingTime = dieselWaitingTime;
    }
}
