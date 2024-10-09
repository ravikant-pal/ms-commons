package com.triton.mscommons.exceptions;

import com.triton.mscommons.exceptions.enums.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccessException extends RuntimeException {

    private UnauthorizedAccessException(ErrorMessage errorMessage, Object... variables) {
        super(String.format(errorMessage.getMessage(), variables));
    }

    public static UnauthorizedAccessException build(Object... cause) {
        return new UnauthorizedAccessException(ErrorMessage.UNAUTHORIZED_ACCESS,cause);
    }
}
