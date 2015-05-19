package org.web.po;

import java.io.Serializable;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_userpower")
public class UserPower implements Serializable{
	private String u_id; //用户编号;
	private String p_id; //权限号;

	@PrimaryKeyAnnotation(primaryKey = "u_id")
	@ForeignKeyAnnotation("u_id")
	public String getU_id() {
		 return this.u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	@PrimaryKeyAnnotation(primaryKey = "p_id")
	@ForeignKeyAnnotation("p_id")
	public String getP_id() {
		 return this.p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	@Override
	public String toString() {
		return "UserPower [u_id=" + u_id + ", p_id=" + p_id + "]";
	}

}