package by.epam.minchuk.task1.model.exception;

public class EngineerDataWrongException extends ITCompanyLogicalException {

    public EngineerDataWrongException() {
        super();
    }

    public EngineerDataWrongException(String message) {
        super(message);
    }

    public EngineerDataWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public EngineerDataWrongException(Throwable cause) {
        super(cause);
    }

    public EngineerDataWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
