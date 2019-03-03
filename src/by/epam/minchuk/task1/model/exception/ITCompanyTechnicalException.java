package by.epam.minchuk.task1.model.exception;

public class ITCompanyTechnicalException extends ITCompanyException {

    public ITCompanyTechnicalException() {
    }

    public ITCompanyTechnicalException(String message) {
        super(message);
    }

    public ITCompanyTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITCompanyTechnicalException(Throwable cause) {
        super(cause);
    }

    public ITCompanyTechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
