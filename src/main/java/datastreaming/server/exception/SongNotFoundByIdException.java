package datastreaming.server.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SongNotFoundByIdException extends NotFoundByIdException {

    public SongNotFoundByIdException() {
        super();
    }

    public SongNotFoundByIdException(Long id) {
        super(id);
    }

    public SongNotFoundByIdException(String message, Long id) {
        super(message, id);
    }

    public SongNotFoundByIdException(String message) {
        super(message);
    }

    @Override
    public ExceptionMessageAndId getExceptionMessageAndId() {
        return super.getExceptionMessageAndId();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
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
