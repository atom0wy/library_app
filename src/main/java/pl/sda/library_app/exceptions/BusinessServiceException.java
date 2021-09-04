package pl.sda.library_app.exceptions;

public abstract class BusinessServiceException extends RuntimeException {

    public BusinessServiceException(String message) {
        super(message);
    }

    public BusinessServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
