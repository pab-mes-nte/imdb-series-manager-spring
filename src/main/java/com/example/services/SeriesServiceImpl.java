package com.example.services;

import com.example.model.entities.Series;
import com.example.model.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {

    // Repositories
    private final SeriesRepository seriesRep;

    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRep) {
        this.seriesRep = seriesRep;
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
}