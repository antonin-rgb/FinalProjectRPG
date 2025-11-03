package com.antoninrgb.finalprojectrpg.service;
import com.antoninrgb.finalprojectrpg.model.Inventory;
import com.antoninrgb.finalprojectrpg.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService (InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> findAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

}
