package org.example.proj_module_reseaux.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String dataOfBirth;

    // Constructors

    public Client(String name, String phone, String dataOfBirth) {
        this.name = name;
        this.phone = phone;
        this.dataOfBirth = dataOfBirth;
    }

    public Client() {

    }

    // Getters and Setters

    // toString() method

    // Other helper methods if needed
}
