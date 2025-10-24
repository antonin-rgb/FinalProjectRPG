package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.ScrollRepo;
import org.springframework.stereotype.Service;

@Service
public class ScrollService {

    private final ScrollRepo scrollRepo;

    public ScrollService(ScrollRepo scrollRepo) {
        this.scrollRepo = scrollRepo;
    }
}
