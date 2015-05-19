package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;
import org.web.util.ExceptionUtil;

import tool.mastery.log.LogUtil;

@SuppressWarnings("serial")
@TableAnnotation(name = "t_bslink")
public class Bslink implements Serializable , Cloneable {
	private Integer b_id;	// 关联表编号
	private Integer sta_id; // 方法;
	private Integer is_consult;	// 是否有参照

	@PrimaryKeyAnnotation(primaryKey = "b_id")
	@ForeignKeyAnnotation("b_id")
	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	@PrimaryKeyAnnotation(primaryKey = "sta_id")
	@ForeignKeyAnnotation("sta_id")
	public Integer getSta_id() {
		return this.sta_id;
	}

	public void setSta_id(Integer sta_id) {
		this.sta_id = sta_id;
	}

	
	public Integer getIs_consult() {
		return is_consult;
	}

	public void setIs_consult(Integer is_consult) {
		this.is_consult = is_consult;
	}

	@Override
	public String toString() {
		return "Bslink [b_id=" + b_id + ", sta_id=" + sta_id
				+ ", is_consult=" + is_consult + "]";
	}

	@Override
	public Bslink clone() {
		// TODO Auto-generated method stub
		try {
			return (Bslink) super.clone();
		} catch (CloneNotSupportedException e) {
			LogUtil.getLogger().debug(
					"clone class Bslink faild;", e);
		}
		return null;
	}
	
}
