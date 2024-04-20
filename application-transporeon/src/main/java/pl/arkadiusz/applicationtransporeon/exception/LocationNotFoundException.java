package pl.arkadiusz.applicationtransporeon.exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(final String message) {
        super(message);
    }
}
