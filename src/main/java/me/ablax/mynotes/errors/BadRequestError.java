package me.ablax.mynotes.errors;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */

public class BadRequestError extends CustomException {
    private static final int STATUS_CODE = 400;

    private final String message;

    public BadRequestError(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    int getStatusCode() {
        return STATUS_CODE;
    }
}
