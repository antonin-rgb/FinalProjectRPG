package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Dominion;
import com.antoninrgb.finalprojectrpg.repository.DominionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DominionService {

    private final DominionRepository dominionRepository;

    public DominionService(DominionRepository dominionRepository) {
        this.dominionRepository = dominionRepository;
    }

    public List<Dominion> findAllDominions() {
        return dominionRepository.findAll();
    }

    public Dominion save(Dominion dominion) {
        return dominionRepository.save(dominion);
    }

    public Dominion findByName(String name) {
        return dominionRepository.findByName(name);
    }


    public Dominion findById(int id) {
        return dominionRepository.findById(id);
    }
}
