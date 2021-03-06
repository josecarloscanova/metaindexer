package org.nanotek.message;

import org.nanotek.Base;
import org.nanotek.DataConverter;

public interface MessageConverter<C,D extends Base<?>> extends DataConverter<C,D> {

	@Override
	public C toConverted(D data);
	@Override
	public D toData(C convertedData);
	
}
