package org.example.proj_module_reseaux.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupLocation;
    private String dropOffLocation;
    private LocalDateTime pickupTime;
    private LocalDateTime dropOffTime;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Driver driver;

    // Constructors

    // Getters and Setters

    // toString() method

    // Other helper methods if needed
}
