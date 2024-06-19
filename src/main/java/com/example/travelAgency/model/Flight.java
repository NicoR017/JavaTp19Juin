package com.example.travelAgency.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name="flight")
public class Flight {
   @Id
   @Column(name="flight_number")
    private String id;

   @ManyToOne
   @JoinColumn(name="airplane_id")
   private Airplane airplane;

   @ManyToOne
   @JoinColumn(name="departure_city_id")
   private City departureCity;

   @ManyToOne
   @JoinColumn(name="arrival_city_id")
   private City arrival_city;

   @Column(name="departure_time")
   private LocalDateTime departureTime;

   @Column(name="arrival_time")
   private LocalDateTime  arrivalTime;






}
