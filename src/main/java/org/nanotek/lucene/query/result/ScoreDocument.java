package org.nanotek.lucene.query.result;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.nanotek.Base;

/**
 * The Score Document is the representation for a "Lucene Document" 
 * it encapsulates both the Lucene ScoreDoc (which holds the DocId on Index), 
 * and the (Lucene Document) which holds the values of hits that were 
 * provided by the IndexSearch.search(Query). 
 * 
 * @author JoseCanova
 *
 */

@SuppressWarnings("serial")
public class ScoreDocument implements Base<Long> {

	private Long id; 
	private ScoreDoc scoreDoc; 
	private Document document; 

	public ScoreDocument(){} 
	
	public ScoreDocument(Long id, ScoreDoc scoreDoc, Document document) {
		super();
		this.id = id;
		this.scoreDoc = scoreDoc;
		this.document = document;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public ScoreDoc getScoreDoc() {
		return scoreDoc;
	}

	public void setScoreDoc(ScoreDoc scoreDoc) {
		this.scoreDoc = scoreDoc;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}


}
