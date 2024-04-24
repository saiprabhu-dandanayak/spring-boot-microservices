package com.prabhu.notificationservice.service.impl;

import com.prabhu.notificationservice.entity.Notification;
import com.prabhu.notificationservice.exception.NotificationNotFoundException;
import com.prabhu.notificationservice.mapper.NotificationMapper;
import com.prabhu.notificationservice.repository.NotificationRepository;
import com.prabhu.notificationservice.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Notification sendOrderNotification(Long orderId) {
        log.info("Sending notification for order with id: {}", orderId);
        Notification notification = new Notification();
        notification.setMessage("Your order with ID " + orderId + " has been placed successfully.");
        notification.setRecipient("user@example.com");
        notification.setSent(true);
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        log.info("Fetching all notifications");
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) throws NotificationNotFoundException {
        log.info("Fetching notification with id: {}", id);
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found with id: " + id));
    }

    @Override
    public void markNotificationAsSent(Long id) throws NotificationNotFoundException {
        log.info("Marking notification with id: {} as sent", id);
        Notification notification = getNotificationById(id);
        notification.setSent(true);
        notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Long id) throws NotificationNotFoundException {
        log.info("Deleting notification with id: {}", id);
        if (!notificationRepository.existsById(id)) {
            throw new NotificationNotFoundException("Notification not found with id: " + id);
        }
        notificationRepository.deleteById(id);
    }
}
