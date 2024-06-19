package com.example.travelAgency.service;

import com.example.travelAgency.model.Airplane;
import com.example.travelAgency.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AirplaneServiceImpl implements AirplaneService{

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public void add(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    @Override
    public void update(Airplane airplaneParameter) {
        if(findById(airplaneParameter.getId()) != null) {
            airplaneRepository.save(airplaneParameter);
        }
    }

    @Override
    public void delete(int id) {
        if(findById(id) != null) {
            airplaneRepository.deleteById(id);
        }
    }


    @Override
    public Airplane findById(int id) {

        Optional<Airplane> airplane = airplaneRepository.findById(id);
        if(airplane.isPresent()) {
            return airplane.get();
        }
        return null;
    }
}
