package org.web.po;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_audit")
public class Audit{
	private Integer audit_id; //审核信息ID;
	private String u_id; //用户id;
	private String audit_info; //审核信息;

	@PrimaryKeyAnnotation(primaryKey="audit_id")
	public Integer getAudit_id() {
		 return this.audit_id;
	}

	public void setAudit_id(Integer audit_id) {
		this.audit_id = audit_id;
	}

	@ForeignKeyAnnotation("u_id")
	public String getU_id() {
		 return this.u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}


	public String getAudit_info() {
		 return this.audit_info;
	}

	public void setAudit_info(String audit_info) {
		this.audit_info = audit_info;
	}

	@Override
	public String toString() {
		return "Audit [audit_id=" + audit_id + ", u_id=" + u_id + ", audit_info=" + audit_info + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Audit) {
			Audit a = (Audit) obj;
			if(a.audit_id != null) {
				return a.audit_id.equals(this.audit_id);
			}
		}
		return false;
	}
	
	

}