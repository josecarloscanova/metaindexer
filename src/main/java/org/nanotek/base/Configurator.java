package org.nanotek.base;

import java.io.Serializable;

import org.nanotek.Base;
import org.nanotek.Kong;

public interface Configurator<T extends Kong<?> , I extends  Base<?> ,K extends Serializable> extends Base<K>{

	public Configurable<I,K>  configure(I info);
	
}
