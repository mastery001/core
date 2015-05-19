package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_slink")
public class Slink implements Serializable,Cloneable{
	private Integer sta_id; //编号;
	private Integer mbr_id; //检测项目编号;
	private Integer p_id; //样品编号;
	private String line; //方法测定底限;
	private String unit; //底限单位;

	@PrimaryKeyAnnotation(primaryKey = "sta_id")
	@ForeignKeyAnnotation("sta_id")
	public Integer getSta_id() {
		 return this.sta_id;
	}

	public void setSta_id(Integer sta_id) {
		this.sta_id = sta_id;
	}

	@PrimaryKeyAnnotation(primaryKey = "mbr_id")
	@ForeignKeyAnnotation("mbr_id")
	public Integer getMbr_id() {
		 return this.mbr_id;
	}

	public void setMbr_id(Integer mbr_id) {
		this.mbr_id = mbr_id;
	}

	@PrimaryKeyAnnotation(primaryKey = "p_id")
	@ForeignKeyAnnotation("p_id")
	public Integer getP_id() {
		 return this.p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getLine() {
		 return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getUnit() {
		 return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
	@Override
	public  Object clone() {
		// TODO Auto-generated method stub
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "Slink [sta_id=" + sta_id + ", mbr_id=" + mbr_id + ", p_id="
				+ p_id + ", line=" + line + ", unit=" + unit + "]";
	}

}