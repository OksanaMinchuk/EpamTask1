package by.epam.minchuk.task1.model.exception;

public class CompanyCreatorNullPointerException extends ITCompanyTechnicalException {

    public CompanyCreatorNullPointerException() {
    }

    public CompanyCreatorNullPointerException(String message) {
        super(message);
    }

    public CompanyCreatorNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyCreatorNullPointerException(Throwable cause) {
        super(cause);
    }

    public CompanyCreatorNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
