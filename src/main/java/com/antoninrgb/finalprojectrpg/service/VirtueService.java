package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.VirtueRepo;
import org.springframework.stereotype.Service;

@Service
public class VirtueService {

    private final VirtueRepo virtueRepo;

    public VirtueService(VirtueRepo virtueRepo) {
        this.virtueRepo = virtueRepo;
    }
}
