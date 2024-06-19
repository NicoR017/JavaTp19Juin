package com.example.travelAgency.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="airplane")

public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="name")
    private String name;


}
