package org.web.dao.core.support;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.web.dao.annotation.AnnotationUtil;
import org.web.exception.DBException;
import org.web.po.Bounds;
import org.web.po.Bslink;
import org.web.po.Mbr;
import org.web.po.Product;
import org.web.po.Sta;
import org.web.util.ExceptionUtil;
import org.web.vo.Hazards;

import tool.mastery.core.BeanUtil;
import tool.mastery.log.Logger;

public class HazardsDao extends AbstractVoDaoAdvice {

	public static final Logger LOG = Logger.getLogger(HazardsDao.class);

	@Override
	protected VoResolve buildVoResolve() {
		// TODO Auto-generated method stub
		Class<?>[] allPo = new Class<?>[] { Mbr.class, Product.class,
				Sta.class, Bounds.class, Bslink.class };
		Class<?> voClass = Hazards.class;
		Map<Class<?>, String> ignoreField = new HashMap<Class<?>, String>();
		ignoreField.put(Sta.class, "category_id");
		return helpAdvice.getVoResolve(allPo, voClass, null, ignoreField);
	}

	@Override
	public void save(Object entity) throws DBException {
		Object[] poValue = this.initVoResolveToGetPoValue(entity);
		// 先对前四个插值得到其主键
		for (int i = 0; i < 3; i++) {
			Object bean = DAO.saveBeforeQuery(poValue[i]);
			// 将主键存下来！
			String primaryKeyName = AnnotationUtil.ANNOTAION_UTIL
					.getPrimaryKey(poValue[i].getClass())[0];
			try {
				if (!(poValue[i] instanceof Sta)) {
					BeanUtil.setProperty(poValue[3], bean, primaryKeyName);
				} else {
					BeanUtil.setProperty(poValue[4], bean, primaryKeyName);
				}
			} catch (Exception e) {
				LOG.debug(e);
				throw new DBException(e);
			}
		}
		// 先将Bounds对象插入之后，查询出b_id后赋值到Bslink对象中
		Object bean = DAO.saveBeforeQuery(poValue[3]);
		try {
			BeanUtil.setProperty(
					poValue[4],
					bean,
					AnnotationUtil.ANNOTAION_UTIL.getPrimaryKey(bean.getClass())[0]);
		} catch (Exception e) {
			LOG.debug(e);
			throw new DBException(e);
		}
		DAO.save(poValue[4]);
	}

	@Override
	public void update(Object entity) throws DBException {
		Bslink oldBs = null;
		Bounds oldB = null;
		Map<String, Object> valueMaps = new HashMap<String, Object>();
		Object[] poValue = this.initVoResolveToGetPoValue(entity);
		for (Object po : poValue) {
			if (po instanceof Bounds) {
				oldB = (Bounds) po;
			} else if (po instanceof Sta || po instanceof Mbr
					|| po instanceof Product) {
				// 将主键存下来！
				String primaryKeyName = AnnotationUtil.ANNOTAION_UTIL
						.getPrimaryKey(po.getClass())[0];
				try {
					PropertyUtils.setProperty(po, primaryKeyName, null);
				} catch (Exception e) {
					LOG.debug(e);
					throw new DBException(e);
				}
				Object bean = DAO.saveBeforeQuery(po);
				valueMaps.put(primaryKeyName, bean);
			} else {
				oldBs = (Bslink) po;
			}
		}
		Bslink newBs = oldBs.clone();
		for (Iterator<String> it = valueMaps.keySet().iterator(); it.hasNext();) {
			String primaryKeyName = it.next();
			try {
				if (!primaryKeyName.equalsIgnoreCase("sta_id")) {
					BeanUtil.setProperty(oldB, valueMaps.get(primaryKeyName),
							primaryKeyName);
				} else {
					BeanUtil.setProperty(newBs, valueMaps.get(primaryKeyName),
							primaryKeyName);
				}
			} catch (Exception e) {
				LOG.debug(ExceptionUtil.formatStackTrace(e), e);
				throw new DBException(e);
			}
		}
		// 更新Bounds对象
		DAO.update(oldB);

		// 判断需要插入的对象是否存在
		// 如果对象不存在则删除以前的
		if (DAO.get(newBs) == null) {
			DAO.save(newBs);
			DAO.delete(oldBs);
		} else {
			DAO.update(newBs);
		}

	}

	@Override
	public void delete(Object entity) throws DBException {
		Object[] poValue = this.initVoResolveToGetPoValue(entity);
		DAO.delete(poValue[3]);
	}

	@Override
	protected boolean operateCondition(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
