package com.example.airline_api.models;

import java.util.List;

public class FlightDTO {


    private Long passengerIds;

    public FlightDTO(Long passengerIds){
        this.passengerIds = passengerIds;
    }

    public FlightDTO(){
    }


    public Long getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(Long passengerIds) {
        this.passengerIds = passengerIds;
    }
}
