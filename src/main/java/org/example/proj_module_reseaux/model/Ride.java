package org.example.proj_module_reseaux.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}
