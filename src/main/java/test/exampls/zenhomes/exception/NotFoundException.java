package test.exampls.zenhomes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("The entity you are looking for does not exist");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
