package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightServices;
import com.example.airline_api.services.PassengerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerServices passengerServices;
    // Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerServices.getAllPassengers(), HttpStatus.OK);
    }

    // Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassengerById(@PathVariable Long id){
        return new ResponseEntity<>(passengerServices.getPassengerById(id), HttpStatus.OK);
    }

    // Add a new passenger
    @PostMapping
    public ResponseEntity<List<Passenger>> addNewPassenger(@RequestBody Passenger passenger){
        passengerServices.addNewPassenger(passenger);
        return new ResponseEntity<>(passengerServices.getAllPassengers(), HttpStatus.OK);
    }

}
