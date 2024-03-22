package org.example.proj_module_reseaux.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table(name = "dirvers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;


    // Constructors

    public Driver() {
    }

    public Driver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
// Getters and Setters

    // toString() method

    // Other helper methods if needed
}

