package com.example.travelAgency.repository;

import com.example.travelAgency.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
