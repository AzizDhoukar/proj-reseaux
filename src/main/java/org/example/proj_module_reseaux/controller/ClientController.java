package org.example.proj_module_reseaux.controller;

import org.example.proj_module_reseaux.model.Client;
import org.example.proj_module_reseaux.model.Driver;
import org.example.proj_module_reseaux.model.Location;
import org.example.proj_module_reseaux.service.ClientService;
import org.example.proj_module_reseaux.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    private final DriverService driverService;

    @Autowired
    public ClientController(ClientService clientService, DriverService driverService) {
        this.clientService = clientService;
        this.driverService = driverService;
    }
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.saveClient(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        if (updatedClient != null) {
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        Client client = clientService.getClientById(id);
        if (client != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @PostMapping("location/{id}")
    public ResponseEntity<Client> createClient(@RequestBody Location location, @PathVariable("id") long id) {
        Client client = clientService.updateLocation(id, location);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @GetMapping("request/{id}")
    public ResponseEntity<Driver> requestDriver(@PathVariable("id") long id) {
        List<Driver> drivers = driverService.getAllDrivers();
        Client client = clientService.getClientById(id);
        //look for the closest driver
        Driver closestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : drivers) {
            double distance = clientService.calculateDistance(client.getLat(), client.getLon(), driver.getLat(), driver.getLon());
            if (distance < minDistance) {
                minDistance = distance;
                closestDriver = driver;
            }
        }
        assert closestDriver != null;
        closestDriver.setClientId(client.getId());
        return new ResponseEntity<>(closestDriver, HttpStatus.OK);
    }
}
