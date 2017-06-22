package org.nanotek;

/**
 * A tag interface to define a Task class that act as a receiver from the User Interface 
 * and dispatches the execution on a Pool of Execution Threads.
 * 
 * @author josecanovamauger
 *
 * @param <S> Usually designed for "configuration parameters" or a the Class which concretelly 
 * executes the TASK. 
 * 
 * @param <V> The Value of return for Task Execution. 
 */

public interface Task<S,V>  {
}
