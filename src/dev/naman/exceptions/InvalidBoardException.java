package dev.naman.exceptions;

public class InvalidBoardException extends RuntimeException {

    public InvalidBoardException() {}

    public InvalidBoardException(String errorMessage) {
        super(errorMessage);
    }
}
