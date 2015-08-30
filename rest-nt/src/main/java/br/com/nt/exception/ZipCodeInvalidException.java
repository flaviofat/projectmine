package br.com.nt.exception;

public class ZipCodeInvalidException extends IllegalArgumentException {

	private static final long serialVersionUID = -7336085827752800005L;

	public ZipCodeInvalidException() {
		this("CEP inválido");
	}

	public ZipCodeInvalidException(String message) {
		super(message);
	}
}
