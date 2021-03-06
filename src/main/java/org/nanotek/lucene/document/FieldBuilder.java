package org.nanotek.lucene.document;

import java.io.Serializable;

import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.apache.lucene.document.DoubleField;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.FloatField;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.nanotek.Base;
import org.nanotek.BuilderException;
import org.nanotek.ConfigurationBuilder;
import org.nanotek.base.Configuration;
//import org.nanotek.cms.domain.lucene.config.document.FieldConfiguration;
import org.nanotek.lucene.document.configuration.FieldConfiguration;

@SuppressWarnings("serial")
public class FieldBuilder<T extends Serializable> implements ConfigurationBuilder<Field,FieldConfiguration>,Base<T>{

	protected Validator validator; 

	private static final Logger log = Logger.getLogger(FieldBuilder.class);
	protected T id; 
	//	private String value; 


	public FieldBuilder() {
	}

	public FieldBuilder(T value) {
		assert(value != null);
		this.id = value;
	}

	@Override
	public Field build() {
		assert (id !=null);
		return new StringField("Empty", this.id.toString(), Store.NO);
	}

	@Override
	public T getId() {
		return id;
	}

	@Override
	public void setId(T id) {
		this.id = id;
	}

	@Override
	public Field build(Configuration<FieldConfiguration> baseParameters) {
		Field configuratedField = null;
		try { 
			FieldType luceneFieldType = new FieldType ();
			luceneFieldType.setStored((baseParameters.get().getStore() == Store.YES)?true:false);
			luceneFieldType.setStoreTermVectors(baseParameters.get().getStoreTermVector());
			luceneFieldType.setStoreTermVectorPositions(baseParameters.get().getOmitTermFreqAndPositions());
			luceneFieldType.setStoreTermVectorOffsets(baseParameters.get().getStorePositionWithTermVector());
			luceneFieldType.setIndexed(baseParameters.get().getIndexed());
			luceneFieldType.setOmitNorms(baseParameters.get().getOmitNorms());
			luceneFieldType.setNumericType(baseParameters.get().getNumericType());
			luceneFieldType.setTokenized(baseParameters.get().getTokenized());
			luceneFieldType.freeze();
			if (baseParameters.get().getNumericType()==null) 
				configuratedField = new Field (baseParameters.get().getName(), getId().toString(), luceneFieldType);	
			else { 
				configuratedField = buildNumericField(baseParameters.get(), getId().toString() , luceneFieldType);
			}
		}catch (Exception ex) 
		{ 
			log.debug (ex);
			throw new BuilderException(ex);
		}
		return configuratedField;
	}

	private Field buildNumericField(FieldConfiguration configuration , String value, FieldType luceneFieldType) {
		Field tempField = null; 
		Number num = null; 
		switch (configuration.getNumericType()){ 
		case INT:
			num = Integer.decode(value);
			tempField = new IntField(configuration.getName(), (Integer) num, luceneFieldType);
			break;
		case LONG:
			num = Long.decode(value);
			tempField = new LongField(configuration.getName(), (Long) num, luceneFieldType);
			break;
		case FLOAT:
			num = Float.parseFloat(value);
			tempField = new FloatField(configuration.getName(), (Long) num, luceneFieldType);
			break;
		case DOUBLE:
			num = Double.parseDouble(value);
			tempField = new DoubleField(configuration.getName(), (Double) num, luceneFieldType);
			break;
		default: break;
		}
		assert (tempField !=null);
		return tempField;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

}
