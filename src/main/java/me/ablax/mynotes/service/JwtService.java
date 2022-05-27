package me.ablax.mynotes.service;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public interface JwtService {
    String sign(String id, Integer hours);

    String getIdFromToken(String token);
}
