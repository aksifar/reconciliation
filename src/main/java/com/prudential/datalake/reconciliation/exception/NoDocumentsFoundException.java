package com.prudential.datalake.reconciliation.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No Document(s) found")
public class NoDocumentsFoundException extends Exception
{
	private static final long serialVersionUID = 4854643962763873029L;

	public NoDocumentsFoundException(String message)
    {
        super(message);
    }
}
