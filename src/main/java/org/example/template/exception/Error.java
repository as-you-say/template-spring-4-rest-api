package org.example.template.exception;

import lombok.Getter;

@Getter
public enum Error {

    ACCOUNT_ALREADY_EXIST(100, "Account aleady exists"),
    ACCOUNT_IS_NOT_ADDED(101, "Account is not added"),
    ACCOUNT_IS_NOT_MODIFIED(102, "Account is not modified"),
    ACCOUNT_IS_NOT_REMOVED(103, "Account is not removed"),
    ACCOUNT_NOT_FOUND_BY_ID(110, "Account is not found by id"),
    ACCOUNT_NOT_FOUND_BY_USERNAME(111, "Account is not found by username"),
    ACCOUNT_NOT_VALID_PARAMETER(120, "Account is not valid parameter"),
    ;

    private final int code;
    private final String message;
    Error (int code, String message) {
        this.code = code;
        this.message = message;
    }
}
