package org.nanotek.task;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;
import org.nanotek.Base;
//import org.nanotek.BaseTask;
import org.nanotek.Task;
//import org.nanotek.lucene.preference.PreferenceSet;
import org.nanotek.prefs.PreferenceSet;
import org.nanotek.task.base.BaseTask;

@SuppressWarnings("serial")
public class ConcreteTaskBase<T extends Task<T,K> , K extends Serializable> extends BaseTask<T,K>{

	private static final Logger logger = Logger.getLogger(ConcreteTaskBase.class);
	
	protected K id; 
	protected PreferenceSet preferenceSet;
	protected Date taskDate; 
	protected String taskName; 
	
	
	public ConcreteTaskBase() {
		preferenceSet = new PreferenceSet();
		taskDate = new Date();
		taskName = "";
	}

	public ConcreteTaskBase(K id) {
		super();
		this.id = id;
	}
	
	public ConcreteTaskBase(K id, PreferenceSet preferenceSet, String taskName) {
		super();
		this.id = id;
		this.preferenceSet = preferenceSet;
		this.taskName = taskName;
	}

	public ConcreteTaskBase(PreferenceSet preferenceSet, String taskName) {
		super();
		this.preferenceSet = preferenceSet;
		this.taskName = taskName;
	}

	@Override
	public void setId(K id) {
		this.id = id; 
	}

	@Override
	public K getId() {
		return id;
	}


	@Override
	public K getTaskId() {
		return id;
	}

	@Override
	public String getTaskName() {
		return taskName;
	}

	@Override
	public Date getTaskDate() {
		return taskDate;
	}

	public PreferenceSet getTaskPreferenceSet() {
		return preferenceSet;
	}

	@Override
	public K call() throws Exception {
		logger.debug("CALLED CALL FROM " + ConcreteTaskBase.class.getCanonicalName().toUpperCase());
		return this.getId();
	}

	public PreferenceSet getPreferenceSet() {
		return preferenceSet;
	}

}
