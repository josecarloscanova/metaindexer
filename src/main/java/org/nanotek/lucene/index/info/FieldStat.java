package org.nanotek.lucene.index.info;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class FieldStat implements Base<Long> {

	private String fieldName; 
	private Long size; 
	private Long docCount; 
	private Long sumDocFrequency;
	private Long docFrequency;
	private Long sumTotalTermFreq;
	private boolean hasOffsets = false; 
	private boolean hasPositions = false; 
	private boolean hasPayloads = false; 
	
	public FieldStat() {
	}

	public FieldStat(String fieldName, Long size, Long docCount,
			Long sumDocFrequency, Long docFrequency, Long sumTotalTermFreq,
			boolean hasOffsets, boolean hasPositions, boolean hasPayloads) {
		super();
		
		this.fieldName = fieldName;
		this.size = size;
		this.docCount = docCount;
		this.sumDocFrequency = sumDocFrequency;
		this.docFrequency = docFrequency;
		this.sumTotalTermFreq = sumTotalTermFreq;
		this.hasOffsets = hasOffsets;
		this.hasPositions = hasPositions;
		this.hasPayloads = hasPayloads;
		
	}
	
	@Override
	public Long getId() {
		return null;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getDocCount() {
		return docCount;
	}

	public void setDocCount(Long docCount) {
		this.docCount = docCount;
	}

	public Long getSumDocFrequency() {
		return sumDocFrequency;
	}

	public void setSumDocFrequency(Long sumDocFrequency) {
		this.sumDocFrequency = sumDocFrequency;
	}

	public Long getDocFrequency() {
		return docFrequency;
	}

	public void setDocFrequency(Long docFrequency) {
		this.docFrequency = docFrequency;
	}

	public Long getSumTotalTermFreq() {
		return sumTotalTermFreq;
	}

	public void setSumTotalTermFreq(Long sumTotalTermFreq) {
		this.sumTotalTermFreq = sumTotalTermFreq;
	}

	public Boolean hasOffsets() {
		return hasOffsets;
	}

	public void setHasOffsets(boolean hasOffsets) {
		this.hasOffsets = hasOffsets;
	}

	public void setHasPositions(boolean hasPositions) {
		this.hasPositions = hasPositions; 
	}

	public boolean hasPositions() {
		return hasPositions;
	}

	public boolean hasPayloads() {
		return hasPayloads;
	}

	public void setHasPayloads(boolean hasPayloads) {
		this.hasPayloads = hasPayloads;
	}

	@Override
	public void setId(Long id) {
	}

}
