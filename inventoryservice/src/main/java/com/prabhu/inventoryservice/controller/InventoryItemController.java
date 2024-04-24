package com.prabhu.inventoryservice.controller;

import com.prabhu.inventoryservice.entity.InventoryItem;
import com.prabhu.inventoryservice.exception.InventoryNotFoundException;
import com.prabhu.inventoryservice.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryItemController {

    private final InventoryItemService inventoryItemService;

    @Autowired
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @PostMapping
    public ResponseEntity<InventoryItem> createInventoryItem(@RequestBody InventoryItem inventoryItem) {
        InventoryItem createdInventoryItem = inventoryItemService.createInventoryItem(inventoryItem);
        return new ResponseEntity<>(createdInventoryItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> getInventoryItemById(@PathVariable("id") Long id) throws InventoryNotFoundException {
        InventoryItem inventoryItem = inventoryItemService.getInventoryItemById(id);
        return ResponseEntity.ok(inventoryItem);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
        List<InventoryItem> inventoryItems = inventoryItemService.getAllInventoryItems();
        return ResponseEntity.ok(inventoryItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable("id") Long id, @RequestBody InventoryItem inventoryItem) throws InventoryNotFoundException {
        InventoryItem updatedInventoryItem = inventoryItemService.updateInventoryItem(id, inventoryItem);
        return ResponseEntity.ok(updatedInventoryItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryItem(@PathVariable("id") Long id) throws InventoryNotFoundException {
        inventoryItemService.deleteInventoryItem(id);
        return ResponseEntity.noContent().build();
    }
}
