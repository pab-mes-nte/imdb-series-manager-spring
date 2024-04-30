package model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "writer")
public class Writer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    // Writer -> Series
    @ManyToMany(mappedBy = "writersList")
    private List<Series> seriesList;


    public Writer() {
        // Required empty constructor
    }

    public Writer(String name) {
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
        return "Writer{" + "name='" + name + '\'' + '}';
    }
}