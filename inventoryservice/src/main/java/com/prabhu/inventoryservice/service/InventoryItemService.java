package com.prabhu.inventoryservice.service;

import com.prabhu.inventoryservice.entity.InventoryItem;
import com.prabhu.inventoryservice.exception.InventoryNotFoundException;

import java.util.List;

public interface InventoryItemService {

    InventoryItem createInventoryItem(InventoryItem inventoryItem);

    InventoryItem getInventoryItemById(Long id) throws InventoryNotFoundException;

    List<InventoryItem> getAllInventoryItems();

    InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem) throws InventoryNotFoundException;

    void deleteInventoryItem(Long id) throws InventoryNotFoundException;
}
