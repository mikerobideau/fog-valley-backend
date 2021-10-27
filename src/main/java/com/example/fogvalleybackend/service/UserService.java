package com.example.fogvalleybackend.service;

import com.example.fogvalleybackend.model.entity.User;
import com.example.fogvalleybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }
}
