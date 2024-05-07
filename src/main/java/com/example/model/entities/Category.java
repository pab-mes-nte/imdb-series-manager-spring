package com.example.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    // Category -> Series
    @JsonIgnore
    @ManyToMany(mappedBy = "categoriesList")
    private List<Series> seriesList;


    public Category() {
        // Required empty constructor
    }

    public Category(String name) {
        this.name = name;
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

    public List<Series> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Series> seriesList) {
        this.seriesList = seriesList;
    }

    public void addSeries(Series series) {
        this.seriesList.add(series);
    }

    @Override
    public String toString() {
        return "Category{" + "name='" + name + '\'' + '}';
    }
}