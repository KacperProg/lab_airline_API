package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FlightServices {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public void addNewFlight(Flight flight){flightRepository.save(flight);}

    public void cancelFlight(Flight flight){flightRepository.delete(flight);}

    public List<Flight> getAllFlights(){return flightRepository.findAll();}

    public void addPassengerToFlight(FlightDTO flightDTO, Long id){
        Passenger passenger = passengerRepository.findById(id).get();
        Flight flight = flightRepository.findById(id).get();
        flight.addPassenger(passenger);
    }

    public Flight getFlightById(Long id){return flightRepository.getReferenceById(id);}




}
