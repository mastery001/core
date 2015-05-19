package org.web.dao.core.support;

import java.sql.Connection;

import org.web.dao.core.DaoAdvice;
import org.web.dao.core.HelpAdvice;
import org.web.dao.core.SqlAdvice;

import tool.mastery.db.DBUtil;

/**
 * 存储了当前得到对象的class的字节码
 * 
 * @author mastery
 * @Time 2015-4-10 下午3:20:19
 * 
 */
public abstract class AbstractDaoAdvice implements DaoAdvice {

	protected static final SqlAdvice sqlAdvice = GlobalSqlAdvice.getInstance();

	protected static final HelpAdvice helpAdvice = new DefaultHelpAdvice();

	protected Connection conn;

	// vo或者po类名的缩写
	protected Class<?> entityClass;

	@Override
	public void open() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void close() {
		DBUtil.close();
	}

	public AbstractDaoAdvice() {
		super();
	}

	public AbstractDaoAdvice(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	protected Connection getConnection() {
		return this.conn;
	}
}
