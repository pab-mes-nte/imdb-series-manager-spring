package com.example.controller;

import com.example.model.repositories.*;
import com.example.model.entities.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeriesControllerTest {

    @Autowired
    private SeriesController seriesController;

    @Autowired
    private SeriesRepository seriesRepository;

    @Test
    void load() {
        assertThat(seriesController).isNotNull();
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getseriesListTest() {
        // Assert that the request...
        String ret = this.restTemplate.getForObject("http://localhost:" + port + "/api/series/list", String.class);

        // ... contains the whole Fallout series thingy
        assertThat(ret).contains("{\"id\":1,\"name\":\"Fallout\",\"rated\":\"TV-MA\",\"released\":\"2024-04-10\",\"plot\":\"In a future, post-apocalyptic Los Angeles brought about by nuclear decimation, citizens must live in underground bunkers to protect themselves from radiation, mutants and bandits.\",\"awards\":null,\"poster\":\"https://m.media-amazon.com/images/M/MV5BN2EwNjFhMmEtZDc4YS00OTUwLTkyODEtMzViMzliZWIyMzYxXkEyXkFqcGdeQXVyMjkwOTAyMDU@._V1_SX300.jpg\",\"metascore\":null,\"imbdRating\":87,\"imdbVotes\":40394,\"totalSeasons\":1,\"actorsList\":[{\"name\":\"Ella Purnell_Test\"},{\"name\":\"Aaron Moten_Test\"},{\"name\":\"Walton Goggins_Test\"}],\"countriesList\":[{\"name\":\"United States_Test\"}],\"categoriesList\":[{\"name\":\"Action_Test\"},{\"name\":\"Adventure_Test\"},{\"name\":\"Drama_Test\"}],\"directorsList\":[],\"languagesList\":[{\"name\":\"English_Test\"}],\"writersList\":[{\"name\":\"Geneva Robertson-Dworet_Test\"},{\"name\":\"Graham Wagner_Test\"}]}");

        // ... contains every other series (id + name)
        for (long i = 2; i <= seriesRepository.count(); i++) {
            assertThat(ret).contains("\"id\":" + i + ",\"name\":\"" + seriesRepository.findById(i).get().getName());
        }
    }

    @Test
    void getSeriesByIdTest() {
        // Assert that every series is returned correctly
        for (long i = 1; i <= seriesRepository.count(); i++) {
            assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/series/by-id?id=" + i, String.class))
                    .contains("\"id\":" + i + ",\"name\":\"" + seriesRepository.findById(i).get().getName());
        }
    }

    @Test
    void getRatingsOfTest() {

    }

    @Test
    void getSeriesLikeTest() {

    }

    @Test
    void newSeriesTest() {

    }

    @Test
    void updtSeriesTest() {

    }
}