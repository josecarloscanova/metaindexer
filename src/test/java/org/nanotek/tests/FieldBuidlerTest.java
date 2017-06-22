package org.nanotek.tests;

import java.util.Date;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType.NumericType;
import org.junit.Test;
import org.nanotek.lucene.document.FieldBuilder;
//import org.nanotek.cms.domain.lucene.config.document.DocumentConfiguration;
//import org.nanotek.cms.domain.lucene.config.document.FieldConfiguration;
import org.nanotek.lucene.document.configuration.DocumentConfiguration;
import org.nanotek.lucene.document.configuration.FieldConfiguration;

public class FieldBuidlerTest {

	
	public FieldBuidlerTest() {
	}
	
	@Test
	public void testFieldBuilder()
	{ 
		DocumentConfiguration documentConfiguration = new DocumentConfiguration();
		FieldConfiguration conf = new FieldConfiguration("UD" , "LONG NAME"); 
		conf.setNumericType(NumericType.LONG);
		FieldBuilder<Long> longFieldBuilder = new FieldBuilder<Long>(10L);
		Field field = longFieldBuilder.build(conf);
		documentConfiguration.getFieldConfigMap();
		System.out.println(field.name() + "  "  + field.stringValue());
		conf.setNumericType(NumericType.DOUBLE);
		FieldBuilder<Double> doubleFieldBuilder = new FieldBuilder<Double>(10.000D);	
		System.out.println(field.name() + "  "  + field.stringValue());
		field = doubleFieldBuilder.build(conf);
		System.out.println(field.name() + "  "  + field.stringValue());
		conf.setNumericType(null);
		FieldBuilder<Date> dateFieldBuilder = new FieldBuilder<Date>(new Date());	
		field = dateFieldBuilder.build(conf);
		System.out.println(field.name() + "  "  + field.stringValue());

	}
	
	public static void main(String[] args)
	{ 
		FieldBuidlerTest ft = new FieldBuidlerTest();
	}

}
