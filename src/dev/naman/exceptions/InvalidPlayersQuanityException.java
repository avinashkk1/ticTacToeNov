package dev.naman.exceptions;

public class InvalidPlayersQuanityException extends RuntimeException {
    public InvalidPlayersQuanityException() {}

    public InvalidPlayersQuanityException(String errorMessage) {
        super(errorMessage);
    }
}
