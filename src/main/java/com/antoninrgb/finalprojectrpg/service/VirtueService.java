package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Path;
import com.antoninrgb.finalprojectrpg.model.Virtue;
import com.antoninrgb.finalprojectrpg.repository.VirtueRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VirtueService {

    private final VirtueRepository virtueRepository;

    public VirtueService(VirtueRepository virtueRepository) {
        this.virtueRepository = virtueRepository;
    }

    public List<Virtue> findAllVirtues() {
        return virtueRepository.findAll();
    }

    public Virtue save(Virtue virtue) {
        return virtueRepository.save(virtue);
    }

    public Virtue findByName(String name) {
        return virtueRepository.findByName(name);
    }

    public Virtue findById(int id) {
        return virtueRepository.findById(id);
    }

}
