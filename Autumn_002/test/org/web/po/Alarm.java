package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;


@TableAnnotation(name="t_alarm")
public class Alarm implements Serializable{
	private Integer alarm_id; //编号;
	private String countries; //国家地区;
	private String mechanism; //发布机构;
	private java.util.Date rel_date; //发布日期;
	private String enterprise; //企业;
	private String brand; //品牌;
	private String origin; //原产地;
	private String description; //产品名称及描述;
	private String reject_des; //不合格项目;
	private String measures; //采取措施;
	private String category; //产品分类;
	private String mbrsort; //不合格项目分类;
	private String document; //网络链接;
	private String editor; //编报人;
	private String category_id; //类别号;

	@PrimaryKeyAnnotation(primaryKey="alarm_id")
	public Integer getAlarm_id() {
		 return this.alarm_id;
	}

	public void setAlarm_id(Integer alarm_id) {
		this.alarm_id = alarm_id;
	}
	public String getCountries() {
		 return this.countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getMechanism() {
		 return this.mechanism;
	}

	public void setMechanism(String mechanism) {
		this.mechanism = mechanism;
	}
	public java.util.Date getRel_date() {
		 return this.rel_date;
	}

	public void setRel_date(java.util.Date rel_date) {
		this.rel_date = rel_date;
	}

	public String getEnterprise() {
		 return this.enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getBrand() {
		 return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOrigin() {
		 return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDescription() {
		 return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getReject_des() {
		 return this.reject_des;
	}

	public void setReject_des(String reject_des) {
		this.reject_des = reject_des;
	}
	public String getMeasures() {
		 return this.measures;
	}

	public void setMeasures(String measures) {
		this.measures = measures;
	}
	public String getCategory() {
		 return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getMbrsort() {
		 return this.mbrsort;
	}

	public void setMbrsort(String mbrsort) {
		this.mbrsort = mbrsort;
	}

	public String getDocument() {
		 return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEditor() {
		 return this.editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getCategory_id() {
		 return this.category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "Alarm [alarm_id=" + alarm_id + ", countries=" + countries
				+ ", mechanism=" + mechanism + ", rel_date=" + rel_date
				+ ", enterprise=" + enterprise + ", brand=" + brand
				+ ", origin=" + origin + ", description=" + description
				+ ", reject_des=" + reject_des + ", measures=" + measures
				+ ", category=" + category + ", mbrsort=" + mbrsort
				+ ", document=" + document + ", editor=" + editor
				+ ", category_id=" + category_id + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Alarm){
			Alarm alarm = (Alarm)obj;
			return alarm.getAlarm_id().equals(this.alarm_id);
		}
		return super.equals(obj);
	}
   
}