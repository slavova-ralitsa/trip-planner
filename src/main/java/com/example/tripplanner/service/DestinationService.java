package com.example.tripplanner.service;

import com.example.tripplanner.entities.Destination;
import com.example.tripplanner.entities.User;
import com.example.tripplanner.repositories.DestinationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }

    public Destination createDestination(Destination destination){
        return destinationRepository.save(destination);
    }

    public Destination getDestinationById(Long id){
        return destinationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Destination getDestinationByCoordinates(double latitude, double longitude){
        return destinationRepository.findByLatitudeAndLongitude(latitude, longitude)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Destination> getDestinationsByCountry(String country){
        return destinationRepository.findByCountry(country);
    }

    public void deleteDestinationById(Long id){
        if(destinationRepository.existsById(id))
                destinationRepository.deleteById(id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Destination updateDestination(Long id, Destination destination) {
        if (destinationRepository.existsById(id)) {
             destination.setId(id);

             return destinationRepository.save(destination);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Destination> findAll() {
        return destinationRepository.findAll();
    }


    }
