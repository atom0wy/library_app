package pl.sda.library_app.exceptions;

public class UserDoesNotExistException extends BusinessServiceException {

    public UserDoesNotExistException(String message) {
        super(message);
    }

    public UserDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
