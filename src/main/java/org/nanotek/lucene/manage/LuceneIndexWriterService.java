package org.nanotek.lucene.manage;
/**
 * Base IndexService for Lucene Query Processing.
 * Include methods to manage a index based on persitent objects.
 * Index and IndexConfig.
 */
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
//import org.nanotek.cms.domain.lucene.BaseDocument;
//import org.nanotek.cms.domain.lucene.IndexHolder;
//import org.nanotek.cms.domain.lucene.LuceneIndexWriterHolder;
//import org.nanotek.cms.domain.lucene.config.Index;
import org.nanotek.dao.DAO;
import org.nanotek.lucene.LuceneTemplateBuilder;
import org.nanotek.lucene.index.Index;
import org.nanotek.lucene.index.config.IndexHolder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//TODO: implement IndexWriter Service. 
/**
 * Service designed to hold operations for IndexWriting.	
 * @author java-eclipse
 *
 * @param <T>
 * @param <I>
 */
public class LuceneIndexWriterService<T extends Document,I> implements IndexWriterService<T,I>,  ApplicationContextAware{

	private DAO<Index> indexDAO;
	private Index currentIndex;
	private IndexWriter indexWriter;
	private ApplicationContext applicationContext;
	private LuceneIndexWriterHolder indexWriterRef;
	private LuceneTemplateBuilder<T> documentBuilder;
	private Boolean started = false;

	public  LuceneIndexWriterService(){}

	public  LuceneIndexWriterService (Index index)
	{
		this.currentIndex = index;
	}

	public  LuceneIndexWriterService (Index index, LuceneTemplateBuilder<T> documentBuilder)
	{
		this.currentIndex = index; 
		this.documentBuilder = documentBuilder; 
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void indexDocument(T source) {
	}

	@Override
	public IndexHolder<?, ?> getIndexHolder(I index)
			throws IndexServiceException {
		return null;
	}


}
