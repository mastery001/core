package org.web.framework.action.support;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.framework.ConfigLibrary;
import org.web.framework.action.ActionConfiguration;
import org.web.framework.action.ActionInvocation;
import org.web.framework.action.Result;
import org.web.framework.action.config.Config;
import org.web.framework.action.config.ResultConfig;
import org.web.servlet.ActionSupport;
import org.web.util.RegUtil;

import tool.mastery.core.StringUtil;

/**
 * 处理执行action所需要的操作
 * 
 * @author mastery
 * @Time 2015-4-11 下午8:57:27
 * 
 */
public class ActionResult implements Result {

	private ActionConfiguration ac;

	private HttpServletRequest request;
	private HttpServletResponse response;

	public ActionResult(ActionConfiguration ac, HttpServletRequest request,
			HttpServletResponse response) {
		this.ac = ac;
		this.request = request;
		this.response = response;
	}

	@Override
	public void execute(ActionInvocation paramActionInvocation)
			throws Exception {
		ActionSupport action = (ActionSupport) paramActionInvocation
				.getAction();
		if (action == null) {
			return;
		}
		String result = action.execute();
		Config config = this.ac.getConfigurationProvider().getConfig(
				action.getAction());
		List<ResultConfig> list = config.getResultConfig();
		for (int i = 0; i < list.size(); i++) {
			ResultConfig rc = list.get(i);
			if (result.equalsIgnoreCase(rc.getName())) {
				// 获得跳转路径类型
				String type = rc.getTypeName();
				// 获得跳转路径
				String dispatcherPath = rc.getDispatcherPath();
				dispatcherPath = process(dispatcherPath, action.getAction());
				if (!type.equalsIgnoreCase(ConfigLibrary.DEFAULT_RESULT_TYPE)) {
					if (!StringUtil.StringIsNull(dispatcherPath)) {
						response.sendRedirect(dispatcherPath);
					}
				} else {
					if (request.getAttribute("info") == null) {
						request.setAttribute("info",
								action.getResponseMessage());
					}
					dispatcherPath += action.getActionParameter();
					if (config.getActionConfig().isValidate_token()) {
						TokenInterceptor.getInstance().makeToken(request,
								action.getAction(), dispatcherPath);
					}
					request.getRequestDispatcher(dispatcherPath).forward(
							request, response);
				}
			}
		}
	}

	/**
	 * 处理跳转路径
	 * 
	 * @param dispatcherPath
	 * @param action
	 * @return
	 */
	private String process(String dispatcherPath, String action) {
		StringBuilder sb = new StringBuilder();
		String[] processAction = ActionHelper.processAction(action);
		char[] chs = dispatcherPath.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			String s = String.valueOf(chs[i]);
			if (RegUtil.isBraces(s)) {
				continue;
			}
			if (s.matches("\\d+")) {
				sb.append(processAction[Integer.parseInt(s) - 1]);
			} else {
				sb.append(s);
			}
		}
		return sb.toString();
	}

}
