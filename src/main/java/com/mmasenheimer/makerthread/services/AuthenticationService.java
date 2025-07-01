package com.mmasenheimer.makerthread.services;


import org.springframework.security.core.userdetails.UserDetails;


public interface AuthenticationService {

    UserDetails authenticate(String email, String password);
    // Authenticates the user with email and password and returns the user details

    String generateToken(UserDetails userDetails);
    // Turns the user details into a jwt

    UserDetails validateToken(String token);
    // Turns the jwt into the user details

}
