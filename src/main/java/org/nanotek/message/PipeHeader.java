package org.nanotek.message;

import java.io.Serializable;

import org.nanotek.Base;
import org.nanotek.Header;


@SuppressWarnings("serial")
public class PipeHeader<T extends Serializable> implements Base<T>,Header<T>{

	private T id;
    private Long messageLenght;

    @Override
	public T getId() {
		return id;
	}


	@Override
	public void setId(T id) {
		this.id = id;
	}


	public Long getMessageLenght() {
		return messageLenght;
	}


	public void setMessageLenght(Long messageLenght) {
		this.messageLenght = messageLenght;
	}

}
