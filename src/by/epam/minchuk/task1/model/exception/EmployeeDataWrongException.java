package by.epam.minchuk.task1.model.exception;

public class EmployeeDataWrongException extends ITCompanyLogicalException {

    public EmployeeDataWrongException() {
        super();
    }

    public EmployeeDataWrongException(String message) {
        super(message);
    }

    public EmployeeDataWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeDataWrongException(Throwable cause) {
        super(cause);
    }

    public EmployeeDataWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
