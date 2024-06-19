package com.example.travelAgency.service;

import com.example.travelAgency.model.Airplane;
import com.example.travelAgency.model.Flight;
import com.example.travelAgency.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightServiceImpl implements FlightService{


    @Autowired
    private FlightRepository flightRepository;
    private  List<Flight> vols =new ArrayList<>();
    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public void add(Flight flight) {

        if
        (flight.getId() ==null|| flight.getId().isEmpty()) {
            flight.setId(UUID.randomUUID().toString());
        }
        flightRepository.save(flight);
    }

    @Override
    public void update(Flight flightParameter) {
        if(flightParameter.getAirplane().getId() != 0){
            //airplaneRepository.save(flightParameter);

        }
    }

    @Override
    public void delete(String id) {
        if(findById(id) != null){
            flightRepository.deleteById(id);
        }
    }

    @Override
    public Flight findById(String id) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if(optionalFlight.isPresent()){
            return optionalFlight.get();
        }
        return null;
    }

}
