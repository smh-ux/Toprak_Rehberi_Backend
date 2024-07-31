package com.example.Internship.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "products")
    private List<Land> lands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
