package org.web.servlet;

import java.util.List;

import org.web.framework.action.ActionResultParam;

public abstract class ActionSupport implements Action {
	
	/**
	 * 用户的请求
	 */
	protected String action;

	private boolean haveParam;
	
	private final ActionResultParam actionResultParam = new ActionResultParam();

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public List<String> getResponseMessage() {
		return actionResultParam.getMessage();
	}
	
	/**
	 * 设置servlet的返回信息
	 * 
	 * @param responseMessage
	 */
	@Deprecated
	public void setResponseMessage(String responseMessage) {
		actionResultParam.addMessage(responseMessage);
	}
	
	/**
	 * 设置servlet的返回信息
	 * 
	 * @param responseMessage
	 */
	public void addMessage(String responseMessage) {
		actionResultParam.addMessage(responseMessage);
	}
	
	/**
	 * 获取action后?和后面的参数值
	 * @return
	 */
	public String getActionParameter() {
		return actionResultParam.toParamLayout();
	}
	
	/**
	 * 是否允许设置到result中
	 * @return
	 */
	public boolean haveRequestParam() {
		return this.haveParam;
	}
	
	protected void allowSendReuqstParam() {
		this.haveParam = true;
	}
	
	protected void setProperties(String key , String value) {
		if(haveRequestParam()) 
			actionResultParam.setProperties(key, value);
	}
	
	protected void clearProperties() {
		if(haveRequestParam()) 
			actionResultParam.clearProperties();
	}
	
}
