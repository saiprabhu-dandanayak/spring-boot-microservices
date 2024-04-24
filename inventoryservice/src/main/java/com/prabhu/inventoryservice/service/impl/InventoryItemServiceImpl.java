package com.prabhu.inventoryservice.service.impl;

import com.prabhu.inventoryservice.entity.InventoryItem;
import com.prabhu.inventoryservice.exception.InventoryNotFoundException;
import com.prabhu.inventoryservice.mapper.InventoryItemMapper;
import com.prabhu.inventoryservice.repository.InventoryItemRepository;
import com.prabhu.inventoryservice.service.InventoryItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
public class InventoryItemServiceImpl implements InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;
    private final InventoryItemMapper inventoryItemMapper;

    @Autowired
    public InventoryItemServiceImpl(InventoryItemRepository inventoryItemRepository, InventoryItemMapper inventoryItemMapper) {
        this.inventoryItemRepository = inventoryItemRepository;
        this.inventoryItemMapper = inventoryItemMapper;
    }

    @Override
    public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        log.info("Creating new inventory item...");
        return inventoryItemRepository.save(inventoryItem);
    }

    @Override
    public InventoryItem getInventoryItemById(Long id) throws InventoryNotFoundException {
        log.info("Fetching inventory item with id: {}", id);
        return inventoryItemRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException("Inventory item not found with id: " + id));
    }

    @Override
    public List<InventoryItem> getAllInventoryItems() {
        log.info("Fetching all inventory items...");
        return inventoryItemRepository.findAll();
    }

    @Override
    public InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem) throws InventoryNotFoundException {
        log.info("Updating inventory item with id: {}", id);
        if (!inventoryItemRepository.existsById(id)) {
            throw new InventoryNotFoundException("Inventory item not found with id: " + id);
        }
        inventoryItem.setId(id);
        return inventoryItemRepository.save(inventoryItem);
    }

    @Override
    public void deleteInventoryItem(Long id) throws InventoryNotFoundException {
        log.info("Deleting inventory item with id: {}", id);
        if (!inventoryItemRepository.existsById(id)) {
            throw new InventoryNotFoundException("Inventory item not found with id: " + id);
        }
        inventoryItemRepository.deleteById(id);
    }
}
