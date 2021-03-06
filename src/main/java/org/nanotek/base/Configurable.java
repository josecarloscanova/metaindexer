package org.nanotek.base;

/**
 * A configurable object, defines an Object that is "configurable" based on a
 * certain Configurator object, such configurable object holds as the Configurator
 * 2 diferent Keys (that on theory are serializable keys) 
 */

import java.io.Serializable;

import org.nanotek.Base;
import org.nanotek.Kong;

public interface Configurable <I extends  Base<?> ,K extends Serializable> extends Base<K> {

	public I getOriginBase();
	public <T> T getTarget(); 
	
}
