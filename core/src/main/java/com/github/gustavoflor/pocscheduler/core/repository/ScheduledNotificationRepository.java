package com.github.gustavoflor.pocscheduler.core.repository;

import com.github.gustavoflor.pocscheduler.core.entity.ScheduledNotification;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduledNotificationRepository extends MongoRepository<ScheduledNotification, ObjectId> {
    List<ScheduledNotification> findAllBySendAtBefore(final LocalDateTime sentAtBefore);
}
