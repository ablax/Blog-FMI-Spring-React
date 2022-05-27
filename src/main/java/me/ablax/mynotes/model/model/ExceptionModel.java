package me.ablax.mynotes.model.model;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public class ExceptionModel {

    private String message;

    public ExceptionModel() {
    }

    public ExceptionModel(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
