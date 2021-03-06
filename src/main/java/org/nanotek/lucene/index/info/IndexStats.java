package org.nanotek.lucene.index.info;

public class IndexStats {

	private Long sumDocFreq;
	private Long statsFieldCount; 
	private Long sumTotalTermFreq; 
	
	public Long getSumDocFreq() {
		return sumDocFreq;
	}

	public void setSumDocFreq(Long sumDocFreq) {
		this.sumDocFreq = sumDocFreq;
	}

	public Long getStatsFieldCount() {
		return statsFieldCount;
	}

	public void setStatsFieldCount(Long statsFieldCount) {
		this.statsFieldCount = statsFieldCount;
	}

	public Long getSumTotalTermFreq() {
		return sumTotalTermFreq;
	}

	public void setSumTotalTermFreq(Long sumTotalTermFreq) {
		this.sumTotalTermFreq = sumTotalTermFreq;
	}

}
