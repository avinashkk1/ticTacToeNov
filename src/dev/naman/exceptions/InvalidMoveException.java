package dev.naman.exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException() {}

    public InvalidMoveException(String errorMessage) {
        super(errorMessage);
    }
}
