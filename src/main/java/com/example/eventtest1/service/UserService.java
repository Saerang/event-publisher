package com.example.eventtest1.service;

import com.example.eventtest1.domain.User;
import com.example.eventtest1.domain.UserCreatedEvent;
import com.example.eventtest1.repository.UserRepository;
import java.beans.Transient;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void create(String username) {
        // 유저 등록
        User user = new User(username);

        User savedUser = userRepository.save(user); // 롤백

        UserCreatedEvent event = new UserCreatedEvent(savedUser);

        eventPublisher.publishEvent(event);

        // 로직

        // 에러 발생
    }


}
