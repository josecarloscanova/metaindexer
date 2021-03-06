package org.nanotek.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;
import org.nanotek.Conditionable;
import org.nanotek.base.Predicate;
import org.nanotek.prefs.PreferenceSet;
import org.nanotek.task.base.BaseTask;

public class ConcurrentPredicateEvaluator implements Predicate<Lockable> , Conditionable<Runnable> {

	private static final Logger log = Logger.getLogger(ConcurrentPredicateEvaluator.class);
	protected volatile Lockable lockable;

	public ConcurrentPredicateEvaluator(Lockable lockable) {
		super();
		this.lockable = lockable;
	}


	@Override
	public Conditionable<?> setCondition(Runnable run) {
		try {
			lockable.acquire();
			log.debug("ACQUIRED");
			ForkJoinTask<?> task = ForkJoinTask.adapt(run);
			task.invoke();
		}catch (Exception ex) { 
			ex.printStackTrace();
		}
		return ConcurrentPredicateEvaluator.this;
	}

	@Override
	public boolean evaluate() {
		try { 
			new RandomException();
			lockable.release();
			log.debug("EVALUATED");
		}catch (Exception ex) { 
			ex.printStackTrace();
		}
		return false;
	} 

	public static void main(String[] args){ 
		ConcurrentPredicateEvaluator evaluator = new ConcurrentPredicateEvaluator(new Lockable());
		EvaluatorTask et  = new EvaluatorTask(evaluator);
		ForkJoinTask<Integer> task = ForkJoinTask.adapt(et);
		try {
			
			Integer permits = task.invoke();
			log.debug("Number of Permissions " + permits);
			Thick timer = new Thick (evaluator.lockable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


@SuppressWarnings("serial")
class EvaluatorTask extends BaseTask <EvaluatorTask , Integer>
{ 

	private Integer id;
	private ConcurrentPredicateEvaluator evaluator;

	public EvaluatorTask(ConcurrentPredicateEvaluator evaluator){
		this.evaluator = evaluator; 
	}

	@Override
	public Integer call() throws Exception {
		
		for (int i = 0; i < 100; i++)
		{ 
			RunnableConditioned cond = new RunnableConditioned(evaluator);
			RunnableEvaluator rund = new  RunnableEvaluator(evaluator);
			Thread condThread = new Thread(cond);
			condThread.setDaemon(false);
			Thread rundThread =  new Thread(rund);//
			rundThread.setDaemon(false);
			condThread.start();
			rundThread.start();
		}
		return this.id =  new Double(Math.random() * 10000).intValue();
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public Integer getTaskId() {
		return id;
	}

	@Override
	public String getTaskName() {
		return EvaluatorTask.class.getSimpleName();
	}

	@Override
	public Date getTaskDate() {
		return new Date();
	}

	public PreferenceSet getTaskPreferenceSet() {
		return null;
	}
}

class Lockable {


	private static final Logger log = Logger.getLogger(Lockable.class);
	volatile  Semaphore lock;
	public volatile int incrementer = 0; 

	public Lockable (){ 
		lock = new Semaphore(0); 
	}
	void acquire() throws InterruptedException{ 
		lock.acquire();
		log.debug( " incrementer " + incrementer + " permits " + lock.availablePermits() );
		incrementer++;
	}

	void release() { 
		lock.release();
		log.debug( " incrementer " + incrementer + " permits " + lock.availablePermits());
		incrementer--;
	}
}

class RunnableEvaluator implements Runnable{

	private volatile ConcurrentPredicateEvaluator predicate; 

	public RunnableEvaluator(ConcurrentPredicateEvaluator predicate){ 
		this.predicate = predicate;
	}

	@Override
	public void run() {
		predicate.evaluate();
	} 

}

class RunnableConditioned implements Runnable{

	private volatile ConcurrentPredicateEvaluator predicate; 

	public RunnableConditioned(ConcurrentPredicateEvaluator predicate){ 
		this.predicate = predicate;
	}

	@Override
	public void run() {
		predicate.setCondition(new LogRun(Long.toString(System.nanoTime())));
	} 
}

class LogRun implements Runnable {

	private volatile String condition; 

	public LogRun(String condition) 
	{ 
		this.condition = condition;
	}

	Logger log = Logger.getLogger(LogRun.class);
	@Override
	public void run() {
		log.debug("RUN LOG RUN " + condition);
	} 

}

class ConditionedLogRun<T> implements Runnable {

	private volatile Lockable  lockable; 

	public ConditionedLogRun(Lockable lockable) 
	{ 
		this.lockable = lockable;
	}

	Logger log = Logger.getLogger(LogRun.class);
	@Override
	public void run() {
		log.debug("RUN LOG RUN " + lockable);
	} 

}

class RandomException	{ 

	public RandomException()
	{
		double chance = Math.random() * 100;
		if (chance > 10)
			throw new RuntimeException("CHANCE OF SOMETHING");
	} 

}

class Thick { 
	final Timer timer; 

	public Thick(Lockable lockable){ 
		timer = new Timer(true); 
		timer.schedule(new Task(lockable), 10000 , 1000);
	}
}

class Task extends TimerTask{

	private Lockable lockable;
	public Task (Lockable lockable)
	{ 
		this.lockable = lockable; 
	}
	@Override
	public void run() {
		new LogRun ("Timer task " + System.nanoTime()).run();
		lockable.release();
	} 

}