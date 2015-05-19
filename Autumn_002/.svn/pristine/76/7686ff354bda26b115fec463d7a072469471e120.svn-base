package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;
import org.web.util.ExceptionUtil;

import tool.mastery.log.LogUtil;

@TableAnnotation(name = "t_bounds")
public class Bounds implements Serializable{
	private Integer b_id; //限量库编号;
	private String b_name; //限量库名称;
	private java.util.Date effect_date; //生效日期;
	private String residue; // 残留物定义;
	private String e_residue; // 残留物定义;
	private String limited; // 最大残留限量;
	private String limited_unit; // 限量单位;
	private String mea_site; // 测定部位;
	private Integer mbr_id; // 检测项目编号;
	private Integer p_id; // 样品编号;
	private String category_id; //类别号;

	@PrimaryKeyAnnotation(primaryKey = "b_id")
	public Integer getB_id() {
		 return this.b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		 return this.b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}


	public java.util.Date getEffect_date() {
		 return this.effect_date;
	}

	public void setEffect_date(java.util.Date effect_date) {
		this.effect_date = effect_date;
	}

	public String getCategory_id() {
		 return this.category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	@ForeignKeyAnnotation("mbr_id")
	public Integer getMbr_id() {
		return this.mbr_id;
	}

	public void setMbr_id(Integer mbr_id) {
		this.mbr_id = mbr_id;
	}

	@ForeignKeyAnnotation("p_id")
	public Integer getP_id() {
		return this.p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getResidue() {
		return this.residue;
	}

	public void setResidue(String residue) {
		this.residue = residue;
	}

	public String getE_residue() {
		return this.e_residue;
	}

	public void setE_residue(String e_residue) {
		this.e_residue = e_residue;
	}

	public String getLimited() {
		return this.limited;
	}

	public void setLimited(String limited) {
		this.limited = limited;
	}

	public String getLimited_unit() {
		return this.limited_unit;
	}

	public void setLimited_unit(String limited_unit) {
		this.limited_unit = limited_unit;
	}

	public String getMea_site() {
		return this.mea_site;
	}

	public void setMea_site(String mea_site) {
		this.mea_site = mea_site;
	}

	@Override
	public String toString() {
		return "Bounds [b_id=" + b_id + ", b_name=" + b_name + ", effect_date="
				+ effect_date + ", residue=" + residue + ", e_residue="
				+ e_residue + ", limited=" + limited + ", limited_unit="
				+ limited_unit + ", mea_site=" + mea_site + ", mbr_id="
				+ mbr_id + ", p_id=" + p_id + ", category_id=" + category_id
				+ "]";
	}


}