package org.nanotek.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nanotek.Base;
import org.nanotek.Reducible;
import org.nanotek.Conditionable;
import org.nanotek.MappableReference;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class MappableReferenceBase <T extends Base<?>, R extends ColumnPositionMappingStrategy<T>> extends MappableBase<T> implements MappableReference<T,R>{

	private Logger log = Logger.getLogger(MappableReferenceBase.class);
	@Override
	public <S extends Map<String, ?>> S getMap(T type) {
		return super.getMap(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends Map<String, ?>> S getMap(T type, R reference) 
	{

		ColumnPositionMappingStrategy<T> t = reduceArray(reference);
		String[] fields = t.getColumnMapping();
		HashMap<String,String>  baseMap = new HashMap<String,String>();
		for (String field : fields) { 
			try {
				if (field !=null)
					baseMap.put(field, BeanUtils.getProperty(type, field));
			} catch (IllegalAccessException | InvocationTargetException
					| NoSuchMethodException e) {
				throw new MappableException(e);
			}
		}
		return (S) baseMap;
	}

	public <RA extends ColumnPositionMappingStrategy<T>> RA reduceArray(R reference) 
	{ 
		return new Reduced().reduce(reference); 
	}

	class Reduced implements Reducible<ColumnPositionMappingStrategy<T>> {

		public boolean isReducible(ColumnPositionMappingStrategy<T> mappingStrategy)
		{ 
			return new NullablePredicateConditioned().setCondition(mappingStrategy.getColumnMapping())
					   .evaluate();
		}

		@Override
		@SuppressWarnings("unchecked")
		public <M extends ColumnPositionMappingStrategy<T>> M reduce(ColumnPositionMappingStrategy<T> reducible) {
			M r = (M) new ColumnPositionMappingStrategy<T>();
			if (isReducible(reducible)){ 
				String [] fieldNames = reducible.getColumnMapping();
				List<String> nameList = new ArrayList<String>(); 
				for (String field : fieldNames) 
				{ 
					if (field !=null)
						nameList.add(field);
				}
				String [] names = nameList.toArray(new String[nameList.size()]);
				r.setColumnMapping(names);	
			}else 
				{ 
					r = copyRef(reducible);
				}
			return r; 
		}

		@SuppressWarnings("unchecked")
		public <M extends ColumnPositionMappingStrategy<T>> M  copyRef (ColumnPositionMappingStrategy<T> r){ 
			String[] vals = Arrays.copyOf(r.getColumnMapping(), r.getColumnMapping().length);
			M instance = null; 
			try {
				instance = (M) ColumnPositionMappingStrategy.class.newInstance(); 
				instance.setType(r.getType());
				instance.setColumnMapping(vals);
			} catch (InstantiationException | IllegalAccessException e) {
				log.debug(e);
				throw new StrategyExcetion(e);
			}
			return instance;
			
		}
	}


	class NullablePredicateConditioned implements Predicate<String[]> , Conditionable<String[]>{

		private volatile String[] condition;

		public boolean evaluate() {
			boolean eval = false; 
			for (String element : condition) {
				if (element == null)
					eval = true;
				break;
			}
			return eval;
		}

		public NullablePredicateConditioned setCondition(String[] condition) {
			this.condition = condition;
			return NullablePredicateConditioned.this;
		}

	}

}


