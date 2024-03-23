package org.example.proj_module_reseaux.service;

import org.example.proj_module_reseaux.model.DriverLocationHistory;
import org.example.proj_module_reseaux.repository.DriverLocationHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverLocationHistoryService {
    private final DriverLocationHistoryRepository Repository;


    public DriverLocationHistoryService (DriverLocationHistoryService Repository){
        this.Repository = (DriverLocationHistoryRepository) Repository;
    }
    public DriverLocationHistory saveDriverLocationHistory(DriverLocationHistory driver){
        return Repository.save(driver);
    }

    public DriverLocationHistory getDriverLocationHistoryById(Long id){
        return Repository.getReferenceById(id);
    }

    public List<DriverLocationHistory> getAllDriverLocationHistorys(){
        return Repository.findAll();
    }

    public void deleteDriverLocationHistory(Long id){
        Repository.deleteById(id);
    }
}
