package com.example.travelAgency.repository;

import com.example.travelAgency.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, String> {
}
