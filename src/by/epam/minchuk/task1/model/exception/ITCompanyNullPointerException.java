package by.epam.minchuk.task1.model.exception;

public class ITCompanyNullPointerException extends ITCompanyTechnicalException {

    public ITCompanyNullPointerException() {
    }

    public ITCompanyNullPointerException(String message) {
        super(message);
    }

    public ITCompanyNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITCompanyNullPointerException(Throwable cause) {
        super(cause);
    }

    public ITCompanyNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
