package org.example.template.exception.board;

public class BoardNotFoundByIdException extends RuntimeException {
    public BoardNotFoundByIdException(String message) {
        super(message);
    }
}
