package com.example.eventtest1.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CouponService {


    @EventListener(UserCreatedEvent.class)
    public void createCoupon(UserCreatedEvent event) {
        System.out.println(event);
        // 쿠폰 발행 잘되었냐
    }
}
