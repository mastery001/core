package org.web.po;

import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name="t_admin")
public class Admin {
	
	private String u_id;
	private String password;
	@PrimaryKeyAnnotation(primaryKey="u_id")
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [u_id=" + u_id + ", password=" + password + "]";
	}
	
	
}
