package org.example.proj_module_reseaux.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.proj_module_reseaux.model.Client;
import org.example.proj_module_reseaux.model.Location;
import org.example.proj_module_reseaux.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
    public Client getClientById(Long id){
        return clientRepository.getReferenceById(id);
    }
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
    public Client updateClient(Long clientId, Client updatedClient) {
        // Check if the client with the given ID exists
        Client existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + clientId));

        // Update the existing client with the new information
        existingClient.setName(updatedClient.getName());
        existingClient.setPhone(updatedClient.getPhone());

        // Save the updated client to the database
        return clientRepository.save(existingClient);
    }
    public Client updateLocation(long id, Location location) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + id));
        client.setLon(location.getLon());
        client.setLat(location.getLat());
        return clientRepository.save(client);
    }
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        double EARTH_RADIUS = 6371;

        return Math.sqrt(x * x + y * y) * EARTH_RADIUS;
    }
}
