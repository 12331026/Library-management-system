package com.bv.cn.base.common.taglib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.common.utils.SpringHelper;
import com.bv.cn.wsbase.base.model.Tareaarticle;
import com.bv.cn.wsbase.base.model.Tarticle;
import com.bv.cn.wsbase.base.model.Tshowarea;
import com.bv.cn.wsbase.base.service.TareaarticleService;

public class TarticleareaTag extends BodyTagSupport {
	private static final long serialVersionUID = 7146066254828416433L;
	protected Logger logger = Logger.getLogger(getClass());
	private TareaarticleService<Tareaarticle> tareaarticleService = SpringHelper
			.getBean("tareaarticleService", TareaarticleService.class);;

	private String target = "_blank";// 文章展示页面的目标frame
	private String includePage;// list页面
	private String areacode;// 显示区域编码
	private String formid;// formid

	public int doEndTag() {
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext
					.getRequest();
			// request.getParameterMap().put("areacode", areacode);
			pageContext.setAttribute("target", target);
			// pageContext.setAttribute("areacode", areacode);
			pageContext.setAttribute("formid", formid);
			areacode = StringUtils.trimToEmpty(areacode);
			String[] areacodeArr = areacode.split(",");
			String hql = "from " + Tareaarticle.class.getName() + " t where t."
					+ Tareaarticle.ALIAS_ISSHOW + " = '" + WSConstants.ISSHOW_YES
					+ "' and t." + Tareaarticle.ALIAS_ARTICLE + "."
					+ Tarticle.ALIAS_ISSHOW + " = '" + WSConstants.ISSHOW_YES
					+ "' ";
			if (areacodeArr.length > 0) {
				hql += " and t." + Tareaarticle.ALIAS_SHOWAREA + "."
						+ Tshowarea.ALIAS_AREACODE + " in (";
				for (String areacode : areacodeArr) {
					hql += "'" + areacode + "',";
				}
				hql = hql.substring(0, hql.length() - 1);
				hql += ")";
			}
			List<Tareaarticle> sublist = tareaarticleService.getListsByHql(hql,
					new Object[0]);
			request.setAttribute("sublist", sublist);
			pageContext.include("/wsbase/common/tag/" + includePage, true);
		} catch (Exception e) {
			logger.error("FormValFieldDef tag error!" + e.getMessage(), e);
		}
		return EVAL_PAGE;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIncludePage() {
		return includePage;
	}

	public void setIncludePage(String includePage) {
		this.includePage = includePage;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getFormid() {
		return formid;
	}

	public void setFormid(String formid) {
		this.formid = formid;
	}
	
	
	
}
