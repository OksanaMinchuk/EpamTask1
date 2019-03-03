package by.epam.minchuk.task1.model.exception;

public class FinderNullPointerException extends ITCompanyTechnicalException {

    public FinderNullPointerException() {
    }

    public FinderNullPointerException(String message) {
        super(message);
    }

    public FinderNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FinderNullPointerException(Throwable cause) {
        super(cause);
    }

    public FinderNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
