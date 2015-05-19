package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name="t_laboratory")
public class Laboratory implements Serializable{
	private String lab_id; //实验室编号;
	private String lab_name; //实验室名称;
	private String address; //地址;
	private String functionary; //负责人;
	private String contact; //联系方式;
	@PrimaryKeyAnnotation(primaryKey = "lab_id")
	public String getLab_id() {
		 return this.lab_id;
	}

	public void setLab_id(String lab_id) {
		this.lab_id = lab_id;
	}

	public String getLab_name() {
		 return this.lab_name;
	}

	public void setLab_name(String lab_name) {
		this.lab_name = lab_name;
	}

	public String getAddress() {
		 return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFunctionary() {
		 return this.functionary;
	}

	public void setFunctionary(String functionary) {
		this.functionary = functionary;
	}

	public String getContact() {
		 return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Laboratory [lab_id=" + lab_id + ", lab_name=" + lab_name
				+ ", address=" + address + ", functionary=" + functionary
				+ ", contact=" + contact +"]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Laboratory){
			Laboratory laboratory = (Laboratory)obj;
			return laboratory.getLab_id().equals(this.lab_id);
		  }
		return super.equals(obj);
	}

	
}