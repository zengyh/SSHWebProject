package edu.log;

import org.aspectj.lang.JoinPoint;

public interface ILogAspect {
	
	
	/**
	 * 有参无返回值的方法
	 * @param point
	 */
	public void logArg(JoinPoint point);
	
	/**
	 *有参并有返回值的方法
	 * @param point
	 * @param returnObj
	 */
	public void logArgAndReturn(JoinPoint point, Object returnObj);
	

}
