package com.example.services;

import com.example.model.entities.Series;

import java.util.List;

public interface SeriesService {

    List<Series> getSeries();

    Series getSerieById(Long id);
}
