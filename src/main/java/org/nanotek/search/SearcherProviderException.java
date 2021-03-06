package org.nanotek.search;

@SuppressWarnings("serial")
public class SearcherProviderException extends RuntimeException {

	public SearcherProviderException() {
	}

	public SearcherProviderException(String message) {
		super(message);
	}

	public SearcherProviderException(Throwable cause) {
		super(cause);
	}

	public SearcherProviderException(String message, Throwable cause) {
		super(message, cause);
	}

	public SearcherProviderException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
