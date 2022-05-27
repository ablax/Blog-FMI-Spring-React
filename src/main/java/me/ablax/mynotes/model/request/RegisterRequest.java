package me.ablax.mynotes.model.request;

import me.ablax.mynotes.model.request.Credentials;

import javax.validation.constraints.NotNull;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public class RegisterRequest extends Credentials {

    @NotNull
    private String repeatPassword;

    public RegisterRequest() {
    }

    public RegisterRequest(final String email, final String password, final String repeatPassword) {
        super(email, password);
        this.repeatPassword = repeatPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(final String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
