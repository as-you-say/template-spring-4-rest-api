package org.example.template.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {
    private int code;
    private String message;

    public ExceptionResponse(Error error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }
}
