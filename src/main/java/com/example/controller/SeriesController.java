package com.example.controller;

import com.example.model.entities.Series;
import com.example.services.SeriesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Returns all series
    @GetMapping("/seriesList")
    @Produces("application/json")
    public List<Series> getSeriesList(@Context HttpServletRequest req) {
        logger.info("Returning all series to {}", req.getRemoteAddr());
        return seriesService.getSeries();
    }

    // Returns the series with the given ID
    @GetMapping("/seriesById")
    @Produces("application/json")
    public Series getSeries(@Context HttpServletRequest req, @RequestParam("id") Long id) {
        logger.info("Sending series to {} with ID: {}", req.getRemoteAddr(), id);
        return seriesService.getSerieById(id);
    }

    // Returns the series with the given name
    @GetMapping("/seriesLikeName")
    @Produces("application/json")
    public List<Series> getSeriesLikeName(@Context HttpServletRequest req, @RequestParam("name") String name) {
        logger.info("Sending series to {} with name: {}", req.getRemoteAddr(), name);
        return seriesService.getSeriesLikeName(name);
    }
}