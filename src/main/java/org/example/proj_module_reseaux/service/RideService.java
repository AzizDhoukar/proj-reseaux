package org.example.proj_module_reseaux.service;

import org.example.proj_module_reseaux.model.Ride;
import org.example.proj_module_reseaux.repository.RideRepository;

import java.util.List;

public class RideService {
    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }
    Ride saveRide(Ride ride){
        return rideRepository.save(ride);
    }

    Ride getRideById(Long id){
        return rideRepository.getReferenceById(id);
    }

    List<Ride> getAllRides(){
        return rideRepository.findAll();
    }

    List<Ride> getRidesByClientId(Long clientId){
        return rideRepository.findByClientId(clientId);
    }

    List<Ride> getRidesByDriverId(Long driverId){
        return rideRepository.findByDriverId(driverId);
    }

    void deleteRide(Long id){
        rideRepository.deleteById(id);
    }
}
