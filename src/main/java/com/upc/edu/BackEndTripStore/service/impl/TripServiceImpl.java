package com.upc.edu.BackEndTripStore.service.impl;

import com.upc.edu.BackEndTripStore.model.Trip;
import com.upc.edu.BackEndTripStore.repository.TripRepository;
import com.upc.edu.BackEndTripStore.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
    @Override
    public Trip getTripById(int id) {
        return tripRepository.findById(id).orElse(null);
    }

    @Override
    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public void deleteTrip(int id) {
        tripRepository.deleteById(id);
    }


}
