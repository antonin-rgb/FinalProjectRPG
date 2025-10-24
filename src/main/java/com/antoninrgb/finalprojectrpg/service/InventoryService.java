package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Inventory;
import com.antoninrgb.finalprojectrpg.repository.InventoryRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepo inventoryRepo;

    public InventoryService (InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public List<Inventory> findAllInventories() {
        return inventoryRepo.findAll();
    }

    public Inventory save(Inventory inventory) {
        return inventoryRepo.save(inventory);
    }

}
