package com.github.gustavoflor.pocscheduler.core.entity;

import com.github.gustavoflor.pocscheduler.core.dto.MailPayload;
import com.github.gustavoflor.pocscheduler.core.dto.PushPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Document("notifications")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @MongoId
    private ObjectId id;

    private Object content;
    private Type type;
    private LocalDateTime scheduledTo;
    private LocalDateTime sentAt;

    enum Type {
        MAIL, PUSH
    }

    public static Notification mail(final MailPayload payload, final LocalDateTime scheduledTo) {
        final Notification notification = new Notification();
        notification.setContent(payload);
        notification.setSentAt(now());
        notification.setType(Type.MAIL);
        notification.setScheduledTo(scheduledTo);
        return notification;
    }

    public static Notification push(final PushPayload payload, final LocalDateTime scheduledTo) {
        final Notification notification = new Notification();
        notification.setContent(payload);
        notification.setSentAt(now());
        notification.setType(Type.PUSH);
        notification.setScheduledTo(scheduledTo);
        return notification;
    }
}
