package com.example.tripplanner.service;

import com.example.tripplanner.entities.Destination;
import com.example.tripplanner.repositories.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }

    public Destination createDestination(Destination destination){
        return destinationRepository.save(destination);
    }

    public Optional<Destination> getDestinationById(Long id){
        return destinationRepository.findById(id);
    }

    public Optional<Destination> getDestinationByCoordinates(double latitude, double longitude){
        return destinationRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

    public List<Destination> getDestinationsByCountry(String country){
        return destinationRepository.findByCountry(country);
    }

    public void deleteDestinationById(Long id){
        destinationRepository.deleteById(id);
    }
}
