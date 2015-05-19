package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_dete")
public class Dete implements Serializable{
	private Integer dete_id; //检测编号;
	private String lab_id; //实验室编号;
	private String technology; //检测技术;
	private String person; //检测人员;
	private String mbr_workdate; //检测室负责人;
	private String cycle; //检测周期;
	private String charge; //检测费用;
	private String isApprove; //CNAS认可;
	private String subcontractor; //分包;
	private String depart; //检测部门;
	private String sub_charge; //分包费用;
	private String sub_lab; //分包实验室;
	private String mbr_stop; //项目是否暂停;
	private String mbr_reason; //暂停原因;
	private Integer p_id; //样品;
	private Integer mbr_id; //检测项目;
	private String standby; //备用;
	private Integer sta_id; //方法;

	@PrimaryKeyAnnotation(primaryKey = "dete_id")
	public Integer getDete_id() {
		 return this.dete_id;
	}

	public void setDete_id(Integer dete_id) {
		this.dete_id = dete_id;
	}

	@PrimaryKeyAnnotation(primaryKey = "lab_id")
	@ForeignKeyAnnotation("lab_id")
	public String getLab_id() {
		 return this.lab_id;
	}

	public void setLab_id(String lab_id) {
		this.lab_id = lab_id;
	}

	public String getTechnology() {
		 return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getPerson() {
		 return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getMbr_workdate() {
		 return this.mbr_workdate;
	}

	public void setMbr_workdate(String mbr_workdate) {
		this.mbr_workdate = mbr_workdate;
	}

	public String getCycle() {
		 return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getCharge() {
		 return this.charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getIsApprove() {
		 return this.isApprove;
	}

	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}

	public String getSubcontractor() {
		 return this.subcontractor;
	}

	public void setSubcontractor(String subcontractor) {
		this.subcontractor = subcontractor;
	}

	public String getDepart() {
		 return this.depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getSub_charge() {
		 return this.sub_charge;
	}

	public void setSub_charge(String sub_charge) {
		this.sub_charge = sub_charge;
	}

	public String getSub_lab() {
		 return this.sub_lab;
	}

	public void setSub_lab(String sub_lab) {
		this.sub_lab = sub_lab;
	}

	public String getMbr_stop() {
		 return this.mbr_stop;
	}

	public void setMbr_stop(String mbr_stop) {
		this.mbr_stop = mbr_stop;
	}

	public String getMbr_reason() {
		 return this.mbr_reason;
	}

	public void setMbr_reason(String mbr_reason) {
		this.mbr_reason = mbr_reason;
	}

	@ForeignKeyAnnotation("p_id")
	public Integer getP_id() {
		 return this.p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	@ForeignKeyAnnotation("mbr_id")
	public Integer getMbr_id() {
		 return this.mbr_id;
	}

	public void setMbr_id(Integer mbr_id) {
		this.mbr_id = mbr_id;
	}

	public String getStandby() {
		 return this.standby;
	}

	public void setStandby(String standby) {
		this.standby = standby;
	}

	@ForeignKeyAnnotation("sta_id")
	public Integer getSta_id() {
		 return this.sta_id;
	}

	public void setSta_id(Integer sta_id) {
		this.sta_id = sta_id;
	}
	@Override
	public String toString() {
		return "Dete [dete_id=" + dete_id + ", lab_id=" + lab_id
				+ ", technology=" + technology + ", person=" + person
				+ ", mbr_workdate=" + mbr_workdate + ", cycle=" + cycle
				+ ", charge=" + charge + ", isApprove=" + isApprove
				+ ", subcontractor=" + subcontractor + ", depart=" + depart
				+ ", sub_charge=" + sub_charge + ", sub_lab=" + sub_lab
				+ ", mbr_stop=" + mbr_stop + ", mbr_reason=" + mbr_reason
				+ ", p_id=" + p_id + ", mbr_id=" + mbr_id + ", standby="
				+ standby + ", sta_id=" + sta_id + "]";
	}

}