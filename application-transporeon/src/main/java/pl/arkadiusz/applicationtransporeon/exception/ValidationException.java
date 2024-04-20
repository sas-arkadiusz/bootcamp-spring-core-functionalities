package pl.arkadiusz.applicationtransporeon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class ValidationException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
        public Error handleSdaException(final MethodArgumentNotValidException exception) {

            StringBuilder sb = new StringBuilder();
            final var errors = exception.getBindingResult().getFieldErrors();
            for (FieldError fieldError : errors) {
                sb.append(fieldError.getDefaultMessage() + ". ");
            }

        return new Error("XXX: " + sb.toString());
    }
}
