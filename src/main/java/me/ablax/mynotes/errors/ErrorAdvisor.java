package me.ablax.mynotes.errors;

import me.ablax.mynotes.model.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
@RestControllerAdvice
public class ErrorAdvisor {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionModel> handleCustomException(final CustomException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(new ExceptionModel(ex.getMessage()));
    }

    @ExceptionHandler({NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionModel> handleNotFound() {
        return ResponseEntity.status(404).body(new ExceptionModel("Not found"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionModel> handleConstraintViolationException(final MethodArgumentNotValidException ex) {
        final FieldError fieldError = ex.getBindingResult().getFieldError();
        final String field = fieldError.getField();
        final String defaultMessage = fieldError.getDefaultMessage();

        return new ResponseEntity<>(new ExceptionModel(field + " " + defaultMessage), HttpStatus.BAD_REQUEST);
    }
}
