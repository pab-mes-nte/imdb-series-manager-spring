package com.example.services;

import com.example.model.entities.Rating;
import com.example.model.entities.Series;
import com.example.model.repositories.RatingRepository;
import com.example.model.repositories.SeriesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {
    // Logger
    private static final Logger logger = LogManager.getLogger("SeriesService");

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

    @Override
    public ResponseEntity<Object> postSeries(Series series) {
        // If the name is not null and it doesn't exist
        if (series.getName() != null && seriesRep.findByName(series.getName()) == null) {
            // Removes the ID, so it doesn't update another existing series
            series.setId(null);
            seriesRep.save(series);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            logger.info("Series '{}' already exists or name is null!", series.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> putSeries(Series series) {
        if (series.getId() != null) {
            // If the series with the given ID exists in the DB
            if (seriesRep.findById(series.getId()).isPresent()) {
                // If the name is not null and it doesn't exist (except if it's the same series as the one being changed)
                if (series.getName() != null && (seriesRep.findByName(series.getName()) == null || seriesRep.findByName(series.getName()).getId().equals(series.getId()))) {
                    seriesRep.save(series);
                    return new ResponseEntity<>(HttpStatus.OK);
                } else {
                    logger.info("Series '{}' already exists or name is null!", series.getName());
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                logger.info("Series with ID={} does not exist!", series.getId());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            logger.info("Series ID is null!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}