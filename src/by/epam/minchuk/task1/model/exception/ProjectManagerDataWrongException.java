package by.epam.minchuk.task1.model.exception;

public class ProjectManagerDataWrongException extends ITCompanyLogicalException {

    public ProjectManagerDataWrongException() {
        super();
    }

    public ProjectManagerDataWrongException(String message) {
        super(message);
    }

    public ProjectManagerDataWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectManagerDataWrongException(Throwable cause) {
        super(cause);
    }

    public ProjectManagerDataWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
