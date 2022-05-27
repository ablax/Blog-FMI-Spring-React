package me.ablax.mynotes.errors;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public abstract class CustomException extends RuntimeException {

    abstract int getStatusCode();
}
