package com.example.travelAgency.service;

import com.example.travelAgency.model.City;
import com.example.travelAgency.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public void add(City city) {
        cityRepository.save(city);
    }

    @Override
    public void update(City cityParameter) {
        if(findById(cityParameter.getId()) != null) {
            cityRepository.save(cityParameter);
        }
    }

    @Override
    public void delete(int id) {
        if(findById(id) != null) {
            cityRepository.deleteById(id);
        }
    }

    @Override
    public City findById(int id) {
        Optional<City> city = cityRepository.findById(id);
        if(city.isPresent()) {
            return city.get();
        }
        return null;
    }
}
