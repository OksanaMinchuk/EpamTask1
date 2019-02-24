package by.epam.minchuk.task1.exception;

public class MyIncorrectDataException extends Exception {
    public MyIncorrectDataException() {
    }

    public MyIncorrectDataException(String message) {
        super(message);
    }

    public MyIncorrectDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyIncorrectDataException(Throwable cause) {
        super(cause);
    }

    public MyIncorrectDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
