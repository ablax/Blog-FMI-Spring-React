package me.ablax.mynotes.model.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public class Credentials {
    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 4, max = 12)
    private String password;

    public Credentials() {
    }

    public Credentials(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
