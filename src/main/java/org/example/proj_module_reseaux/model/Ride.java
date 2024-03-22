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
@Table(name = "rides")
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

    public Ride(String pickupLocation, String dropOffLocation, LocalDateTime pickupTime, LocalDateTime dropOffTime, Client client, Driver driver) {
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.pickupTime = pickupTime;
        this.dropOffTime = dropOffTime;
        this.client = client;
        this.driver = driver;
    }

    public Ride() {

    }

    // Getters and Setters

    // toString() method

    // Other helper methods if needed
}
