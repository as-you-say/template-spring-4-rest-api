package org.example.template.exception;

import org.example.template.exception.account.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    // Account Exception
    @ExceptionHandler(AccountAlreadyExistException.class)
    public ExceptionResponse accountAlreadyExistException() { return new ExceptionResponse(Error.ACCOUNT_ALREADY_EXIST); }
    @ExceptionHandler(AccountIsNotAddedException.class)
    public ExceptionResponse accountIsNotAddedException() {
        return new ExceptionResponse(Error.ACCOUNT_IS_NOT_ADDED);
    }
    @ExceptionHandler(AccountIsNotModifiedException.class)
    public ExceptionResponse accountIsNotModifiedException() { return new ExceptionResponse(Error.ACCOUNT_IS_NOT_MODIFIED); }
    @ExceptionHandler(AccountIsNotRemovedException.class)
    public ExceptionResponse accountIsNotRemovedException() { return new ExceptionResponse(Error.ACCOUNT_IS_NOT_REMOVED); }
    @ExceptionHandler(AccountNotFoundByIdException.class)
    public ExceptionResponse accountNotFoundByIdException() { return new ExceptionResponse(Error.ACCOUNT_NOT_FOUND_BY_ID); }
    @ExceptionHandler(AccountNotFoundByUsernameException.class)
    public ExceptionResponse accountNotFoundByUsernameException() { return new ExceptionResponse(Error.ACCOUNT_NOT_FOUND_BY_USERNAME); }
    @ExceptionHandler(AccountNotValidParameterException.class)
    public ExceptionResponse accountNotValidParameterException() { return new ExceptionResponse(Error.ACCOUNT_NOT_VALID_PARAMETER); }

    // AccountRole Exception
    // Board Exception
    // Role Exception


}
