package me.ablax.mynotes.service;

import me.ablax.mynotes.entity.User;
import me.ablax.mynotes.errors.BadRequestError;
import me.ablax.mynotes.model.request.LoginRequest;
import me.ablax.mynotes.model.request.RegisterRequest;
import me.ablax.mynotes.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author Murad Hamza on 27.05.2022 г.
 */

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    public UserServiceImpl(final PasswordEncoder passwordEncoder,
                           final UsersRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public String login(final LoginRequest loginRequest) {
        this.validateLoginRequest(loginRequest);

        final Optional<User> oneByEmail = usersRepository.findOneByEmail(loginRequest.getEmail());
        if (oneByEmail.isPresent()) {
            final User user = oneByEmail.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return user.getId();
            }
        }
        throw new BadRequestError("Invalid credentials!");
    }

    @Override
    public String registerUser(final RegisterRequest registerRequest) {
        this.validateRegisterRequest(registerRequest);

        final Optional<User> oneByEmail = usersRepository.findOneByEmail(registerRequest.getEmail());
        if (oneByEmail.isPresent()) {
            throw new BadRequestError("User already exists!");
        }

        final User user = new User(registerRequest.getEmail(), registerRequest.getPassword());
        final User savedUser = usersRepository.save(user);
        return savedUser.getId();
    }

    private void validateLoginRequest(final LoginRequest loginRequest) {
        loginRequest.setEmail(loginRequest.getEmail().toLowerCase());
    }

    private void validateRegisterRequest(final RegisterRequest registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getRepeatPassword())) {
            throw new BadRequestError("Passwords do not match!");
        }

        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        registerRequest.setEmail(registerRequest.getEmail().toLowerCase());
    }

}
