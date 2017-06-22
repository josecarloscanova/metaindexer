package org.nanotek.indexer.util.key;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.nanotek.lucene.annotations.Document;

@Document(name="BaseKeyService")
public abstract class BaseKeyService<K> implements KeyService<K> {
	
	private static final String  fmt = "%24s: %s%n";
	
	@Override
	public Class<?> getKeyClass() {
		Class<?> type = getType(this.getClass()); 
		return type;  
	}

	@SuppressWarnings("rawtypes")
	private Class<?> getType(Class<? extends BaseKeyService> clazz) {
		
		ParameterizedType tp = (ParameterizedType) clazz.getGenericSuperclass(); 
		Type [] tp1 = (Type[]) ((tp.getActualTypeArguments().length > 0)?tp.getActualTypeArguments():Arrays.asList(tp.getRawType()).toArray()); 
		Class<?> ct = null; 
		for (Type t : tp1){  
			ct = (Class<?>) t; 
			break;
		}
        return ct;
	}
}
