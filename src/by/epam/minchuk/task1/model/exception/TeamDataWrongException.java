package by.epam.minchuk.task1.model.exception;

public class TeamDataWrongException extends ITCompanyLogicalException {

    public TeamDataWrongException() {
    }

    public TeamDataWrongException(String message) {
        super(message);
    }

    public TeamDataWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamDataWrongException(Throwable cause) {
        super(cause);
    }

    public TeamDataWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
