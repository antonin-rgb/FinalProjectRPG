package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Scroll;
import com.antoninrgb.finalprojectrpg.repository.ScrollRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScrollService {

    private final ScrollRepo scrollRepo;

    public ScrollService(ScrollRepo scrollRepo) {
        this.scrollRepo = scrollRepo;
    }

    public List<Scroll> findAllScrolls() {
        return scrollRepo.findAll();
    }

    public Scroll save(Scroll scroll) {
        return scrollRepo.save(scroll);
    }
}
