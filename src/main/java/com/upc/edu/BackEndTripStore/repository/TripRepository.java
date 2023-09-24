package com.upc.edu.BackEndTripStore.repository;

import com.upc.edu.BackEndTripStore.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
}
