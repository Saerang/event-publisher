package com.example.eventtest1.repository;

import com.example.eventtest1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
