package org.web.service;

import java.util.List;

import org.web.exception.BeanInitializationException;
import org.web.exception.ErrorException;
import org.web.framework.service.Advice;

public interface OperateServiceExecuteAdvice extends Advice {
	
	/**
	 * 执行操作
	 * @param list	需要操作的数据
	 * @param operate	执行何种操作
	 * @throws ErrorException
	 * @throws BeanInitializationException 
	 */
	void execute(List<Object> list , String operate) throws ErrorException, BeanInitializationException;
	
}
