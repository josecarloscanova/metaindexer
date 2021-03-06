/**
 * Surrougate classes are specialized classes that hide the implementation
 * and provide 2 operator 1 ,2 to play. always surrougating one of the operators.
 */

package org.nanotek.lucene.query;

import java.util.Map;
import java.util.Set;

import org.nanotek.Base;

public class SurrougateMap<T1, T2> {

	private Map<String,Base<?>> queryParameters;

	public Map<String, Base<?>> getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(Map<String, Base<?>> queryParameters) {
		this.queryParameters = queryParameters;
	}

	public boolean isEmpty() {
		return queryParameters.isEmpty();
	}

	public boolean containsKey(Object key) {
		return queryParameters.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return queryParameters.containsValue(value);
	}

	public Base<?> get(Object key) {
		return queryParameters.get(key);
	}

	public Base<?> put(String key, Base<?> value) {
		return queryParameters.put(key, value);
	}

	public void putAll(Map<? extends String, ? extends Base<?>> m) {
		queryParameters.putAll(m);
	}

	public void clear() {
		queryParameters.clear();
	}

	public Set<String> keySet() {
		return queryParameters.keySet();
	}
}
