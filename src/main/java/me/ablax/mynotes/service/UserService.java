package me.ablax.mynotes.service;


import me.ablax.mynotes.model.request.LoginRequest;
import me.ablax.mynotes.model.request.RegisterRequest;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public interface UserService {
    String login(LoginRequest loginRequest);

    String registerUser(RegisterRequest registerRequest);
}
