package org.example.proj_module_reseaux.service;

import org.example.proj_module_reseaux.model.ClientLocationHistory;
import org.example.proj_module_reseaux.repository.ClientLocationHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientLocationHistoryService {
    private final ClientLocationHistoryRepository Repository;


    public ClientLocationHistoryService (ClientLocationHistoryRepository Repository){
        this.Repository = Repository;
    }
    public ClientLocationHistory saveClientLocationHistory(ClientLocationHistory client){
        return Repository.save(client);
    }

    public ClientLocationHistory getClientLocationHistoryById(Long id){
        return Repository.getReferenceById(id);
    }

    public List<ClientLocationHistory> getAllClientLocationHistorys(){
        return Repository.findAll();
    }

    public void deleteClientLocationHistory(Long id){
        Repository.deleteById(id);
    }
}
