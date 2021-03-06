package org.nanotek.lucene.manage;

@SuppressWarnings("serial")
public class IndexServiceException extends RuntimeException {

	public IndexServiceException() {
	}

	public IndexServiceException(String arg0) {
		super(arg0);
	}

	public IndexServiceException(Throwable arg0) {
		super(arg0);
	}

	public IndexServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IndexServiceException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
