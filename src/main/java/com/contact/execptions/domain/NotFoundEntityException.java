package com.contact.execptions.domain;

public class NotFoundEntityException extends ApiExecption {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NotFoundEntityException(String message) {
        super(message);
    }
}
