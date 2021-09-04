package pl.sda.library_app.exceptions;

public final class BookAlreadyExistsException extends BusinessServiceException {

    public BookAlreadyExistsException(String message) {
        super(message);
    }

    public BookAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
