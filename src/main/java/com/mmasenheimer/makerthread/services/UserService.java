package com.mmasenheimer.makerthread.services;

import com.mmasenheimer.makerthread.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
