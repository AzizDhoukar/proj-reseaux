package org.example.proj_module_reseaux.webSocket;

import org.example.proj_module_reseaux.model.ClientLocationHistory;
import org.example.proj_module_reseaux.model.DriverLocationHistory;
import org.example.proj_module_reseaux.repository.ClientLocationHistoryRepository;
import org.example.proj_module_reseaux.repository.ClientRepository;
import org.example.proj_module_reseaux.service.ClientLocationHistoryService;
import org.example.proj_module_reseaux.service.DriverLocationHistoryService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketController {

    private final ClientLocationHistoryService clientService;
    private final DriverLocationHistoryService driverService;

    public WebSocketController(ClientLocationHistoryService clientService, DriverLocationHistoryService driverService) {
        this.clientService = clientService;
        this.driverService = driverService;
    }

    @MessageMapping("/clientLocation")  //the client sends to /app/clientLocation
    @SendTo("/track/client") //The client location is broadcast to all subscribers this path
    public ClientLocationHistory updateLocation(ClientLocationHistory location) throws Exception {
        System.out.print("location");
        // send the new location to the database
        // update the relevant parties of the update
        return clientService.saveClientLocationHistory(location);
    }
    @MessageMapping("/driverLocation")  //the driver sends to /app/clientLocation
    @SendTo("/track/driver") //The driver location is broadcast to all subscribers of this path
    public Coords  updateLocation(Coords coords) throws Exception {
        System.out.print("location" + coords);
        // send the new location to the database
        //driverService.saveDriverLocationHistory(location);
        // update the relevant parties of the update
        return coords;
    }

    public class LocationData {
        private long timestamp;
        private boolean mocked;
        private Coords coords;

        // Getters and setters
    }

    public class Coords {
        private double speed;
        private double longitude;
        private double latitude;
        private int heading;
        private double altitudeAccuracy;
        private double altitude;
        private double accuracy;

        // Getters and setters
    }
}
