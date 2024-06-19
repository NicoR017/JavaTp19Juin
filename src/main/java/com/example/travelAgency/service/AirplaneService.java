package com.example.travelAgency.service;

import com.example.travelAgency.model.Airplane;

import java.util.List;

public interface AirplaneService {

    public List<Airplane> getAll();
    public void add(Airplane airplane);
    public void update(Airplane airplaneParameter);
    public void delete(int id);
    public Airplane findById(int id);



}
