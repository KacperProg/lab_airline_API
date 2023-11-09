package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.services.FlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class    FlightController {

    @Autowired
    FlightServices flightServices;
    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightServices.getAllFlights(),HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        return new ResponseEntity<>(flightServices.getFlightById(id), HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<List<Flight>> addNewFlight(@RequestBody Flight flight){
        flightServices.addNewFlight(flight);
        return new ResponseEntity<>(flightServices.getAllFlights(), HttpStatus.OK);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<List<Flight>> addPassengerToFlight(@RequestBody FlightDTO flightDTO, @PathVariable Long id){
        flightServices.addPassengerToFlight(flightDTO,id);
        return new ResponseEntity<>(flightServices.getAllFlights(),HttpStatus.OK);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(@PathVariable Long id){
        Flight flight = flightServices.getFlightById(id);
        flightServices.cancelFlight(flight);
        return new ResponseEntity<>(flightServices.getAllFlights(),HttpStatus.OK);
    }

}
