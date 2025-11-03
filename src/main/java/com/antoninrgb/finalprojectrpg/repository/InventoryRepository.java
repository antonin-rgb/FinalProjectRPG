package com.antoninrgb.finalprojectrpg.repository;

import com.antoninrgb.finalprojectrpg.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
