package org.example.proj_module_reseaux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.proj_module_reseaux.model.Client;
import org.example.proj_module_reseaux.service.ClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerTest {
    private static final String END_POINT_PATH = "/api/clients";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClientService clientService;

    @BeforeEach
    void setUp() {
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    public void getAllClients400BadRequest() throws Exception {/*
        Client client = new Client("John Doe", null, "", "lat1", "lon1");

        String requestBody = objectMapper.writeValueAsString(client);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
                .content(requestBody))
                .andExpect(status().isBadRequest())
                .andDo(print())
        ;*/
    }
    @Test
    void createClient() throws Exception {/*
        // Mock data
        Client client = new Client("John Doe", "1234567890", "1990-01-01", "lat1", "lon1");

        // Mock the service method
        Mockito.when(clientService.saveClient(client)).thenReturn(client);

        String requestBody = objectMapper.writeValueAsString(client);

        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
                .content(requestBody))
                .andExpect(status().isCreated())
                .andDo(print())
        ;*/
    }

    @Test
    void getClientById() throws Exception {/*

        Client client = new Client("John Doe", "1234567890", "1990-01-01", "lat1", "lon1");
        Long userId = client.getId();
        String requestURI = END_POINT_PATH + "/" + userId;

        Mockito.when(clientService.getClientById(userId)).thenReturn(client);
        String requestBody = objectMapper.writeValueAsString(client);

        mockMvc.perform(get(requestURI))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(requestBody))
                .andDo(print());*/
    }

    @Test
    void getAllClients() {
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClient() {
    }
}