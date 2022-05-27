package me.ablax.mynotes.controller;

import me.ablax.mynotes.model.request.LoginRequest;
import me.ablax.mynotes.model.request.RegisterRequest;
import me.ablax.mynotes.model.model.TokenResponse;
import me.ablax.mynotes.service.JwtService;
import me.ablax.mynotes.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signup(@Valid @RequestBody final RegisterRequest registerRequest) {
        final String id = userService.registerUser(registerRequest);

        return ResponseEntity.ok(new TokenResponse(jwtService.sign(id, 24), id));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody final LoginRequest loginRequest) {
        final String id = userService.login(loginRequest);

        return ResponseEntity.ok(new TokenResponse(jwtService.sign(id, 24), id));
    }

}
