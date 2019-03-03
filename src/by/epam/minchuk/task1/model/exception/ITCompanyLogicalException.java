package by.epam.minchuk.task1.model.exception;

public class ITCompanyLogicalException extends ITCompanyException {

    public ITCompanyLogicalException() {
    }

    public ITCompanyLogicalException(String message) {
        super(message);
    }

    public ITCompanyLogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITCompanyLogicalException(Throwable cause) {
        super(cause);
    }

    public ITCompanyLogicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
