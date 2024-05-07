package com.example.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    // TODO: Normalize Values of Ratings (out of 100, out of 10...)
    private int value;

    // Ratings -> Series
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "series_id")
    private Series series;


    public Rating() {
        // Required empty constructor
    }

    public Rating(String source, int value) {
        this.source = source;
        this.value = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Rating{" + "source='" + source + '\'' + ", value=" + value + ", series=" + series.getName() + '}';
    }
}