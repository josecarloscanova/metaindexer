package org.nanotek.base;

import org.nanotek.Kong;

/**
 * A configurations class, the Configuration is based on a "somewhere (which means under certain location)" persistent 
 * object, the class has the characteristic to be also persistent under a "persistent mechanism"
 * that is not necessary the same persistent mechanism of the Parameter(s) collection.
 * 
 * @author josecanova
 *
 * @param <T> -> Used to describe the which "Kind of Configuration" using the "Kong get" descriptor.
 * 
 */

public interface Configuration<T> extends Kong<T> {
}
