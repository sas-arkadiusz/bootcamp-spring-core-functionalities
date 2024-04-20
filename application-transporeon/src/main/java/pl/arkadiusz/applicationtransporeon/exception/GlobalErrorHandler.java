package pl.arkadiusz.applicationtransporeon.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LocationNotFoundException.class)
    public Error handleSdaException(final LocationNotFoundException exception) {
        log.debug("something bad has happened...");
        return new Error("XXX: " + exception.getMessage());
    }
}
