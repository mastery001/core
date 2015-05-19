package org.web.po;

import java.io.Serializable;
import java.util.Date;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_typical")
public class Typical implements Serializable{
	private String lab_id; //实验室编号;
	private Integer t_id; //案例编号;
	private String title; //标题;
	private String introduction; //简介;
	private String author; //作者;
	private String document; //文档;
	private Date doc_date;//案例录入时间
    
	@ForeignKeyAnnotation("lab_id")
	public String getLab_id() {
		 return this.lab_id;
	}

	public void setLab_id(String lab_id) {
		this.lab_id = lab_id;
	}

	@PrimaryKeyAnnotation(primaryKey = "t_id")
	public Integer getT_id() {
		 return this.t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}

	public Date getDoc_date() {
		return doc_date;
	}

	public void setDoc_date(Date doc_date) {
		this.doc_date = doc_date;
	}

	public String getTitle() {
		 return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		 return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAuthor() {
		 return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDocument() {
		 return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Typical){
			Typical typical = (Typical)obj;
			if(typical.getT_id()!=null){
			return typical.getT_id().equals(this.t_id);
			}
		}
		return super.equals(obj);
	}
   

	@Override
	public String toString() {
		return "Typical [lab_id=" + lab_id + ", t_id=" + t_id + ", title="
				+ title + ", introduction=" + introduction + ", author="
				+ author + ", document=" + document + "]";
	}

}