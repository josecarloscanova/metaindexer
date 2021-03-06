package org.nanotek.lucene.search;

@SuppressWarnings("serial")
public class SearcherServiceException extends RuntimeException {

	public SearcherServiceException() {
	}

	public SearcherServiceException(String message) {
		super(message);
	}

	public SearcherServiceException(Throwable cause) {
		super(cause);
	}

	public SearcherServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public SearcherServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
