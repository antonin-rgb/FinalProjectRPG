package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Dominion;
import com.antoninrgb.finalprojectrpg.repository.DominionRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DominionService {

    private final DominionRepo dominionRepo;

    public DominionService(DominionRepo dominionRepo) {
        this.dominionRepo = dominionRepo;
    }

    public List<Dominion> findAllDominions() {
        return dominionRepo.findAll();
    }

    public Dominion save(Dominion dominion) {
        return dominionRepo.save(dominion);
    }

}
