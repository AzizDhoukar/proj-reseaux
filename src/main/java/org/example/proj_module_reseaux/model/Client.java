package org.example.proj_module_reseaux.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String dataOfBirth;

    private String lat;
    private String lon;

    public Client(String name, String phone, String dataOfBirth, String lat, String lon) {
        this.name = name;
        this.phone = phone;
        this.dataOfBirth = dataOfBirth;
        this.lat = lat;
        this.lon = lon;
    }
}
