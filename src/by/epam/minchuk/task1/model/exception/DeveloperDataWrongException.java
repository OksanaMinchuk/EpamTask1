package by.epam.minchuk.task1.model.exception;

public class DeveloperDataWrongException extends ITCompanyLogicalException {

    public DeveloperDataWrongException() {
    }

    public DeveloperDataWrongException(String message) {
        super(message);
    }

    public DeveloperDataWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeveloperDataWrongException(Throwable cause) {
        super(cause);
    }

    public DeveloperDataWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
