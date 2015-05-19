package org.web.po;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_power")
public class Power{
	private String p_id; //权限号;
	private String name; //权限名称;

	@PrimaryKeyAnnotation(primaryKey = "p_id")
	public String getP_id() {
		 return this.p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		 return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Power [p_id=" + p_id + ", name=" + name + "]";
	}

}