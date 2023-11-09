package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServices {

    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }
    public Optional<Passenger> getPassengerById(Long id){
        return passengerRepository.findById(id);
    }
    public void addNewPassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }


}
