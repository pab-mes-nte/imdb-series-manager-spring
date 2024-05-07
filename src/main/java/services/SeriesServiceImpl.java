package services;

import model.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriesServiceImpl implements SeriesService {

    // Repositories
    private final SeriesRepository seriesRep;

    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRep) {
        this.seriesRep = seriesRep;
    }

    @Override
    public String getSeries() {
        return "";
    }
}