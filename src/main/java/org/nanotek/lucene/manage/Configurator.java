package org.nanotek.lucene.manage;

public interface Configurator<R,C> {

	public R configure(C context);

}
