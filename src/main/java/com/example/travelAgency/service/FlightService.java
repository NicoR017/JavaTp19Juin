package com.example.travelAgency.service;

import com.example.travelAgency.model.Airplane;
import com.example.travelAgency.model.Flight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    public List<Flight> getAll();
    public void add(Flight flight);
    public void update(Flight flightParameter);
    public void delete(String id);
    public Flight findById(String id);


}
