package com.example.eventtest1.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class EmailService {

    @TransactionalEventListener(UserCreatedEvent.class)
    public void createCoupon(UserCreatedEvent event) {
        event.getUser().getUserId();
    }
}
