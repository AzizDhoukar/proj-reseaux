package org.example.proj_module_reseaux.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.proj_module_reseaux.model.Client;
import org.example.proj_module_reseaux.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

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
}
