package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_laws")
public class Laws implements Serializable{
	private String laws_id; //法律编号;
	private String proof; //法律文号;
	private String laws_name; //法规名称;
	private String countries; //国别;
	private String department; //发布单位;
	private java.util.Date rel_date; //发布日期;
	private java.util.Date act_date; //实施日期;
	private String laws_state; //法规状态;
	private String document; //法律原文;
	private String category_id; //类别号;
	@PrimaryKeyAnnotation(primaryKey = "laws_id")
	public String getLaws_id() {
		 return this.laws_id;
	}

	public void setLaws_id(String laws_id) {
		this.laws_id = laws_id;
	}

	public String getProof() {
		 return this.proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public String getLaws_name() {
		 return this.laws_name;
	}

	public void setLaws_name(String laws_name) {
		this.laws_name = laws_name;
	}

	public String getCountries() {
		 return this.countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getDepartment() {
		 return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public java.util.Date getRel_date() {
		 return this.rel_date;
	}

	public void setRel_date(java.util.Date rel_date) {
		this.rel_date = rel_date;
	}

	public java.util.Date getAct_date() {
		 return this.act_date;
	}

	public void setAct_date(java.util.Date act_date) {
		this.act_date = act_date;
	}

	public String getLaws_state() {
		 return this.laws_state;
	}

	public void setLaws_state(String laws_state) {
		this.laws_state = laws_state;
	}

	public String getDocument() {
		 return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getCategory_id() {
		 return this.category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "Laws [laws_id=" + laws_id + ", proof=" + proof + ", laws_name="
				+ laws_name + ", countries=" + countries + ", department="
				+ department + ", rel_date=" + rel_date + ", act_date="
				+ act_date + ", laws_state=" + laws_state + ", document="
				+ document + ", category_id=" + category_id +  "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Laws){
			Laws law = (Laws)obj;
			return law.getLaws_id().equals(this.getLaws_id());
		}
		return super.equals(obj);
	}
	
	

}