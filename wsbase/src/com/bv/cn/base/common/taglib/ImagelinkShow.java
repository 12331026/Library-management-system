package com.bv.cn.base.common.taglib;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.bv.cn.base.common.utils.SpringHelper;
import com.bv.cn.wsbase.base.model.Timagelink;
import com.bv.cn.wsbase.base.service.TimagelinkService;

public class ImagelinkShow extends BodyTagSupport {

	private static final long serialVersionUID = 2781607453006912792L;
	protected Logger logger = Logger.getLogger(getClass());
	private TimagelinkService<Timagelink> timagelinkService = SpringHelper
			.getBean("timagelinkService", TimagelinkService.class);
	private String imageid;
	private String basepath;
	private String align;
	private String width;
	private String height;
	private String alt;
	private String emptyshow;
	private boolean isshow = true;

	public int doEndTag() {
		try {
			StringBuffer sb = new StringBuffer();
			imageid = StringUtils.trimToEmpty(imageid);
			Timagelink t = timagelinkService.getEntityById(imageid);
			if (null != t) {
				sb.append("<div id=\"div" + imageid + "\" ");
				if (isshow) {
					sb.append(" style=\"display:block\" ");
				} else {
					sb.append(" style=\"display:none\" ");
				}
				sb.append(" >");
				sb.append("<img src=\"" + basepath
						+ "/timagelink/show.bvw?resourceid=" + imageid
						+ "\" id=\"" + imageid + "\" ");
				if (!StringUtils.trimToEmpty(align).isEmpty()) {
					sb.append(" align=\"" + align + "\" ");
				}
				if (!StringUtils.trimToEmpty(width).isEmpty()) {
					sb.append(" width=\"" + width + "\" ");
				}
				if (!StringUtils.trimToEmpty(height).isEmpty()) {
					sb.append(" height=\"" + height + "\" ");
				}
				if (!StringUtils.trimToEmpty(alt).isEmpty()) {
					sb.append(" alt=\"" + alt + "\" ");
				}
				sb.append(" />");// img
				sb.append("</div>");// div
			} else {
				sb.append(emptyshow);
			}

			pageContext.getOut().println(sb.toString());
		} catch (Exception e) {
			logger.error("ImagelinkShow tag error!" + e.getMessage(), e);
		}
		return EVAL_PAGE;
	}

	public String getImageid() {
		return imageid;
	}

	public void setImageid(String imageid) {
		this.imageid = imageid;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getEmptyshow() {
		return emptyshow;
	}

	public void setEmptyshow(String emptyshow) {
		this.emptyshow = emptyshow;
	}

	public boolean isIsshow() {
		return isshow;
	}

	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}
	
	
}
