package com.example.controller;

import com.example.model.entities.Rating;
import com.example.model.entities.Series;
import com.example.services.SeriesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SeriesController {
    // Logger
    private static final Logger logger = LogManager.getLogger("SeriesController");

    // Services
    private final SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    // http://localhost:8080/api/series/list
    // Returns all series
    @GetMapping("/series/list")
    @Produces("application/json")
    public List<Series> getSeriesList(@Context HttpServletRequest req) {
        logger.info("Sending all series to {}", req.getRemoteAddr());
        return seriesService.getSeries();
    }

    // http://localhost:8080/api/series/by-id?id=1
    // Returns the series with the given ID
    @GetMapping("/series/by-id")
    @Produces("application/json")
    public Series getSeriesById(@Context HttpServletRequest req, @RequestParam("id") Long id) {
        logger.info("Sending series to {} with ID={}", req.getRemoteAddr(), id);
        return seriesService.getSerieById(id);
    }

    // http://localhost:8080/api/series/like?name=ll
    // Returns the series containing the given name
    @GetMapping("/series/like")
    @Produces("application/json")
    public List<Series> getSeriesLike(@Context HttpServletRequest req, @RequestParam("name") String name) {
        logger.info("Sending all series to {} with name containing '{}' (case insensitive)", req.getRemoteAddr(), name);
        return seriesService.getSeriesLikeName(name);
    }

    // http://localhost:8080/api/ratings/of?id=1
    // Returns the ratings with the given series ID
    @GetMapping("/ratings/of")
    @Produces("application/json")
    public List<Rating> getRatingsOf(@Context HttpServletRequest req, @RequestParam("id") Long id) {
        logger.info("Sending all ratings to {} with series ID={}", req.getRemoteAddr(), id);
        return seriesService.getRatingsBySeriesId(id);
    }

    // http://localhost:8080/api/series/new
    // Inserts a series with the body's JSON data
    @PostMapping("/series/new")
    @Consumes("application/json")
    public ResponseEntity<Object> newSeries(@Context HttpServletRequest req, @RequestBody Series series) {
        logger.info("Insert request of series '{}' from {}", series.getName(), req.getRemoteAddr());
        return seriesService.postSeries(series);
    }

    // http://localhost:8080/api/series/updt
    // Updates a series with the body's JSON data
    @PutMapping("/series/updt")
    @Consumes("application/json")
    public ResponseEntity<Object> updtSeries(@Context HttpServletRequest req, @RequestBody Series series) {
        logger.info("Update request of series with ID={} from {}", series.getId(), req.getRemoteAddr());
        return seriesService.putSeries(series);
    }
}