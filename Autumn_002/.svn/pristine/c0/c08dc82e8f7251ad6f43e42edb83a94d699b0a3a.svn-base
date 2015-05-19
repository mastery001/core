package org.web.dao.core.support;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.web.dao.annotation.AnnotationUtil;
import org.web.dao.annotation.Util;
import org.web.dao.core.SqlAdvice;
import org.web.dao.core.SqlConstant;

class DefaultSqlAdvice implements SqlAdvice {

	/**
	 * 允许打印sql语句
	 */
	private boolean isPrint = true;

	@Override
	public boolean isPrint() {
		return isPrint;
	}

	@Override
	public void print(Object obj) {
		if (isPrint) {
			System.out.println(obj);
		}
	}

	@Override
	public String buildSaveSql(Object entity, Statement stmt)
			throws SQLException {
		String insertSql = "";
		AnnotationUtil annotationUtil = AnnotationUtil.getInstance();
		// 获取表名
		String tableName = annotationUtil.getAnnotationTableName(entity
				.getClass());
		// 获取主键名
		String[] primaryKeyNames = annotationUtil.getPrimaryKey(entity
				.getClass());
		// 获取实体类存放的属性名和值
		Map<String, Object> beanMap = annotationUtil.getBeanInfo(entity);

		/**
		 * select * from tablename where 1=0的意义 此语句的作用是: 打开此记录集,但并不从记录集中读取任何记录
		 * 直观点说就是,为保护记录集数据,仅做打开,是只做插入记录时用到
		 */
		List<ColumnMeta> list = refresh("select * from " + tableName
				+ " where 1=0", stmt);
		// 获得表中一共有几个字段
		int columnCount = list.size();
		// 组装字段
		StringBuffer columnBuffer = new StringBuffer("insert into " + tableName
				+ "(");
		StringBuffer valueBuffer = new StringBuffer(" values(");
		for (int i = 0; i < columnCount; i++) {
			ColumnMeta cm = list.get(i);
			// 获取列名
			String columnName = cm.getColumnName();
			// 获取此字段的类型
			String columnType = cm.getColumnType();
			// 获取此字段的值
			Object columnValue = beanMap.get(columnName);
			// 如果不是自动增长的字段,并且是主键
			if (!cm.isAutoIncrement()
					&& isPrimaryKey(columnName, primaryKeyNames)) {

				// 如果是最后一个字段
				if (i == columnCount) {
					columnBuffer.append(columnName + ")");
					if (isNumberType(columnType)) {
						valueBuffer.append(columnValue + ")");
					} else {
						valueBuffer.append("'" + columnValue + "')");
					}
				} else {
					columnBuffer.append(columnName + ",");
					if (isNumberType(columnType)) {
						valueBuffer.append(columnValue + ",");
					} else {
						valueBuffer.append("'" + columnValue + "',");
					}
				}
			}
			// 如果不是自动增长的字段,并且不是主键
			if (!cm.isAutoIncrement()
					&& !isPrimaryKey(columnName, primaryKeyNames)) {

				if (i == columnCount) {
					// 将字段插入到SQL语句中的"insert into tableName("之后
					columnBuffer.append(columnName + ")");
					// 如果插入的值为数值
					if (isNumberType(columnType)) {
						if (columnType.indexOf("date") == 0) {
							columnValue = new Util()
									.transferDateToString((java.util.Date) columnValue);
						}
						valueBuffer.append(columnValue + ")");
						;
					} else {
						// 如果插入的值为空
						if (columnValue == null) {
							valueBuffer.append(columnValue + ")");
						} else {
							if (columnType.indexOf("date") == 0) {
								columnValue = new Util()
										.transferDateToString((java.util.Date) columnValue);
							}
							// 如果插入的值不为空
							valueBuffer.append("'" + columnValue + "')");
						}
					}
				} else {
					// 将字段插入到SQL语句中的"insert into tableName("之后
					columnBuffer.append(columnName + ",");
					// 如果插入的值为数值
					if (isNumberType(columnType)) {
						valueBuffer.append(columnValue + ",");
					} else {
						if (columnValue == null) {
							valueBuffer.append(columnValue + ",");
						} else {
							if (columnType.indexOf("date") == 0) {
								columnValue = new Util()
										.transferDateToString((java.util.Date) columnValue);
							}
							valueBuffer.append("'" + columnValue + "',");
						}
					}
				}
			}
		} // end the first for
		columnBuffer.deleteCharAt(columnBuffer.lastIndexOf(","));
		columnBuffer.append(")");
		valueBuffer.deleteCharAt(valueBuffer.lastIndexOf(","));
		valueBuffer.append(")");
		insertSql = columnBuffer.toString() + valueBuffer.toString();
		return insertSql;
	}

