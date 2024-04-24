package com.prabhu.notificationservice.controller;

import com.prabhu.notificationservice.entity.Notification;
import com.prabhu.notificationservice.exception.NotificationNotFoundException;
import com.prabhu.notificationservice.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<Notification> sendOrderNotification(@RequestParam Long orderId) {
        log.info("Sending notification for order with id: {}", orderId);
        Notification notification = notificationService.sendOrderNotification(orderId);
        return ResponseEntity.status(HttpStatus.CREATED).body(notification);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        log.info("Fetching all notifications");
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) throws NotificationNotFoundException {
        log.info("Fetching notification with id: {}", id);
        Notification notification = notificationService.getNotificationById(id);
        return ResponseEntity.ok(notification);
    }

    @PutMapping("/{id}/markAsSent")
    public ResponseEntity<Void> markNotificationAsSent(@PathVariable Long id) throws NotificationNotFoundException {
        log.info("Marking notification with id: {} as sent", id);
        notificationService.markNotificationAsSent(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) throws NotificationNotFoundException {
        log.info("Deleting notification with id: {}", id);
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
