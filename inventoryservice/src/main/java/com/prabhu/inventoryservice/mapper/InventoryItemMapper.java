package com.prabhu.inventoryservice.mapper;

import com.prabhu.inventoryservice.dto.InventoryItemDTO;
import com.prabhu.inventoryservice.entity.InventoryItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public InventoryItemMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public InventoryItemDTO convertToDTO(InventoryItem inventoryItem) {
        return modelMapper.map(inventoryItem, InventoryItemDTO.class);
    }

    public InventoryItem convertToEntity(InventoryItemDTO inventoryItemDTO) {
        return modelMapper.map(inventoryItemDTO, InventoryItem.class);
    }
}
