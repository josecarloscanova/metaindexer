package org.nanotek.lucene.manage;

//import org.nanotek.cms.domain.lucene.config.IndexConfiguration;
import org.nanotek.lucene.index.config.IndexConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//TODO:Fix the Configuration Manager.
public class IndexConfigurationManager  implements ApplicationContextAware{

	private ApplicationContext context;

	public IndexConfiguration getIndexConfiguration()
	{
			return (IndexConfiguration) context.getBean("indexConfiguration");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
			this.context = arg0;
	}

}