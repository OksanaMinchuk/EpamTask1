package by.epam.minchuk.task1.model.exception;

public class TesterDataWrongException extends ITCompanyLogicalException {

    public TesterDataWrongException() {
        super();
    }

    public TesterDataWrongException(String message) {
        super(message);
    }

    public TesterDataWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public TesterDataWrongException(Throwable cause) {
        super(cause);
    }

    public TesterDataWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
