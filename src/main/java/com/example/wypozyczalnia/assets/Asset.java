package com.example.wypozyczalnia.assets;

import com.example.wypozyczalnia.assignment.Assignment;
import com.example.wypozyczalnia.category.Category;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "asset")
    private Set<Assignment> assigments = new HashSet<>();

    public Asset() {
    }

    public Asset(String name, String description, String serialNumber, Category category) {
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Set<Assignment> getAssigments() {
        return assigments;
    }

    public void setAssigments(Set<Assignment> assigments) {
        this.assigments = assigments;
    }
}
