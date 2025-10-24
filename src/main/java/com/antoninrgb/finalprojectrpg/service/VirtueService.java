package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Virtue;
import com.antoninrgb.finalprojectrpg.repository.VirtueRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VirtueService {

    private final VirtueRepo virtueRepo;

    public VirtueService(VirtueRepo virtueRepo) {
        this.virtueRepo = virtueRepo;
    }

    public List<Virtue> findAllVirtues() {
        return virtueRepo.findAll();
    }

    public Virtue save(Virtue virtue) {
        return virtueRepo.save(virtue);
    }
}
