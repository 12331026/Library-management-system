package com.bv.cn.base.common.taglib;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.bv.cn.base.common.utils.SpringHelper;
import com.bv.cn.wsbase.base.model.Tformvalidate;
import com.bv.cn.wsbase.base.model.Tmodule;
import com.bv.cn.wsbase.base.service.TmoduleService;

public class FormValFieldDef extends BodyTagSupport {
	private static final long serialVersionUID = -911564544366089106L;
	protected Logger logger = Logger.getLogger(getClass());
	// private TformvalidateService<Tformvalidate> tformvalidateService =
	// SpringHelper
	// .getBean("tformvalidateService", TformvalidateService.class);
	private TmoduleService<Tmodule> tmoduleService = SpringHelper.getBean(
			"tmoduleService", TmoduleService.class);
	private String modulecode;
	private String exceptfieldname;

	public int doEndTag() {
		try {
			String hql = "from " + Tmodule.class.getName() + " t where t."
					+ Tmodule.ALIAS_MODULECODE + " = ?";
			Tmodule m = tmoduleService.getUniqueByHql(hql,
					new String[] { modulecode });
			Set<Tformvalidate> fvs = m.getTformvalidates();
			String[] exceptfields = exceptfieldname.split(",");
			StringBuffer sb = new StringBuffer();
			sb.append("<script type=\"text/javascript\">\r\n");
			sb.append("\tvar valFieldDefArr = '['+\r\n");
			if (null != fvs && fvs.size() > 0) {
				int i = 0;
				for (Tformvalidate fv : fvs) {
					i++;
					boolean isExcept = false;
					for (String exceptfield : exceptfields) {
						if (StringUtils.trimToEmpty(exceptfield).equals(
								StringUtils.trimToEmpty(fv.getFieldname()))) {
							isExcept = true;
							break;
						}
					}
					if (isExcept) {
						continue;
					}
					if (i == fvs.size()) {
						String str = "\t\t'{\"name\":\""
								+ StringUtils.trimToEmpty(fv.getFieldname())
								+ "\",\"id\":\""
								+ StringUtils.trimToEmpty(fv.getFieldid())
								+ "\",\"type\":\""
								+ StringUtils.trimToEmpty(fv.getFieldtype())
								+ "\",\"fieldchinesename\":\""
								+ StringUtils.trimToEmpty(fv.getFieldchinesename())
								+ "\",\"maxlen\":\""
								+ fv.getFieldmaxlen()
								+ "\",\"minlen\":\""
								+ fv.getFieldminlen()
								+ "\",\"required\":\""
								+ StringUtils.trimToEmpty(fv
										.getFieldisrequired())
								+ "\",\"pattern\":\""
								+ StringUtils.trimToEmpty(fv.getFieldpattern())
								+ "\"}'+\r\n";
						sb.append(str);
					} else {
						String str = "\t\t'{\"name\":\""
								+ StringUtils.trimToEmpty(fv.getFieldname())
								+ "\",\"id\":\""
								+ StringUtils.trimToEmpty(fv.getFieldid())
								+ "\",\"type\":\""
								+ StringUtils.trimToEmpty(fv.getFieldtype())
								+ "\",\"fieldchinesename\":\""
								+ StringUtils.trimToEmpty(fv.getFieldchinesename())
								+ "\",\"maxlen\":\""
								+ fv.getFieldmaxlen()
								+ "\",\"minlen\":\""
								+ fv.getFieldminlen()
								+ "\",\"required\":\""
								+ StringUtils.trimToEmpty(fv
										.getFieldisrequired())
								+ "\",\"pattern\":\""
								+ StringUtils.trimToEmpty(fv.getFieldpattern())
								+ "\"},'+\r\n";
						sb.append(str);
					}
				}
			}
			sb.append("\t']';\r\n</script>\r\n");
			pageContext.getOut().println(sb.toString());
		} catch (Exception e) {
			logger.error("FormValFieldDef tag error!" + e.getMessage(), e);
		}
		return EVAL_PAGE;
	}

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

	public String getExceptfieldname() {
		return exceptfieldname;
	}

	public void setExceptfieldname(String exceptfieldname) {
		this.exceptfieldname = exceptfieldname;
	}

}
