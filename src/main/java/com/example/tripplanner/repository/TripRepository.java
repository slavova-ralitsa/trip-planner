package com.example.tripplanner.repository;

import com.example.tripplanner.entity.Destination;
import com.example.tripplanner.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findByUserId(Long userId);

    Optional<Trip> findByIdAndUserId(Long tripId, Long userId);

    Optional<Trip> findByStartDate(Date startDate);

    Optional<Trip> findByCreatedDate(Date createdDate);
}
