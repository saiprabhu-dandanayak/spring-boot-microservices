package com.prabhu.notificationservice.service;

import com.prabhu.notificationservice.entity.Notification;
import com.prabhu.notificationservice.exception.NotificationNotFoundException;

import java.util.List;

public interface NotificationService {

    Notification sendOrderNotification(Long orderId);

    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id) throws NotificationNotFoundException;

    void markNotificationAsSent(Long id) throws NotificationNotFoundException;

    void deleteNotification(Long id) throws NotificationNotFoundException;
}
