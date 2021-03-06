package org.nanotek.pipe;

@SuppressWarnings("serial")
public class PipeException extends RuntimeException {

	public PipeException() {
	}

	public PipeException(String message) {
		super(message);
	}

	public PipeException(Throwable cause) {
		super(cause);
	}

	public PipeException(String message, Throwable cause) {
		super(message, cause);
	}

	public PipeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
