package com.upc.edu.BackEndTripStore.service;

import com.upc.edu.BackEndTripStore.model.Trip;

import java.util.List;

public interface TripService {
    List<Trip> getAllTrips();
    Trip getTripById(int id);
    Trip saveTrip(Trip trip);
    void deleteTrip(int id);
}
