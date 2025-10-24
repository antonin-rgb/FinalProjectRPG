package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.DominionRepo;
import org.springframework.stereotype.Service;

@Service
public class DominionService {

    private final DominionRepo dominionRepo;

    public DominionService(DominionRepo dominionRepo) {
        this.dominionRepo = dominionRepo;
    }
}
