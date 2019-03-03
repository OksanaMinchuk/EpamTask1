package by.epam.minchuk.task1.model.exception;

public class TeamNullPointerException extends ITCompanyTechnicalException {

    public TeamNullPointerException() {
    }

    public TeamNullPointerException(String message) {
        super(message);
    }

    public TeamNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamNullPointerException(Throwable cause) {
        super(cause);
    }

    public TeamNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
