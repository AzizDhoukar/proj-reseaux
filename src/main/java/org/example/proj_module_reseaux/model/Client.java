package org.example.proj_module_reseaux.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NonNull
    private String name;
    @Column(nullable = false)
    @NonNull
    private String phone;

    private double lat;
    private double lon;

    public Client(String name, String phone, Long lat, Long lon) {
        this.name = name;
        this.phone = phone;
        this.lat = lat;
        this.lon = lon;
    }
}
