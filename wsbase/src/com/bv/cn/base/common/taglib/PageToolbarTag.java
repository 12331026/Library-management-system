package com.bv.cn.base.common.taglib;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import com.bv.cn.base.common.config.WebHelper;
import com.bv.cn.base.common.taglib.bean.TagButtonBean;
import com.bv.cn.base.common.utils.SpringHelper;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.wsbase.menu.model.Ummenu;
import com.bv.cn.wsbase.menu.model.Ummenuitem;
import com.bv.cn.wsbase.menu.service.UmmenuService;
import com.bv.cn.wsbase.menu.service.UmmenuitemService;

public class PageToolbarTag extends BodyTagSupport {

	private static final long serialVersionUID = 1862729069010963800L;

	protected Logger logger = Logger.getLogger(getClass());

	private String pageType; // 页面类型
	private String menuCode; // 菜单代码
	private String postfixName = ""; // 页面标题后缀提示信息


	public int doEndTag() {
		HttpSession session = pageContext.getSession();
		LogonVO logonVO = WebHelper.getLogon(session);
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();

		try {

			UmmenuitemService<Ummenuitem> ummenuitemService = (UmmenuitemService) SpringHelper
					.getBean("ummenuitemService");
			UmmenuService<Ummenu> ummenuService = (UmmenuService) SpringHelper
					.getBean("ummenuService");
			Object[] buttons = ummenuitemService.queryMenuitems(
					logonVO.getUserid(), menuCode, pageType);
			String appType = request.getParameter("appType");
			String runFlow = request.getParameter("runFlow");

			if (runFlow == null || "".equals(runFlow)) {
				runFlow = "N";
			}
			String baseURL = request.getContextPath();

			List<TagButtonBean> tdButtonsList = new ArrayList<TagButtonBean>();
			if (buttons != null) {

				TagButtonBean tbBean = null;

				for (int i = 0; i < buttons.length; i++) {
					tbBean = new TagButtonBean();
					Ummenuitem item = (Ummenuitem) buttons[i];
					String target = item.getTarget();
					if (target == null)
						target = "this";

					String func = checkJSFunction(baseURL, item.getJsfunction());

					// 增加连接参数
					String paras = checkParams(item.getParamap());

					String id = item.getObjectid();
					String caption = item.getCaption();
					tbBean.setId("id_" + id);
					tbBean.setName(id);
					tbBean.setFunc(func);
					tbBean.setParas(paras);
					tbBean.setTarget(target);
					tbBean.setCaption(caption);
					if (item.getMemo() != null && !"".equals(item.getMemo())) {
						String classstyle[] = item.getMemo().split(",");
						tbBean.setButtionClass(classstyle[0]);
						if (classstyle.length > 1
								&& classstyle[1].equals("hide"))
							tbBean.setIsHide("Y");
					}

					if (func != null && func.length() > 0)
						tbBean.setIsOnAction("Y");
					tdButtonsList.add(tbBean);
				}
			}
			String mununame = "";
			try {
				mununame = ummenuService.getMenuByMenucode(menuCode)
						.getMenuname();
			} catch (Exception e) {

			}
				request.setAttribute("tdButtonsList", tdButtonsList);// 工具栏按钮集合
			request.setAttribute("mununame", mununame);// 菜单名称

			pageContext.include("/wsbase/common/tag/PageToolbarTag.jsp");
		} catch (Exception e) {
			logger.error("PageToolbarTag标签错误：" + e.getMessage(), e);
		}
		return EVAL_PAGE;
	}


	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getPostfixName() {
		return postfixName;
	}

	public void setPostfixName(String postfixName) {
		this.postfixName = postfixName;
	}
	
	protected String checkParams(String paras) {
		if (paras == null)
			paras = "";
		else {
			paras = paras.replaceAll("\"", "");
			paras = paras.replaceAll("\'", "");
		}
		return paras;
	}

	protected String checkJSFunction(String baseURL, String func) {
		if (func == null)
			func = "";
		else if (func.indexOf("/") >= 0 && func.indexOf("http") == -1)
			func = baseURL + func;
		else {
			int ix = func.indexOf("(");
			if (ix > 0)
				func = func.substring(0, ix);
		}
		return func;
	}

}
