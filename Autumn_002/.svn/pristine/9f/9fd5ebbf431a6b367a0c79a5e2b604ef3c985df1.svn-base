package org.web.dao.core.support;

import java.util.ArrayList;
import java.util.List;

import org.web.exception.VoProcessorException;
import org.web.service.VoProcessor;
import org.web.vo.Hazards;

import tool.mastery.log.Logger;

public class HazardsProcessor extends VoProcessor {

	public static final Logger LOG = Logger.getLogger(HazardsProcessor.class);

	public static final String SPLIT = "、";

	@Override
	protected List<Object> convert(List<Object> vos)
			throws VoProcessorException {
		list = new ArrayList<Object>();
		Hazards obj = null;
		for (int i = 0; i < vos.size(); i++) {
			obj = (Hazards) vos.get(i);
			String m_id = obj.getM_id();
			if (m_id != null) {
				if (m_id.indexOf("、") != -1) {
					String[] m_ids = m_id.split(SPLIT);
					for (String id : m_ids) {
						LOG.debug("m_ids is :" + id);
						Hazards clone = obj.clone();
						if (id.indexOf("参照") != -1) {
							clone.setM_id(id.replace("参照", "").trim());
							clone.setIs_consult(1);
						} else {
							clone.setM_id(id);
						}
						list.add(clone);
					}
				} else if (m_id.indexOf("参照") != -1) {
					obj.setM_id(m_id.replace("参照", "").trim());
					obj.setIs_consult(1);
					list.add(obj);
				} else {
					list.add(obj);
				}
			}
		}
		return list;
	}

	@Override
	protected List<Object> reverseConvert(List<Object> vos)
			throws VoProcessorException {
		list = new ArrayList<Object>();
		Hazards entity = (Hazards) vos.get(0);
		// 如若长度只有1，则直接返回
		if (vos.size() == 1) {
			processM_id(entity);
			return vos;
		}
		StringBuffer sb = new StringBuffer();
		boolean flag = false;
		sb.append(entity.getM_id() + SPLIT);
		for (int i = 1; i < vos.size(); i++) {
			Hazards temp = (Hazards) vos.get(i);
			if (entity.getB_id().equals(temp.getB_id())
					&& entity.getMbr_id().equals(temp.getMbr_id())
					&& entity.getP_id().equals(temp.getP_id())) {
				processM_id(temp);
				sb.append(temp.getM_id() + SPLIT);
				if (i != vos.size() - 1) {
					continue;
				} else {
					flag = true;
				}
			}
			sb.delete(sb.lastIndexOf(SPLIT), sb.length());
			entity.setM_id(sb.toString());
			list.add(entity);
			if (!flag) {
				flag = false;
				entity = temp;
				sb = new StringBuffer();
				sb.append(entity.getM_id() + SPLIT);
			}
		}
		if (!flag) {
			sb.delete(sb.lastIndexOf(SPLIT), sb.length());
			entity.setM_id(sb.toString());
			list.add(entity);
		}
		return list;
	}

	private void processM_id(Hazards entity) {
		if (entity.getIs_consult() != null && entity.getIs_consult() == 1) {
			entity.setM_id("参照" + entity.getM_id());
		}
	}

}
