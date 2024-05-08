package com.example.services;

import com.example.model.entities.Rating;
import com.example.model.entities.Series;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SeriesService {

    List<Series> getSeries();

    Series getSerieById(Long id);

    List<Series> getSeriesLikeName(String name);

    List<Rating> getRatingsBySeriesId(Long id);

    ResponseEntity<Object> postSeries(Series series);

    ResponseEntity<Object> putSeries(Series series);
}
