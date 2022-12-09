package com.example.eventtest1.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.example.eventtest1.domain.User;
import com.example.eventtest1.domain.UserCreatedEvent;
import com.example.eventtest1.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Mock
    private UserRepository userRepository;

    @Captor
    private ArgumentCaptor<Object> argumentCaptor;


    @Test
    void eventTest() {
        String username = "test";
        User user = new User(username);

        BDDMockito.given(userRepository.save(any(User.class))).willReturn(user);
        userService.create(username);

        verify(eventPublisher, times(1)).publishEvent(argumentCaptor.capture());

        List<Object> values = argumentCaptor.getAllValues();

        UserCreatedEvent userCreatedEvent = (UserCreatedEvent) values.get(0);

        assertThat(values.get(0)).isInstanceOf(UserCreatedEvent.class);
        assertThat(userCreatedEvent.getUser()).isEqualTo(user);
    }

}
