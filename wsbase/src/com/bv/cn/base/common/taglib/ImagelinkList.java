package com.bv.cn.base.common.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.bv.cn.base.common.taglib.bean.ImagelinkListBean;

public class ImagelinkList extends BodyTagSupport {
	private static final long serialVersionUID = 7797969664899229138L;
	protected Logger logger = Logger.getLogger(getClass());
	private String divid;
	private String arrange = "column";// column/row
	private String isModelless = "true";
	private String imagetype;
	private String modulebelong;
	private String basepath;
	private String requseturi;
	private String resourceids;
	private String isMultiple = "false";
	private String writebackDivid;
	private String itemWidth = "120px";
	private String itemHeight = "120px";
	private String itemArrange = "column";// column/row
	private String fieldId = "imageid";// column/row

	public int doEndTag() {
		try {
			HttpServletRequest request = (HttpServletRequest) pageContext
					.getRequest();
			ImagelinkListBean bean = new ImagelinkListBean();
			bean.setDivid(divid);
			bean.setArrange(arrange);
			bean.setIsModelless(isModelless);
			bean.setImagetype(imagetype);
			bean.setModulebelong(modulebelong);
			bean.setBasepath(basepath);
			bean.setRequseturi(requseturi);
			bean.setResourceids(resourceids);
			bean.setIsMultiple(isMultiple);
			bean.setWritebackDivid(writebackDivid);
			bean.setItemWidth(itemWidth);
			bean.setItemHeight(itemHeight);
			bean.setItemArrange(itemArrange);
			bean.setFieldId(fieldId);

			StringBuffer sb = new StringBuffer();
			sb.append("<div id=\"" + divid + "\" >");
			sb.append("<table cellspacing=\"0\" border=\"0\" >");
			if (StringUtils.trimToEmpty(arrange).equals("column")) {
				sb.append("<tr>");
				sb.append("<td>");
				sb
						.append("<bvweb-wsbase:dropdown type=\"select\" dictKey=\"IMAGETYPE\" "
								+ "name=\""
								+ divid
								+ "imagetype\" id=\""
								+ divid
								+ "imagetype\""
								+ " value=\""
								+ imagetype + "\" />");
				sb.append("</td>");

				sb.append("<td>");
				sb
						.append("<bvweb-wsbase:dropdown type=\"select\" dictKey=\"MODULEBELONG\" "
								+ "name=\""
								+ divid
								+ "modulebelong\" id=\""
								+ divid
								+ "modulebelong\""
								+ " value=\""
								+ modulebelong + "\" />");
				sb.append("</td>");

				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "basepath\" id=\"" + divid + "basepath\" value=\""
						+ basepath + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "requseturi\" id=\"" + divid
						+ "requseturi\" value=\"" + requseturi + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "isModelless\" id=\"" + divid
						+ "isModelless\" value=\"" + isModelless + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "resourceids\" id=\"" + divid
						+ "resourceids\" value=\"" + resourceids + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "isMultiple\" id=\"" + divid
						+ "isMultiple\" value=\"" + isMultiple + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "itemWidth\" id=\"" + divid + "itemWidth\" value=\""
						+ itemWidth + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "itemHeight\" id=\"" + divid
						+ "itemHeight\" value=\"" + itemHeight + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "itemArrange\" id=\"" + divid
						+ "itemArrange\" value=\"" + itemArrange + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "fieldId\" id=\"" + divid + "fieldId\" value=\""
						+ fieldId + "\" />");

				sb.append("<td>");
				sb.append("<input type=\"button\" name=\"" + divid
						+ "Btn\" id=\"" + divid
						+ "Btn\" value=\"Ñ¡Ôñ\" onclick=\"showImagelinkList('"
						+ isModelless + "','" + divid + "');\" />");
				sb.append("</td>");
				sb.append("</tr>");
			} else if (StringUtils.trimToEmpty(arrange).equals("row")) {
				sb.append("<tr>");
				sb.append("<td>");
				sb
						.append("<bvweb-wsbase:dropdown type=\"select\" dictKey=\"IMAGETYPE\" "
								+ "name=\""
								+ divid
								+ "imagetype\" id=\""
								+ divid
								+ "imagetype\""
								+ " value=\""
								+ imagetype + "\" />");
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td>");
				sb
						.append("<bvweb-wsbase:dropdown type=\"select\" dictKey=\"MODULEBELONG\" "
								+ "name=\""
								+ divid
								+ "modulebelong\" id=\""
								+ divid
								+ "modulebelong\""
								+ " value=\""
								+ modulebelong + "\" />");

				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "basepath\" id=\"" + divid + "basepath\" value=\""
						+ basepath + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "requseturi\" id=\"" + divid
						+ "requseturi\" value=\"" + requseturi + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "isModelless\" id=\"" + divid
						+ "isModelless\" value=\"" + isModelless + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "resourceids\" id=\"" + divid
						+ "resourceids\" value=\"" + resourceids + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "isMultiple\" id=\"" + divid
						+ "isMultiple\" value=\"" + isMultiple + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "itemWidth\" id=\"" + divid + "itemWidth\" value=\""
						+ itemWidth + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "itemHeight\" id=\"" + divid
						+ "itemHeight\" value=\"" + itemHeight + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "itemArrange\" id=\"" + divid
						+ "itemArrange\" value=\"" + itemArrange + "\" />");
				sb.append("<input type=\"hidden\" name=\"" + divid
						+ "fieldId\" id=\"" + divid + "fieldId\" value=\""
						+ fieldId + "\" />");
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td>");
				sb.append("<input type=\"button\" name=\"" + divid
						+ "Btn\" id=\"" + divid
						+ "Btn\" value=\"Ñ¡Ôñ\" onclick=\"showImagelinkList('"
						+ divid + "');\" />");
				sb.append("</td>");
				sb.append("</tr>");
			}

			sb.append("</table>");
			sb.append("</div>");// div
			request.setAttribute("_imagelinkbean", bean);
			pageContext.include("/wsbase/common/tag/ImagelinkList.jsp", true);
			// pageContext.getOut().println(sb.toString());
		} catch (Exception e) {
			logger.error("ImagelinkList tag error!" + e.getMessage(), e);
		}
		return EVAL_PAGE;
	}

	public String getDivid() {
		return divid;
	}

	public void setDivid(String divid) {
		this.divid = divid;
	}

	public String getArrange() {
		return arrange;
	}

	public void setArrange(String arrange) {
		this.arrange = arrange;
	}

	public String getIsModelless() {
		return isModelless;
	}

	public void setIsModelless(String isModelless) {
		this.isModelless = isModelless;
	}

	public String getImagetype() {
		return imagetype;
	}

	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}

	public String getModulebelong() {
		return modulebelong;
	}

	public void setModulebelong(String modulebelong) {
		this.modulebelong = modulebelong;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getRequseturi() {
		return requseturi;
	}

	public void setRequseturi(String requseturi) {
		this.requseturi = requseturi;
	}

	public String getResourceids() {
		return resourceids;
	}

	public void setResourceids(String resourceids) {
		this.resourceids = resourceids;
	}

	public String getIsMultiple() {
		return isMultiple;
	}

	public void setIsMultiple(String isMultiple) {
		this.isMultiple = isMultiple;
	}

	public String getWritebackDivid() {
		return writebackDivid;
	}

	public void setWritebackDivid(String writebackDivid) {
		this.writebackDivid = writebackDivid;
	}

	public String getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}

	public String getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}

	public String getItemArrange() {
		return itemArrange;
	}

	public void setItemArrange(String itemArrange) {
		this.itemArrange = itemArrange;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

}
