package org.nanotek;

public interface MessageBase<K extends Base<?>> extends Base<String> {
	public K getHeader();
	public K getMessage();
}
