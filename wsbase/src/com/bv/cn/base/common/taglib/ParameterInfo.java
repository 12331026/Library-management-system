package com.bv.cn.base.common.taglib;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bv.cn.base.common.consts.WSConstants;

public class ParameterInfo  extends BodyTagSupport {
	
	protected static Log logger = LogFactory.getLog(ParameterInfo.class);//日志记录
	private static final long serialVersionUID = -8328224438621302896L;
	private String infoAttribute = WSConstants.PARAM_MAP_DEFAULT;

	@Override
	public int doEndTag() throws JspException {
		ServletRequest request = pageContext.getRequest();
		Map searchMap = request.getParameterMap();
		StringBuffer buf = new StringBuffer();
		String prefixStr = "<input type=\"hidden\" name=\"prefixName\" id=\"prefixName\" value=\"prefixValue\" />";
		if (null != searchMap) {
			Set<String> keySet = searchMap.keySet();
			for (String key : keySet) {
				Object obj = searchMap.get(key);
				//ignore newlink parameter
				if("newlink".equalsIgnoreCase(key)) {
					continue;
				}
				if (obj instanceof String[]) {
					String[] arrvalue = (String[]) obj;
					String value = "";
					for (String tempvalue : arrvalue) {
						value += tempvalue + ",";
					}
					if (!"".equals(value)
							&& value.lastIndexOf(",") == value.length()-1) {
						value = value.substring(0, value.length() - 1);
					}
					// buf.append(prefixStr.replaceAll("prefixName", key)
					// .replaceAll("prefixValue", value)
					// + "\n");
					buf.append(prefixStr.replaceAll("prefixName", key)
							.replaceAll("prefixValue", value)
							+ "\n");
				} else if (obj instanceof String) {
					buf.append(prefixStr.replaceAll("prefixName", key)
							.replaceAll("prefixValue", (String) obj)
							+ "\n");
				}
			}
			//System.out.println(buf.toString());
		}
		JspWriter out = pageContext.getOut();
		try {
			out.print(buf.toString());
		} catch (IOException ex) {
			logger.error(ex);
		}
		return EVAL_PAGE;
	}

	public String getInfoAttribute() {
		return infoAttribute;
	}

	public void setInfoAttribute(String infoAttribute) {
		this.infoAttribute = infoAttribute;
	}
}
