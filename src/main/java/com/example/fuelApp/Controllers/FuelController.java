package com.example.fuelApp.Controllers;

import com.example.fuelApp.Models.FuelStation;
import com.example.fuelApp.Services.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/fuel")
public class FuelController {

    @Autowired
    FuelStationService fuelStationService;

    @GetMapping("/getStations")
    public List<FuelStation> getAllStations() {
        return fuelStationService.getAllStations();
    }

    @PostMapping ("/petrolArrival")
    public void updatePetrolArrivalTime(@RequestParam(value = "stationID") String stationID,@RequestParam(value = "location") String location){

        fuelStationService.updatePetrolArrivalTime(stationID,location);
    }

    @PostMapping ("/petrolFinish")
    public void updatePetrolFinishTime(@RequestParam(value = "stationID") String stationID){

        fuelStationService.updatePetrolFinishTime(stationID);
    }

    @PostMapping ("/dieselArrival")
    public void updateDieselArrivalTime(@RequestParam(value = "stationID") String stationID,@RequestParam(value = "location") String location){

        fuelStationService.updateDieselArrivalTime(stationID,location);
    }

    @PostMapping ("/dieselFinish")
    public void updateDieselFinishTime(@RequestParam(value = "stationID") String stationID){

        fuelStationService.updateDieselFinishTime(stationID);
    }

}