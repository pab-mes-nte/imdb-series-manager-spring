package model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "country")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    // Country -> Series
    @ManyToMany(mappedBy = "countriesList")
    private List<Series> seriesList;


    public Country() {
        // Required empty constructor
    }

    public Country(String name) {
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
        return "Country{" + "name='" + name + '\'' + '}';
    }
}