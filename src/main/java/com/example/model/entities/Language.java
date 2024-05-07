package com.example.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "language")
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    // Language -> Series
    @ManyToMany(mappedBy = "languagesList")
    @JsonIgnore
    private List<Series> seriesList;


    public Language() {
        // Required empty constructor
    }

    public Language(String name) {
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
        return "Language{" + "name='" + name + '\'' + '}';
    }
}