	@Override
	public String buildUpdateSql(Object entity, Statement stmt)
			throws SQLException {
		AnnotationUtil annotationUtil = AnnotationUtil.getInstance();
		// 获取表名
		String tableName = annotationUtil.getAnnotationTableName(entity
				.getClass());
		// 获取主键名
		String[] primaryKeyNames = annotationUtil.getPrimaryKey(entity
				.getClass());
		// 获取实体类存放的属性名和值
		Map<String, Object> beanMap = annotationUtil.getBeanInfo(entity);

		/**
		 * select * from tablename where 1=0的意义 此语句的作用是: 打开此记录集,但并不从记录集中读取任何记录
		 * 直观点说就是,为保护记录集数据,仅做打开,是只做插入记录时用到
		 */
		List<ColumnMeta> list = refresh("select * from " + tableName
				+ " where 1=0", stmt);

		int columnCount = list.size();

		StringBuffer valueBuffer = new StringBuffer("update " + tableName
				+ " set ");
		String whereCondition = "";
		/**
		 * 此处用于判断实体的存在性 若存在则SQL语句组装完成，将where条件中的id补入
		 */
		String word = " where ";
		boolean flag = false;
		for (int i = 0; i < columnCount; i++) {
			ColumnMeta cm = list.get(i);
			String columnName = cm.getColumnName();
			String columnType = cm.getColumnType();
			Object columnValue = beanMap.get(columnName);
			if(columnValue == null) {
				continue;
			}
			if (isPrimaryKey(columnName, primaryKeyNames)) {
				// 当主键为数字的类型时
				if (isNumberType(columnType)) {
					whereCondition += word + columnName + "=" + columnValue;
				} else {
					whereCondition += word + columnName + "='" + columnValue
							+ "'";
				}
				if (primaryKeyNames.length > 1) {
					word = " and ";
				}
			} else {
				if (columnValue != null) {
					flag = true;
					// 若为最后一个
					if (i == columnCount) {
						// 若为数字
						if (isNumberType(columnType)) {
							valueBuffer.append(columnName + "=" + columnValue);
						} else {
							if (columnType.indexOf("date") == 0) {
								columnValue = new Util()
										.transferDateToString((java.util.Date) columnValue);
							}
							valueBuffer.append(columnName + "='" + columnValue
									+ "'");
						}
					} else {
						if (isNumberType(columnType)) {
							valueBuffer.append(columnName + "=" + columnValue
									+ ",");
						} else {
							if (columnType.indexOf("date") == 0) {
								columnValue = new Util()
										.transferDateToString((java.util.Date) columnValue);
							}
							valueBuffer.append(columnName + "='" + columnValue
									+ "',");
						}
					}
				}
			}
		}
		if(!flag) {
			return null;
		}
		// 获取最后一个逗号到总长度的大小
		int quoteApartLength = valueBuffer.length()
				- valueBuffer.toString().lastIndexOf(",");
		if (quoteApartLength == 1) {
			valueBuffer.deleteCharAt(valueBuffer.toString().lastIndexOf(","));
		}
		String sql = valueBuffer.toString() + whereCondition;
		return sql;
	}

	private boolean isNumberType(String columnType) {
		return columnType.indexOf("int") == 0
				|| columnType.indexOf("integer") == 0
				|| columnType.indexOf("float") == 0
				|| columnType.indexOf("double") == 0
				|| columnType.indexOf("nember") == 0
				|| columnType.indexOf("numeric") == 0;
	}

