package com.bv.cn.base.common.taglib;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bv.cn.base.common.utils.SpringHelper;
import com.bv.cn.wsbase.base.model.Tdict;
import com.bv.cn.wsbase.base.model.Tdictdetail;
import com.bv.cn.wsbase.base.service.TdictService;

public class Dropdown extends BodyTagSupport {

	private static final long serialVersionUID = -911564544366089106L;
	protected Logger logger = Logger.getLogger(getClass());
	protected TdictService<Tdict> tdictService = SpringHelper.getBean(
			"tdictService", TdictService.class);
	private JdbcTemplate jdbcTemplate = SpringHelper.getBean("jdbcTemplate",
			JdbcTemplate.class);
	private String type; // 类型：radio，checkbox，select 必须
	private String dictKey;// 必须
	private String name;// 必须
	private String id;// select 使用
	private String onChange;// select 使用
	private String value;// 必须
	private String multiple;// select 使用
	private String multiplecount;// select 使用
	private String defaultvalue;
	private String disabled;
	private String selectreadonly = "N";
	private String style;// select 使用

	// private String comefrom;// dict/sql
	// private String strSql;// 当comefrom 为 sql时， 查询本语句

	public int doEndTag() {
		try {
			String hql = "from " + Tdict.class.getName() + " t where t."
					+ Tdict.ALIAS_DICTCODE + " = ?";
			List<Tdictdetail> dictdetails = new ArrayList<Tdictdetail>();
			final Tdict dict = tdictService.getUniqueByHql(hql,
					new String[] { dictKey });
			if (dict.getSrctype().equals("dict")) {
				dictdetails = new ArrayList<Tdictdetail>(dict.getTdictdetails());
			} else if (dict.getSrctype().equals("sql")) {
				dictdetails = jdbcTemplate.query(StringUtils.trimToEmpty(dict
						.getSrcsql()),
						new ResultSetExtractor<List<Tdictdetail>>() {

							@Override
							public List<Tdictdetail> extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								List<Tdictdetail> dds = new ArrayList<Tdictdetail>();
								while (rs.next()) {
									Tdictdetail dd = new Tdictdetail();
									dd.setDetailcode(rs.getString(1));
									dd.setDetailname(rs.getString(2));
									dd.setTdict(dict);
									dds.add(dd);
								}
								return dds;
							}

						});
			}
			StringBuffer sb = new StringBuffer();
			boolean isValuable = false;
			boolean isDefaultable = false;
			if (!StringUtils.trimToEmpty(value).equals("")) {
				isValuable = true;
			}
			if (!StringUtils.trimToEmpty(defaultvalue).equals("")) {
				isDefaultable = true;
			}
			if ("radio".equals(type)) {
				// 单选
				for (Tdictdetail dd : dictdetails) {
					if ("N".equals(dd.getIsinuse())) {
						break;
					}
					String str = "<input type=\"radio\" name=\""
							+ StringUtils.trimToEmpty(name) + "\" value=\""
							+ StringUtils.trimToEmpty(dd.getDetailcode())
							+ "\"";
					if (isValuable
							&& StringUtils.trimToEmpty(value).equals(
									dd.getDetailcode())) {
						str += " checked=\"checked\"";
					} else if (isDefaultable
							&& StringUtils.trimToEmpty(defaultvalue).equals(
									dd.getDetailcode())) {
						str += " checked=\"checked\"";
					}
					if (!"".equals(StringUtils.trimToEmpty(disabled))) {
						str += " disabled=\"" + disabled + "\"";
					}
					if (!StringUtils.trimToEmpty(selectreadonly).equals("Y")
							&& !StringUtils.trimToEmpty(onChange).equals("")) {
						str += " onChange=\""
								+ StringUtils.trimToEmpty(onChange) + "\"";
						str += " onClick=\"this.blur();\"";
					}
					str += " />" + dd.getDetailname() + "\r\n";
					sb.append(str);
				}
			} else if ("checkbox".equals(type)) {
				// checkbox
				for (Tdictdetail dd : dictdetails) {
					if ("N".equals(dd.getIsinuse())) {
						break;
					}
					String str = "<input type=\"checkbox\" name=\""
							+ StringUtils.trimToEmpty(name) + "\" value=\""
							+ StringUtils.trimToEmpty(dd.getDetailcode())
							+ "\"";
					if (isValuable) {
						String[] values = StringUtils.trimToEmpty(value).split(
								",");
						for (String v : values) {
							if (StringUtils.trimToEmpty(v).equals(
									dd.getDetailcode())) {
								str += " checked=\"checked\"";
								break;
							}
						}
					} else if (isDefaultable) {
						String[] values = StringUtils.trimToEmpty(defaultvalue)
								.split(",");
						for (String v : values) {
							if (StringUtils.trimToEmpty(v).equals(
									dd.getDetailcode())) {
								str += " checked=\"checked\"";
								break;
							}
						}
					}
					str += " disabled=\"" + disabled + "\"";
					str += " />" + dd.getDetailname() + "\r\n";
					sb.append(str);
				}
			} else if ("select".equals(type)) {
				// select
				String str = "<select name=\"" + StringUtils.trimToEmpty(name)
						+ "\" ";
				if (!StringUtils.trimToEmpty(id).equals("")) {
					str += "id=\"" + StringUtils.trimToEmpty(id) + "\" ";
				}
				if (StringUtils.trimToEmpty(multiple).equals("true")) {
					str += " multiple=\"multiple\" ";
				}
				if (!StringUtils.trimToEmpty(multiplecount).equals("")) {
					str += " size=\"" + StringUtils.trimToEmpty(multiplecount)
							+ "\" ";
				}
				if (!StringUtils.trimToEmpty(style).equals("")) {
					str += " style=\"" + StringUtils.trimToEmpty(style) + "\"";
				}
				if (!StringUtils.trimToEmpty(selectreadonly).equals("Y")
						&& !StringUtils.trimToEmpty(onChange).equals("")) {
					str += " onChange=\"" + StringUtils.trimToEmpty(onChange)
							+ "\"";
				}
				if (StringUtils.trimToEmpty(selectreadonly).equals("Y")) {
					str += " onfocus=\"this.defaultIndex=this.selectedIndex;\" onChange=\"this.selectedIndex=this.defaultIndex\"";
				}
				str += " >\r\n";
				if (isValuable) {
					String optStr = "<option value=\"\">请选择</option>\r\n";
					str += optStr;
					for (Tdictdetail dd : dictdetails) {
						if ("N".equals(dd.getIsinuse())) {
							break;
						}
						String optStrContent = "<option ";
						String[] values = StringUtils.trimToEmpty(value).split(
								",");
						for (String v : values) {
							if (StringUtils.trimToEmpty(v).equals(
									dd.getDetailcode())) {
								optStrContent += "selected ";
								break;
							}
						}
						optStrContent += "value=\"" + dd.getDetailcode()
								+ "\">" + dd.getDetailname() + "</option>"
								+ "\r\n";
						str += optStrContent;
					}
				} else if (isDefaultable) {
					String optStr = "<option value=\"\">请选择</option>\r\n";
					str += optStr;
					for (Tdictdetail dd : dictdetails) {
						if ("N".equals(dd.getIsinuse())) {
							break;
						}
						String optStrContent = "<option ";
						String[] values = StringUtils.trimToEmpty(defaultvalue)
								.split(",");
						for (String v : values) {
							if (StringUtils.trimToEmpty(v).equals(
									dd.getDetailcode())) {
								optStrContent += "selected ";
								break;
							}
						}
						optStrContent += "value=\"" + dd.getDetailcode()
								+ "\">" + dd.getDetailname() + "</option>"
								+ "\r\n";
						str += optStrContent;
					}
				} else {
					String optStr = "<option selected value=\"\">请选择</option>\r\n";
					str += optStr;
					for (Tdictdetail dd : dictdetails) {
						if ("N".equals(dd.getIsinuse())) {
							break;
						}
						String optStrContent = "<option ";
						optStrContent += "value=\"" + dd.getDetailcode()
								+ "\">" + dd.getDetailname() + "</option>"
								+ "\r\n";
						str += optStrContent;
					}
				}
				str += " </select>\r\n";
				sb.append(str);
			}
			pageContext.getOut().println(sb.toString());
		} catch (Exception e) {
//			logger.error("dropdown tag error!");
			throw new RuntimeException(e);
		}
		return EVAL_PAGE;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDictKey() {
		return dictKey;
	}

	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMultiple() {
		return multiple;
	}

	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}

	public String getMultiplecount() {
		return multiplecount;
	}

	public void setMultiplecount(String multiplecount) {
		this.multiplecount = multiplecount;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSelectreadonly() {
		return selectreadonly;
	}

	public void setSelectreadonly(String selectreadonly) {
		this.selectreadonly = selectreadonly;
	}
}
