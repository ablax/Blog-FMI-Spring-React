package me.ablax.mynotes.model.model;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public class TokenResponse {

    private String token;
    private String id;

    public TokenResponse() {
    }

    public TokenResponse(final String token, final String id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}
