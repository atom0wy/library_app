package pl.sda.library_app.exceptions;

public final class EmailAlreadyExistsException extends BusinessServiceException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }

    public EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
