package com.example.travelAgency.service;

import com.example.travelAgency.model.Airplane;
import com.example.travelAgency.model.City;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CityService {

    public List<City> getAll();
    public void add(City city);
    public void update(City cityParameter);
    public void delete(int id);
    public City findById(int id);


}
