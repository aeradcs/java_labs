package Factory;

public class StackCalculatorException extends Exception {
    public StackCalculatorException() {
    }

    public StackCalculatorException(String message) {
        super(message);
    }

    public StackCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public StackCalculatorException(Throwable cause) {
        super(cause);
    }

    public StackCalculatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
