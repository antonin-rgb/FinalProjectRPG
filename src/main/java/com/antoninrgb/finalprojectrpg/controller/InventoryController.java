package com.antoninrgb.finalprojectrpg.controller;
import com.antoninrgb.finalprojectrpg.model.Inventory;
import com.antoninrgb.finalprojectrpg.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getAll() {
        return inventoryService.findAllInventories();
    }

    @PostMapping("/create")
    public Inventory create(@RequestBody Inventory inventory) {
        return inventoryService.save(inventory);
    }

}
