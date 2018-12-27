package com.prudential.datalake.reconciliation.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not find document with id.")
public class DocumentNotFoundException extends Exception
{
	private static final long serialVersionUID = -1638291826285375925L;

	public DocumentNotFoundException(String message)
    {
        super(message);
    }
}
