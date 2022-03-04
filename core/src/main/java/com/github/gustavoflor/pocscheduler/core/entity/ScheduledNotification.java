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
import java.util.Random;

@Document("scheduled_notifications")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledNotification {
    @MongoId
    private ObjectId id;

    private MailPayload email;
    private PushPayload push;
    private LocalDateTime sendAt;

    public static ScheduledNotification mock(final LocalDateTime sendAt) {
        return ScheduledNotification.builder()
            .email(MailPayload.mock())
            .push(PushPayload.mock())
            .sendAt(sendAt)
            .build();
    }
}
