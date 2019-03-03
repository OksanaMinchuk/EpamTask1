package by.epam.minchuk.task1.model.exception;

public class ITCompanyDataWrongException extends ITCompanyLogicalException {

    public ITCompanyDataWrongException() {
    }

    public ITCompanyDataWrongException(String message) {
        super(message);
    }

    public ITCompanyDataWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITCompanyDataWrongException(Throwable cause) {
        super(cause);
    }

    public ITCompanyDataWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
