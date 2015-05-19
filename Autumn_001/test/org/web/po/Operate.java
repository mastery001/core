package org.web.po;

import org.web.dao.annotation.ForeignKeyAnnotation;
import org.web.dao.annotation.PrimaryKeyAnnotation;
import org.web.dao.annotation.TableAnnotation;

@TableAnnotation(name = "t_operate")
public class Operate {
	private Integer log_id;
	private String u_id;
	private String createtime;
	private String log_level;
	private String log_msg;
	private String ip_address;
	private String u_name;
	
	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public Operate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operate(String u_id, String createtime, String log_level,
			String log_msg, String ip_address) {
		super();
		this.u_id = u_id;
		this.createtime = createtime;
		this.log_level = log_level;
		this.log_msg = log_msg;
		this.ip_address = ip_address;
	}

	@PrimaryKeyAnnotation(primaryKey = "log_id")
	public Integer getLog_id() {
		return this.log_id;
	}

	public void setLog_id(Integer log_id) {
		this.log_id = log_id;
	}

	@PrimaryKeyAnnotation(primaryKey = "u_id")
	@ForeignKeyAnnotation("u_id")
	public String getU_id() {
		return this.u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getLog_level() {
		return this.log_level;
	}

	public void setLog_level(String log_level) {
		this.log_level = log_level;
	}

	public String getLog_msg() {
		return this.log_msg;
	}

	public void setLog_msg(String log_msg) {
		this.log_msg = log_msg;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	@Override
	public String toString() {
		return "Operate [log_id=" + log_id + ", u_id=" + u_id + ", createtime="
				+ createtime + ", log_level=" + log_level + ", log_msg="
				+ log_msg + ", ip_address=" + ip_address + "]";
	}

}