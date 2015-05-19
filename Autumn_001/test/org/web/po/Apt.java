package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name="t_apt")
public class Apt implements Serializable{
	private Integer apt_id; //资质编号;
	private String lab_id; //实验室编号;
	private String serial_id; //项目序号;
	private String project_id; //项目序号;
	private String limit_scope; //限制范围;
	private String explaination; //说明;
	private String aptutide; //资质类别;
	private Integer mbr_id; //检测项目编号;
	private String demain_code; //领域代码;
	private Integer p_id; //样品编号;
	private Integer sta_id; //方法;
	
	@PrimaryKeyAnnotation(primaryKey="apt_id")
	public Integer getApt_id() {
		 return this.apt_id;
	}

	public void setApt_id(Integer apt_id) {
		this.apt_id = apt_id;
	}
	
	@PrimaryKeyAnnotation(primaryKey="lab_id")
	@ForeignKeyAnnotation("lab_id")
	public String getLab_id() {
		 return this.lab_id;
	}

	public void setLab_id(String lab_id) {
		this.lab_id = lab_id;
	}

	public String getSerial_id() {
		 return this.serial_id;
	}

	public void setSerial_id(String serial_id) {
		this.serial_id = serial_id;
	}

	public String getLimit_scope() {
		 return this.limit_scope;
	}

	public void setLimit_scope(String limit_scope) {
		this.limit_scope = limit_scope;
	}

	public String getExplaination() {
		 return this.explaination;
	}

	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}

	public String getAptutide() {
		 return this.aptutide;
	}

	public void setAptutide(String aptutide) {
		this.aptutide = aptutide;
	}

	@ForeignKeyAnnotation("mbr_id")
	public Integer getMbr_id() {
		 return this.mbr_id;
	}

	public void setMbr_id(Integer mbr_id) {
		this.mbr_id = mbr_id;
	}

	public String getDemain_code() {
		 return this.demain_code;
	}

	public void setDemain_code(String demain_code) {
		this.demain_code = demain_code;
	}

	@ForeignKeyAnnotation("p_id")
	public Integer getP_id() {
		 return this.p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	@ForeignKeyAnnotation("sta_id")
	public Integer getSta_id() {
		 return this.sta_id;
	}

	public void setSta_id(Integer sta_id) {
		this.sta_id = sta_id;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	@Override
	public String toString() {
		return "Apt [apt_id=" + apt_id + ", lab_id=" + lab_id + ", serial_id="
				+ serial_id + ", project_id=" + project_id + ", limit_scope="
				+ limit_scope + ", explaination=" + explaination
				+ ", aptutide=" + aptutide + ", mbr_id=" + mbr_id
				+ ", demain_code=" + demain_code + ", p_id=" + p_id
				+ ", sta_id=" + sta_id + "]";
	}
}