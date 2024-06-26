package org.example.proj_module_reseaux.webSocket;

import org.example.proj_module_reseaux.DTO.MessageDTO;
import org.example.proj_module_reseaux.model.ClientLocationHistory;
import org.example.proj_module_reseaux.model.DriverLocationHistory;
import org.example.proj_module_reseaux.model.Location;
import org.example.proj_module_reseaux.repository.ClientLocationHistoryRepository;
import org.example.proj_module_reseaux.repository.ClientRepository;
import org.example.proj_module_reseaux.service.ClientLocationHistoryService;
import org.example.proj_module_reseaux.service.DriverLocationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Location clientLocation(Location location) throws Exception {
        System.out.print("location" + location);
        // send the new location to the database
        // update the relevant parties of the update
        return location;
    }
    @MessageMapping("/driverLocation")  //the driver sends to /app/clientLocation
    @SendTo("/track/driver") //The driver location is broadcast to all subscribers of this path
    public Location driverLocation(Location location) throws Exception {
        System.out.print("location: " + location);
        // send the new location to the database
        //driverService.saveDriverLocationHistory(location);
        // update the relevant parties of the update
        return location;
    }

}
