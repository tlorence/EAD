package com.example.fuelApp.Services;

import com.example.fuelApp.Models.Customer;
import com.example.fuelApp.Models.FuelStation;
import com.example.fuelApp.repositories.CustomerRepository;
import com.example.fuelApp.repositories.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class FuelStationService {

    @Autowired
    FuelStationRepository fuelStationRepository;
    @Autowired
    CustomerRepository customerRepository;
    LocalDateTime date = LocalDateTime.now();

    public List<FuelStation> getAllStations() {
        List<FuelStation> fuelStations;
        fuelStations = fuelStationRepository.findAll();
        for (FuelStation fuelStation : fuelStations) {
            if (fuelStation.petrolFinishTime == null && fuelStation.petrolArrivalTime != null) {
                fuelStation.petrol = 1;
            } else {
                fuelStation.petrol = 0;
            }
            if (fuelStation.dieselFinishTime == null && fuelStation.dieselArrivalTime != null) {
                fuelStation.diesel = 1;
            } else {
                fuelStation.diesel = 0;
            }
            List results = calcWaitingTimeAndQueueLength(fuelStation.stationId, "Petrol");
            fuelStation.setPetrolWaitingTime((Integer) results.get(0));
            fuelStation.setPetrolQueue((Integer) results.get(1));
            results = calcWaitingTimeAndQueueLength(fuelStation.stationId, "Diesel");
            fuelStation.setDieselWaitingTime((Integer) results.get(0));
            fuelStation.setDieselQueue((Integer) results.get(1));
        }
        return fuelStations;
    }

    public void updatePetrolArrivalTime(String stationID, String location) {
        List<FuelStation> fuelStations;
        fuelStations = (List<FuelStation>) fuelStationRepository.findAllById(Collections.singleton(stationID));
        for (FuelStation fuelStation : fuelStations) {
            fuelStation.setStationId(stationID);
            fuelStation.setLocation(location);
            fuelStation.setPetrolArrivalTime(LocalDateTime.now().toString());
            fuelStation.setPetrolFinishTime(null);
            fuelStationRepository.save(fuelStation);
        }
        if (fuelStations.isEmpty()) {
            FuelStation fuelStation = new FuelStation();
            fuelStation.setStationId(stationID);
            fuelStation.setLocation(location);
            fuelStation.setPetrolArrivalTime(LocalDateTime.now().toString());
            fuelStation.setPetrolFinishTime(null);
            fuelStationRepository.save(fuelStation);
        }
    }

    public void updateDieselArrivalTime(String stationID, String location) {
        List<FuelStation> fuelStations;
        fuelStations = (List<FuelStation>) fuelStationRepository.findAllById(Collections.singleton(stationID));
        for (FuelStation fuelStation : fuelStations) {
            fuelStation.setStationId(stationID);
            fuelStation.setLocation(location);
            fuelStation.setDieselArrivalTime(LocalDateTime.now().toString());
            fuelStation.setDieselFinishTime(null);
            fuelStationRepository.save(fuelStation);
        }
        if (fuelStations.isEmpty()) {
            FuelStation fuelStation = new FuelStation();
            fuelStation.setStationId(stationID);
            fuelStation.setLocation(location);
            fuelStation.setDieselArrivalTime(LocalDateTime.now().toString());
            fuelStation.setDieselFinishTime(null);
            fuelStationRepository.save(fuelStation);
        }
    }

    public void updatePetrolFinishTime(String stationID) {
        List<FuelStation> fuelStations;
        fuelStations = (List<FuelStation>) fuelStationRepository.findAllById(Collections.singleton(stationID));
        for (FuelStation fuelStation : fuelStations) {
            fuelStation.setStationId(stationID);
            fuelStation.setPetrolFinishTime(LocalDateTime.now().toString());
            fuelStationRepository.save(fuelStation);
        }
        if (fuelStations.isEmpty()) {
            FuelStation fuelStation = new FuelStation();
            fuelStation.setStationId(stationID);
            fuelStation.setPetrolFinishTime(LocalDateTime.now().toString());
            fuelStationRepository.save(fuelStation);
        }
    }

    public void updateDieselFinishTime(String stationID) {
        List<FuelStation> fuelStations;
        fuelStations = (List<FuelStation>) fuelStationRepository.findAllById(Collections.singleton(stationID));
        for (FuelStation fuelStation : fuelStations) {
            fuelStation.setStationId(stationID);
            fuelStation.setDieselFinishTime(LocalDateTime.now().toString());
            fuelStationRepository.save(fuelStation);
        }
        if (fuelStations.isEmpty()) {
            FuelStation fuelStation = new FuelStation();
            fuelStation.setStationId(stationID);
            fuelStation.setDieselFinishTime(LocalDateTime.now().toString());
            fuelStationRepository.save(fuelStation);
        }
    }

    public List calcWaitingTimeAndQueueLength(String stationID, String fuelType) {
        List<Customer> customers = customerRepository.customerFindByFuelType(fuelType, stationID);
        long timeDiff = 0;
        int avg = 0;
        Duration duration;
        int count = 0;
        List results = new ArrayList();
        for (Customer customer : customers) {
            if (customer.getDepartTime() == null && customer.getArrivalTime() != null) {
                duration = Duration.between(LocalDateTime.parse(LocalDateTime.now().toString()), LocalDateTime.parse(customer.getArrivalTime()));
                long diff = Math.abs(duration.toMinutes());
                timeDiff = timeDiff + diff;
                count++;
            }
        }
        if (count > 0) {
            avg = (int) (timeDiff / count);
        }
        results.add(avg);
        results.add(count);
        return results;
    }
}
