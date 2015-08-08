package com.bv.cn.base.common.taglib;

import java.util.Set;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.bv.cn.base.common.utils.SpringHelper;
import com.bv.cn.wsbase.base.model.Tdict;
import com.bv.cn.wsbase.base.model.Tdictdetail;
import com.bv.cn.wsbase.base.service.TdictService;

public class BvDictcodetoname extends BodyTagSupport {
	private static final long serialVersionUID = -911564544366089106L;
	protected Logger logger = Logger.getLogger(getClass());
	protected TdictService<Tdict> tdictService = SpringHelper.getBean(
			"tdictService", TdictService.class);
	private String dictKey;
	private String detailcode;
	private String emptyshow;

	public int doEndTag() {
		try {
			String hql = "from " + Tdict.class.getName() + " t where t."
					+ Tdict.ALIAS_DICTCODE + " = ?";
			Tdict dict = tdictService.getUniqueByHql(hql,
					new String[] { dictKey });
			Set<Tdictdetail> dictdetails = dict.getTdictdetails();
			StringBuffer sb = new StringBuffer();
			boolean hasName = false;
			for (Tdictdetail dd : dictdetails) {
				if (dd.getDetailcode().equals(
						StringUtils.trimToEmpty(detailcode))) {
					sb.append(StringUtils.trimToEmpty(dd.getDetailname()));
					hasName = true;
					break;
				}
			}
			if (!hasName) {
				sb.append(StringUtils.trimToEmpty(emptyshow));
			}
			pageContext.getOut().println(sb.toString());
		} catch (Exception e) {
			logger.error("BvDictcodetoname tag error!" + e.getMessage(), e);
		}
		return EVAL_PAGE;
	}

	public String getDictKey() {
		return dictKey;
	}

	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}

	public String getDetailcode() {
		return detailcode;
	}

	public void setDetailcode(String detailcode) {
		this.detailcode = detailcode;
	}

	public String getEmptyshow() {
		return emptyshow;
	}

	public void setEmptyshow(String emptyshow) {
		this.emptyshow = emptyshow;
	}

}
