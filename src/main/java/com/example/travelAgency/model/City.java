package com.example.travelAgency.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="name")
    private String name;
}
