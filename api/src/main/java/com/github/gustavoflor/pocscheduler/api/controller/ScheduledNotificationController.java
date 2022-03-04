package com.github.gustavoflor.pocscheduler.api.controller;

import com.github.gustavoflor.pocscheduler.api.dto.SendAtPayload;
import com.github.gustavoflor.pocscheduler.core.entity.ScheduledNotification;
import com.github.gustavoflor.pocscheduler.core.service.ScheduledNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/scheduled-notifications")
@RequiredArgsConstructor
public class ScheduledNotificationController {
    private final ScheduledNotificationService scheduledNotificationService;

    @PostMapping("/seed")
    public void seed(@Positive @RequestParam(required = false, defaultValue = "1") Integer amount, @Valid @RequestBody final SendAtPayload payload) {
        scheduledNotificationService.seed(amount, payload.getSendAt());
    }

    @GetMapping
    public Page<ScheduledNotification> findAll(@PositiveOrZero @RequestParam(required = false, defaultValue = "0") Integer page) {
        return scheduledNotificationService.findAllToSend(PageRequest.of(page, 8));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final String id) {
        scheduledNotificationService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        scheduledNotificationService.deleteAll();
    }
}
