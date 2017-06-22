package org.nanotek.lucene.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.lucene.document.FieldType.NumericType;

@Documented
@Retention(value=RUNTIME)
@Target(ElementType.TYPE)
public @interface Field {
	String name() default "";
}
