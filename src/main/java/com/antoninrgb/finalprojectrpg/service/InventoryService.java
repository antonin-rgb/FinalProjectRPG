package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.repository.InventoryRepo;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepo inventoryRepo;

    public InventoryService (InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }
}
