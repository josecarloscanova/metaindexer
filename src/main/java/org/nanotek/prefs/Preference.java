package org.nanotek.prefs;

import org.nanotek.Base;

@SuppressWarnings("serial")
public class Preference implements Base <String> {

	private String id; 
	
	private String key; 
	
	private String value; 
	
	private PreferenceSet preferenceSet;

	public Preference() {}
	
	public Preference(String key, String value) {
		this.key = key; 
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public PreferenceSet getPreferenceSet() {
		return preferenceSet;
	}

	public void setPreferenceSet(PreferenceSet preferenceSet) {
		this.preferenceSet = preferenceSet;
	}
	
}
