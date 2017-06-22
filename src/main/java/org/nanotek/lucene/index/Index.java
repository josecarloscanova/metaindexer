package org.nanotek.lucene.index;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.util.Version;
import org.nanotek.Base;
import org.nanotek.lucene.index.info.IndexStats;

@SuppressWarnings("serial")
public class Index implements Base<Long> {

	private Long id;
	private String indexDesignation;
	private String path;
	private String defaultField = "name";
	private Version version;
	private OpenMode openMode;
	private IndexType indexType;
//	private Analyzer analyzer;
	private Date dataUpdate;
	private Date dateInsert;
	private IndexStats indexStats;
	private Set<Store> indexStore = new HashSet<Store>();
	private final transient ReentrantLock lock = new ReentrantLock();

	public ReentrantLock getLock() {
		return lock;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}


	public String getIndexDesignation() {
		return indexDesignation;
	}

	public void setIndexDesignation(String indexDesignation) {
		this.indexDesignation = indexDesignation;
	}

	public Set<Store> getIndexStore() {
		return indexStore;
	}

	public void setIndexStore(Set<Store> indexStore) {
		this.indexStore = indexStore;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public OpenMode getOpenMode() {
		return openMode;
	}

	public void setOpenMode(OpenMode openMode) {
		this.openMode = openMode;
	}

//	public Analyzer getAnalyzer() {
//		return analyzer;
//	}
//
//	public void setAnalyzer(Analyzer analyzer) {
//		this.analyzer = analyzer;
//	}

	public Date getDataUpdate() {
		return dataUpdate;
	}

	public void setDataUpdate(Date dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

	public IndexStats getIndexStats() {
		assert (indexStats !=null);
		return indexStats;
	}

	public void setIndexStats(IndexStats indexStats) {
		this.indexStats = indexStats;
	}

	public String getDefaultField() {
		return defaultField;
	}

	public void setDefaultField(String defaultField) {
		this.defaultField = defaultField;
	}

	public IndexType getIndexType() {
		return indexType;
	}

	public void setIndexType(IndexType indexType) {
		this.indexType = indexType;
	}
	
}
