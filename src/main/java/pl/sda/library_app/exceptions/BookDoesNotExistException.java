package pl.sda.library_app.exceptions;

public final class BookDoesNotExistException extends BusinessServiceException {

    public BookDoesNotExistException(String message) {
        super(message);
    }

    public BookDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
