package org.nanotek.tests;

import org.nanotek.Workable;
import org.nanotek.lucene.document.configuration.DocumentConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DocumentConfigurationTest  implements Workable<String[]>{

	private static ClassPathXmlApplicationContext ctx;

	public DocumentConfigurationTest() {
	}

	public static void main(String[] args) {
		DocumentConfigurationTest work = new DocumentConfigurationTest();
		work.doWork(args);
	}

	@Override
	public void doWork(String[] args) {
		ctx = new ClassPathXmlApplicationContext(new String[] {
		"/spring-batch-jobs/artist/lucene/document-configuration-xml/artist-document-configuration.xml"});
		DocumentConfiguration documentConfiguration = (DocumentConfiguration) ctx.getBean("artistDocumentConfiguration");
		System.out.println(documentConfiguration.toString());
		for (Object key : documentConfiguration.getFieldConfigMap().keySet())
			System.out.println(documentConfiguration.getFieldConfigMap().get(key).toString());
		
	}

}
