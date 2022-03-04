package com.github.gustavoflor.pocscheduler.core.repository;

import com.github.gustavoflor.pocscheduler.core.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
}
