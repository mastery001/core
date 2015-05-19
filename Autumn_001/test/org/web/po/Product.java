package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_product")
public class Product implements Serializable{
	private Integer p_id; //样品编号;
	private String p_name; //样品名称;
	private String p_category; //样品类别;

	@PrimaryKeyAnnotation(primaryKey = "p_id")
	public Integer getP_id() {
		 return this.p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		 return this.p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_category() {
		 return this.p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_category="
				+ p_category + "]";
	}

}