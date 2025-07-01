package com.mmasenheimer.makerthread.services.impl;

import com.mmasenheimer.makerthread.domain.entities.User;
import com.mmasenheimer.makerthread.repositories.UserRepository;
import com.mmasenheimer.makerthread.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
}
