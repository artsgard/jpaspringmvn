package com.artsgard.core.utils;

public class HibException extends Exception {

    public HibException(String message) {
        super(message);
    }

    public HibException(String message, Throwable cause) {
        super(message, cause);
    }
}
