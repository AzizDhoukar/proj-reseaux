package org.example.proj_module_reseaux.service;

import org.example.proj_module_reseaux.model.Vehicle;
import org.example.proj_module_reseaux.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
        private final VehicleRepository vehicleRepository;

        public VehicleService(VehicleRepository vehicleRepository){
                this.vehicleRepository = vehicleRepository;
        }
        Vehicle saveVehicle(Vehicle vehicle){
                return vehicleRepository.save(vehicle);
        }

        Vehicle getVehicleById(Long id){
                return vehicleRepository.getReferenceById(id);
        }

        List<Vehicle> getAllVehicles(){
                return vehicleRepository.findAll();
        }

        void deleteVehicle(Long id){
                vehicleRepository.deleteById(id);
        }
}
