package com.prabhu.inventoryservice.repository;

import com.prabhu.inventoryservice.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    InventoryItem findByProductId(String productId);
}
