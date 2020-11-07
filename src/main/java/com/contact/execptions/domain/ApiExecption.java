package com.contact.execptions.domain;

public class ApiExecption extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ApiExecption(String message) {
        super(message);
    }
}
