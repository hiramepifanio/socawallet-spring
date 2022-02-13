package br.com.soca.wallet.util;

public class ModelException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public ModelException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
