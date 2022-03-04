package com.github.gustavoflor.pocscheduler.core.service;

import com.github.gustavoflor.pocscheduler.core.dto.MailPayload;
import com.github.gustavoflor.pocscheduler.core.dto.PushPayload;
import com.github.gustavoflor.pocscheduler.core.entity.Notification;
import com.github.gustavoflor.pocscheduler.core.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final StreamBridge streamBridge;
    private final NotificationRepository notificationRepository;

    public void sendMail(final MailPayload payload, final LocalDateTime scheduledTo) {
        streamBridge.send("sendMail-out-0", payload);
        notificationRepository.save(Notification.mail(payload, scheduledTo));
    }

    public void sendPush(final PushPayload payload, final LocalDateTime scheduledTo) {
        streamBridge.send("sendPush-out-0", payload);
        notificationRepository.save(Notification.push(payload, scheduledTo));
    }
}
