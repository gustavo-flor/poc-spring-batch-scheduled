package com.github.gustavoflor.pocscheduler.batch.jobs;

import com.github.gustavoflor.pocscheduler.core.entity.ScheduledNotification;
import com.github.gustavoflor.pocscheduler.core.service.NotificationService;
import com.github.gustavoflor.pocscheduler.core.service.ScheduledNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.lang.Thread.currentThread;
import static java.time.LocalDateTime.now;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotifyScheduledNotificationJob {
    private final ScheduledNotificationService scheduledNotificationService;
    private final NotificationService notificationService;

    @Scheduled(fixedDelay = 5000)
    public void run() {
        log.info("Starting NotifyJob.run at {} on {}", now(), currentThread().getName());
        scheduledNotificationService.findAllToSend().parallelStream().forEach(this::process);
        log.info("Finishing NotifyJon.run at {} on {}", now(), currentThread().getName());
    }

    private void process(final ScheduledNotification scheduledNotification) {
        log.info("Reading scheduled notification (id: {}) on {}", scheduledNotification.getId(), currentThread().getName());
        notificationService.sendMail(scheduledNotification.getEmail(), scheduledNotification.getSendAt());
        notificationService.sendPush(scheduledNotification.getPush(), scheduledNotification.getSendAt());
        scheduledNotificationService.deleteById(scheduledNotification.getId().toHexString());
        log.info("Scheduled notification sent (id: {}) on {}", scheduledNotification.getId(), currentThread().getName());
    }
}
