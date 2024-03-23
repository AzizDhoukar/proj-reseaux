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

    @MessageMapping("/clientLocation")  //the message is sent to /app/clientLocation
    @SendTo("/track/client") //The return value is broadcast to all subscribers of /topic/greetings
    public ClientLocationHistory updateLocation(ClientLocationHistory location) throws Exception {
        // send the new location to the database
        // update the relevant parties of the update
        return clientService.saveClientLocationHistory(location);
    }
    @MessageMapping("/driverLocation")  //the message is sent to /app/clientLocation
    @SendTo("/track/driver") //The return value is broadcast to all subscribers of /topic/greetings
    public DriverLocationHistory updateLocation(DriverLocationHistory location) throws Exception {
        // send the new location to the database
        driverService.saveDriverLocationHistory(location);
        // update the relevant parties of the update
        return location;
    }
}
