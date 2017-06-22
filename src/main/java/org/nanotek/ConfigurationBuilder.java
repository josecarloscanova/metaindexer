package org.nanotek;

import org.nanotek.base.Configuration;

public interface ConfigurationBuilder<T,I> extends BuilderBase<T,Configuration<I>> {

	@Override
	public T build(Configuration<I> baseParameters);
	
}
