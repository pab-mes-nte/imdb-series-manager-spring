package com.example.services;

import com.example.model.entities.Rating;
import com.example.model.entities.Series;
import com.example.model.repositories.RatingRepository;
import com.example.model.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {

    // Repositories
    private final SeriesRepository seriesRep;
    private final RatingRepository ratingRep;

    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRep, RatingRepository ratingRep) {
        this.seriesRep = seriesRep;
        this.ratingRep = ratingRep;
    }

    @Override
    public List<Series> getSeries() {
        return seriesRep.findAll();
    }

    @Override
    public Series getSerieById(Long id) {
        return seriesRep.findById(id).orElse(null);
    }

    @Override
    public List<Series> getSeriesLikeName(String name) {
        return seriesRep.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Rating> getRatingsBySeriesId(Long id) {
        return ratingRep.findBySeriesId(id);
    }
}