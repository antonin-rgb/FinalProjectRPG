package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Scroll;
import com.antoninrgb.finalprojectrpg.repository.ScrollRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScrollService {

    private final ScrollRepository scrollRepository;

    public ScrollService(ScrollRepository scrollRepository) {
        this.scrollRepository = scrollRepository;
    }

    public List<Scroll> findAllScrolls() {
        return scrollRepository.findAll();
    }

    public Scroll save(Scroll scroll) {
        return scrollRepository.save(scroll);
    }
}
