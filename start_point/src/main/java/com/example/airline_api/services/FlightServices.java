package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServices {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public void addNewFlight(Flight flight){flightRepository.save(flight);}

    public void cancelFlight(Flight flight){flightRepository.delete(flight);}

    public List<Flight> getAllFlights(){return flightRepository.findAll();}

    @Transactional
    public void addPassengerToFlight(FlightDTO flightDTO, Long id){
        Passenger passenger = passengerRepository.findById(id).get();
        Flight flight = flightRepository.findById(id).get();
        flight.addPassenger(passenger);
        flightRepository.delete(flight);
        flightRepository.save(flight);
    }

    public Flight getFlightById(Long id){return flightRepository.findById(id).get();}




}
