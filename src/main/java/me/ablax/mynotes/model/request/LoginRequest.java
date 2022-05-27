package me.ablax.mynotes.model.request;

import me.ablax.mynotes.model.request.Credentials;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public class LoginRequest extends Credentials {

    public LoginRequest() {
    }

    public LoginRequest(final String email, final String password) {
        super(email, password);
    }

}
