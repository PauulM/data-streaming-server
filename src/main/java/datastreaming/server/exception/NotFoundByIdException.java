package datastreaming.server.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class NotFoundByIdException extends Exception {

    public class ExceptionMessageAndId {

        private Long id;
        private String message;

        public ExceptionMessageAndId(Long id, String message) {
            this.id = id;
            this.message = message;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private static final long serialVersionUID = -3762813200832659187L;
    private Long id;

    public NotFoundByIdException() {
        super();
    }

    public NotFoundByIdException(Long id) {
        super();
        this.id = id;
    }

    public NotFoundByIdException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public NotFoundByIdException(String message) {
        super(message);
    }

    public ExceptionMessageAndId getExceptionMessageAndId(){
        return new ExceptionMessageAndId(id, getMessage());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace);
    }
}
