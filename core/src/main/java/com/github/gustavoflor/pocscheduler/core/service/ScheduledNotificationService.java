package com.github.gustavoflor.pocscheduler.core.service;

import com.github.gustavoflor.pocscheduler.core.entity.ScheduledNotification;
import com.github.gustavoflor.pocscheduler.core.repository.ScheduledNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledNotificationService {
    private final ScheduledNotificationRepository scheduledNotificationRepository;

    public List<ScheduledNotification> findAllToSend() {
        return scheduledNotificationRepository.findAllBySendAtBefore(LocalDateTime.now());
    }

    public Page<ScheduledNotification> findAllToSend(final Pageable pageable) {
        return scheduledNotificationRepository.findAll(pageable);
    }

    public void deleteById(final String id) {
        scheduledNotificationRepository.deleteById(new ObjectId(id));
    }

    public void seed(final Integer amount, final LocalDateTime sendAt) {
        List<ScheduledNotification> scheduledNotifications = new ArrayList<>();
        for (int index = 0; index < amount; index++) {
            scheduledNotifications.add(ScheduledNotification.mock(sendAt));
        }
        scheduledNotificationRepository.saveAll(scheduledNotifications);
    }

    public void deleteAll() {
        scheduledNotificationRepository.deleteAll();
    }
}
