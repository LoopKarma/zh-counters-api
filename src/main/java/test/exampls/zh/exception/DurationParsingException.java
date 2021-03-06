package test.exampls.zh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DurationParsingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DurationParsingException(String message) {
        super(message);
    }
}
