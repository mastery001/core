package org.web.dao.core.support;

import java.util.List;

import org.web.dao.core.DaoAdvice;
import org.web.exception.DBException;
import org.web.framework.Configuration;
import org.web.framework.service.CacheMaster;

public class ProxyDaoAdvice implements DaoAdvice{

	@SuppressWarnings("unused")
	private static final CacheMaster CM = Configuration.getCacheMaster();
	
	private DaoAdvice advice;
	
	public ProxyDaoAdvice( DaoAdvice advice) {
		this.advice = advice;
	}
	
	@Override
	public List<Object> getResult(String sql, Class<?> eneityClass)
			throws DBException {
		return this.advice.getResult(sql, eneityClass);
	}

	@Override
	public void save(Object entity) throws DBException {
		this.advice.save(entity);
	}

	@Override
	public void update(Object entity) throws DBException {
		this.advice.update(entity);
	}

	@Override
	public void delete(Object entity) throws DBException {
		this.advice.delete(entity);
	}

	@Override
	public List<Object> query(Class<?> entityClass, Object entity, Page page,
			boolean flag) throws DBException {
		return this.advice.query(entityClass, entity, page, flag);
	}

	@Override
	public Object get(Object entity) throws DBException {
		// TODO Auto-generated method stub
		return this.advice.get(entity);
	}

	@Override
	public boolean containsEntity(Object entity) throws DBException {
		return this.advice.containsEntity(entity);
	}

}