	/**
	 * 判断列是否为主键
	 * 
	 * @param columnName
	 * @param primaryKeyNames
	 * @return
	 */
	private boolean isPrimaryKey(String columnName, String[] primaryKeyNames) {
		for (int i = 0; i < primaryKeyNames.length; i++) {
			if (columnName.equals(primaryKeyNames[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String buildDeleteSql(Object entity, Statement stmt)
			throws SQLException, Exception {
		AnnotationUtil annotationUtil = AnnotationUtil.getInstance();
		// 获取表名
		String tableName = annotationUtil.getAnnotationTableName(entity
				.getClass());
		// 获取主键名
		String[] primaryKeyNames = annotationUtil.getPrimaryKey(entity
				.getClass());

		List<ColumnMeta> list = refresh("select * from " + tableName
				+ " where 1=0", stmt);

		String valueBuffer = new String("delete from " + tableName);
		String whereCondition = "";
		/**
		 * 此处用于判断实体的存在性 若存在则SQL语句组装完成，将where条件中的id补入
		 */
		String word = " where ";
		// TODO
		for (int i = 0; i < list.size(); i++) {
			ColumnMeta cm = list.get(i);
			String columnName = cm.getColumnName();
			if (isPrimaryKey(columnName, primaryKeyNames)) {
				String columnType = cm.getColumnType();
				// 获得读取的方法
				String readMethodName = "get"
						+ columnName.substring(0, 1).toUpperCase()
						+ columnName.substring(1).toLowerCase();
				Object columnValue = entity.getClass().getMethod(readMethodName)
						.invoke(entity);
				if(columnValue == null) {
					continue;
				}
				if (isNumberType(columnType)) {
					whereCondition += word
							+ columnName
							+ "="
							+columnValue;
				} else {
					whereCondition += word
							+ columnName
							+ "='"
							+ columnValue + "'";
				}
				if (primaryKeyNames.length > 1) {
					word = " and ";
				}
			}
		}
		if(!whereCondition.contains("where")) {
			throw new SQLException("查询的主键的值不能为空！");
		}
		String sql = valueBuffer.toString() + whereCondition;
		return sql;
	}

	@Override
	public void allowPrintSql(boolean isPrint) {
		this.isPrint = isPrint;
	}

	private static Map<String, List<ColumnMeta>> cache = new HashMap<String, List<ColumnMeta>>();

	/**
	 * 获取对应的实体的meta元值
	 * 
	 * @param sql
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	private static List<ColumnMeta> refresh(String sql, Statement stmt)
			throws SQLException {
		if (!cache.containsKey(sql)) {
			ResultSet rs = stmt.executeQuery(sql);
			List<ColumnMeta> list = new ArrayList<ColumnMeta>();
			ColumnMeta cm = new ColumnMeta();
			// ResultSetMetaData对象是描述表的结构(字段名,字段类型,可容纳的长度)
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				cm = (ColumnMeta) cm.clone();
				cm.setColumnName(rsmd.getColumnName(i).toLowerCase());
				cm.setColumnType(rsmd.getColumnTypeName(i).toLowerCase());
				cm.setAutoIncrement(rsmd.isAutoIncrement(i));
				list.add(cm);
			}
			cache.put(sql, list);
		}
		return cache.get(sql);
	}

	@Override
	public String buildQuerySql(Class<?> entityClass, Statement stmt)
			throws SQLException {
		if (!SqlCache.VOSQL.containsKey(entityClass)) {
			String orderBy = "";
			AnnotationUtil annotationUtil = AnnotationUtil.getInstance();
			// 获取表名
			String tableName = annotationUtil
					.getAnnotationTableName(entityClass);
			List<ColumnMeta> list = refresh("select * from " + tableName
					+ " where 1=0", stmt);
			StringBuilder sb = new StringBuilder("select ");
			for (int i = 0; i < list.size(); i++) {
				ColumnMeta cm = list.get(i);
				String columnName = cm.getColumnName();
				sb.append(columnName + ",");
				// 如果是自动增长,或者是日期,则设置自动降序排列
				if (orderBy.equalsIgnoreCase("")) {
					if (cm.isAutoIncrement()
							|| cm.getColumnType().indexOf("date") != -1) {
						orderBy = " order by " + columnName + " desc";
					}
				}
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append(" from " + tableName);
			sb.append(SqlConstant.ORDERBY_SPLIT + orderBy);
			SqlCache.VOSQL.put(entityClass, sb.toString());
		}

		return SqlCache.VOSQL.get(entityClass);
	}

	@Override
	public String buildQuerySql(Class<?> entityClass, String queryParams,
			Statement stmt) throws SQLException {
		String sql = this.buildQuerySql(entityClass, stmt);
		if (queryParams == null) {
			return sql;
		}
		String[] fullSql = sql.split(" ");
		StringBuilder trueSQL = new StringBuilder(fullSql[0] + " "
				+ queryParams + " ");
		for (int i = 2; i < fullSql.length; i++) {
			trueSQL.append(fullSql[i] + " ");
		}
		return trueSQL.toString();
	}

	@Override
	public String buildPrimaryConditionSql(Object entity) throws SQLException {
		AnnotationUtil annotationUtil = AnnotationUtil.getInstance();
		Map<String, Object> primary = annotationUtil.getPrimaryValue(entity);
		String sql = "";
		Map<String, PropertyDescriptor> beanMap = null;
		try {
			beanMap = annotationUtil.getBeanInfo(entity.getClass());
		} catch (IntrospectionException e1) {
			throw new SQLException("查询失败:" + e1.getMessage());
		}
		Set<String> primaryNames = primary.keySet();
		String joinWord = " where ";
		for (Iterator<String> it = primaryNames.iterator(); it.hasNext();) {
			String primaryName = it.next();
			if (primary.get(primaryName) == null) {
				continue;
			}
			if (sql.indexOf("where") != -1) {
				joinWord = " and ";
			}
			// 获取主键的数据类型
			String typeName = beanMap.get(primaryName).getPropertyType()
					.getSimpleName().toLowerCase();
			// 若为字符类型
			sql += joinWord;
			if (typeName.equals("string")) {
				sql += primaryName + "='" + primary.get(primaryName) + "'";
			} else {
				sql += primaryName + "=" + primary.get(primaryName);
			}
		}
		return sql;
	}

	@Override
	public String buildConditionSql(Class<?> entityClass, int firstIndex,
			int maxResult, Map<String, String> OrderBy, String where_sql,
			String whereValue, boolean flag) throws SQLException {
		String sql = null;
		AnnotationUtil annotationUtil = AnnotationUtil.getInstance();
		Map<String, PropertyDescriptor> beanMap = null;
		try {
			beanMap = annotationUtil.getBeanInfo(entityClass);
		} catch (IntrospectionException e1) {
			throw new SQLException("查询失败：" + e1.getMessage());
		}
		// "select * from " + tableName
		// 拼接查询sql语句
		StringBuffer sqlBuffer = new StringBuffer();
		// 如果有条件查询
		if (where_sql != null) {
			sqlBuffer.append(" where ");
			String[] splitWhereSql = where_sql
					.split(SqlConstant.CONDITION_SPLIT);
			String[] splitWhereValue = whereValue
					.split(SqlConstant.CONDITION_SPLIT);
			// 如果支持模糊查询
			if (flag) {
				for (int i = 0; i < splitWhereSql.length; i++) {
					// 获取此参数的类型名
					String typeName = beanMap.get(splitWhereSql[i])
							.getPropertyType().getSimpleName().toLowerCase();
					if (typeName.equals("string")
							|| typeName.indexOf("date") != -1) {
						sqlBuffer.append(
								splitWhereSql[i] + " like '%"
										+ splitWhereValue[i] + "%'").append(
								" and ");
					} else {
						sqlBuffer.append(
								splitWhereSql[i] + "=" + splitWhereValue[i])
								.append(" and ");
					}
				}
			} else {
				for (int i = 0; i < splitWhereSql.length; i++) {
					// 获取此参数的类型名
					String typeName = beanMap.get(splitWhereSql[i])
							.getPropertyType().getSimpleName().toLowerCase();
					if (typeName.equals("string")
							|| typeName.indexOf("date") != -1) {
						sqlBuffer.append(
								splitWhereSql[i] + "='" + splitWhereValue[i]
										+ "'").append(" and ");
					} else {
						sqlBuffer.append(
								splitWhereSql[i] + "=" + splitWhereValue[i])
								.append(" and ");
					}

				}
			}
			// 将多余的and删除
			sqlBuffer.delete(sqlBuffer.lastIndexOf("and"), sqlBuffer.length());

		}

		// 设置按主键降序排序
		// sqlBuffer.append(" order by " + primaryKeyName + " desc ");
		/*
		 * if (firstIndex == 0 && maxResult == 0) {
		 * sqlBuffer.append(" order by " + primaryKeyName + " desc "); } else {
		 * sqlBuffer.append(" order by " + primaryKeyName + " desc limit " +
		 * firstIndex + "," + maxResult); }
		 */
		sql = sqlBuffer.toString();
		return sql;
	}

}
