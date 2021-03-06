package org.nanotek;

import org.nanotek.Converter;

public interface DataConverter <C,D> extends Converter<C,D>{
	public C toConverted(D data);
	public D toData(C convertedData);
}
