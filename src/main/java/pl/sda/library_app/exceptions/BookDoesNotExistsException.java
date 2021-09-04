package pl.sda.library_app.exceptions;

public final class BookDoesNotExistsException extends BusinessServiceException {

    public BookDoesNotExistsException(String message) {
        super(message);
    }

    public BookDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
