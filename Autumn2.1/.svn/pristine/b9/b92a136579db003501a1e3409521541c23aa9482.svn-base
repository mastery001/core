package org.web.service;

import java.util.List;

import org.web.access.factory.DaoAdviceFactory;
import org.web.dao.core.DaoAdvice;
import org.web.exception.BeanInitializationException;
import org.web.exception.ErrorException;
import org.web.framework.Constant;

/**
 * 对数据增删改的统一处理类 ,
 * 
 * @author mastery
 * @Time 2015-3-8 下午11:47:48
 * 
 */
public abstract class OperateService extends AbstractService implements
		OperateServiceExecuteAdvice {

	protected List<Object> list;

	protected DaoAdvice dao;

	protected abstract void save() throws ErrorException;

	protected abstract void update() throws ErrorException;

	protected abstract void delete() throws ErrorException;

	public void execute(List<Object> list, String operate)
			throws ErrorException, BeanInitializationException {
		this.list = list;
		dao = DaoAdviceFactory.getDao(name);
		this.list = processList(list);
		if (operate.equalsIgnoreCase(Constant.ADD)) {
			save();
		} else if (operate.equalsIgnoreCase(Constant.UPDATE)) {
			update();
		} else {
			delete();
		}

	}

}
