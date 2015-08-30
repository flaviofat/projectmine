package br.com.nt.exception;

public class AddressInvalidException extends IllegalArgumentException{

	private static final long serialVersionUID = 4830162812913731214L;

	public AddressInvalidException(String message) {
		super(message);
	}
}
