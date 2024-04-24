package com.prabhu.notificationservice.mapper;

import com.prabhu.notificationservice.dto.NotificationDTO;
import com.prabhu.notificationservice.entity.Notification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public NotificationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NotificationDTO convertToDto(Notification notification) {
        return modelMapper.map(notification, NotificationDTO.class);
    }

    public Notification convertToEntity(NotificationDTO notificationDTO) {
        return modelMapper.map(notificationDTO, Notification.class);
    }
}
