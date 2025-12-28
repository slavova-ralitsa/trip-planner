package com.example.tripplanner.repositories;
import com.example.tripplanner.entities.Destination;
import com.example.tripplanner.entities.User;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {
    Optional<Destination> findByLatitudeAndLongitude(double latitude, double longitude);

    List<Destination> findByCountry(String country);
}
