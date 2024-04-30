package services;

import model.repositories.SeriesRepository;
import org.springframework.stereotype.Service;

@Service
public class SeriesServiceImpl implements SeriesService {
    // Repositories
    final SeriesRepository seriesRep;

    public SeriesServiceImpl(SeriesRepository seriesRep) {
        this.seriesRep = seriesRep;
    }

    @Override
    public String getSeries() {
        return "";
    }
}
