package org.web.po;
import java.io.Serializable;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name="t_mbr")
public class Mbr implements Serializable{
	private Integer mbr_id; //检测项目编号;
	private String cas_id; //CAS号;
	private String mbr_cname; //中文名称;
	private String mbr_ename; //英文名称;

	@PrimaryKeyAnnotation(primaryKey = "mbr_id")
	public Integer getMbr_id() {
		 return this.mbr_id;
	}

	public void setMbr_id(Integer mbr_id) {
		this.mbr_id = mbr_id;
	}

	public String getCas_id() {
		 return this.cas_id;
	}

	public void setCas_id(String cas_id) {
		this.cas_id = cas_id;
	}

	public String getMbr_cname() {
		 return this.mbr_cname;
	}

	public void setMbr_cname(String mbr_cname) {
		this.mbr_cname = mbr_cname;
	}

	public String getMbr_ename() {
		 return this.mbr_ename;
	}

	public void setMbr_ename(String mbr_ename) {
		this.mbr_ename = mbr_ename;
	}

	@Override
	public String toString() {
		return "Mbr [mbr_id=" + mbr_id + ", cas_id=" + cas_id + ", mbr_cname="
				+ mbr_cname + ", mbr_ename=" + mbr_ename + "]";
	}

}