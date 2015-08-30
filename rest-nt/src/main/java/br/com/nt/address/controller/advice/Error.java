package br.com.nt.address.controller.advice;

public class Error {

	private String message;

	public Error() {

	}

	public Error(Throwable throwable) {
		setMessage(throwable.getMessage());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
