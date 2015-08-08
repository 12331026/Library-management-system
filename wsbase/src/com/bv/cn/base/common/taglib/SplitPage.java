package com.bv.cn.base.common.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bv.cn.base.common.config.WSBaseConfig;

public class SplitPage extends BodyTagSupport {
	 protected Log logger = LogFactory.getLog(getClass());
	  private static final long serialVersionUID = 1L;
	  private static final String FORM_NAME = "FORM_SPLIT_PAGE_000";
	  private String formName;
	  private int pageIndex = 1;
	  private int pageSize = 0;
	  private int totalRecord;
	  private boolean isUserForm;

	  public String getFormName()
	  {
	    return this.formName;
	  }

	  public void setFormName(String formName) {
	    this.formName = formName;
	  }

	  public int getPageSize() {
	    return this.pageSize;
	  }

	  public void setPageSize(int pageSize) {
	    this.pageSize = pageSize;
	  }

	  public int doStartTag() {
	    if ((this.formName == null) || (this.formName.length() == 0)) {
	      this.isUserForm = false;
	      this.formName = "FORM_SPLIT_PAGE_000";
	    }

	    HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();

	    this.pageIndex = convert2Int(request.getParameter("pageIndex"));
	    this.totalRecord = convert2Int(request.getAttribute("totalRecord"));

	    int tempSize = convert2Int(request.getAttribute("pageSize"));
	    if (tempSize != 0)
	      this.pageSize = tempSize;

	    if (this.pageSize == 0)
	      this.pageSize = Integer.parseInt(WSBaseConfig.getProperty("PAGE_SIZE","15"));

	    if (this.pageSize == 0)
	      this.pageSize = 18;

	    if (this.pageIndex == 0)
	      this.pageIndex = 1;

	    return 1;
	  }

	  private int convert2Int(Object obj)
	  {
	    int result = 0;
	    if (obj instanceof Integer) {
	      result = ((Integer)obj).intValue();
	    }
	    else if ((obj != null) && (obj.toString().length() > 0))
	      try {
	        result = Integer.parseInt(obj.toString());
	      } catch (Exception e) {
	        e.printStackTrace();
	      }


	    return result;
	  }

	  public int doEndTag()
	  {
	    JspWriter out = this.pageContext.getOut();

	    if (this.totalRecord <= this.pageSize) {
	      return 0;
	    }

	    int pageCount = this.totalRecord / this.pageSize;

	    if (this.totalRecord % this.pageSize > 0)
	      ++pageCount;

	    if (this.totalRecord < this.pageIndex * this.pageSize) {
	      this.pageIndex = pageCount;
	    }

	    StringBuffer buf = new StringBuffer();
	    if (!(this.isUserForm)) {
	      buf.append("\n<form name=\"").append(this.formName).append("\" id=\"").append(this.formName).append("\" method=\"post\">");
	      buf.append("\n   <input type=\"hidden\" name=\"pageIndex\" value=\"").append(this.pageIndex).append("\">");
	      buf.append("\n   <input type=\"hidden\" name=\"pageSize\" value=\"").append(this.pageSize).append("\">");
	      buf.append("\n</form>\n\n");
	    } else {
	      buf.append("\n   <input type=\"hidden\" name=\"pageIndex\" value=\"").append(this.pageIndex).append("\">");
	      buf.append("\n   <input type=\"hidden\" name=\"pageSize\" value=\"").append(this.pageSize).append("\">");
	    }

	    if (this.pageIndex == 1) {
	      buf.append("<div align=\"right\" class='FormFont'>");
	      buf.append("共有").append(this.totalRecord).append("条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	      buf.append("<a href=\"javascript:show(").append(this.pageIndex + 1).append(")\">下页</a> &nbsp;");
	      buf.append("<a href=\"javascript:show(").append(pageCount).append(")\">尾页</a>");
	      buf.append("&nbsp;&nbsp;&nbsp;输入页码：<input type=\"text\" id=\"pageItem\" size=\"4\" maxlength=\"5\" class=\"TextStyle\"onkeydown=\"if(event.keyCode==0xD) go()\">");
	      buf.append("<a href=\"javascript:go()\">跳转</a>&nbsp;&nbsp;&nbsp;");
	      buf.append("&nbsp;第").append(this.pageIndex).append("页/共").append(pageCount).append("页<p/>");
	      buf.append("</div>");
	    }
	    else if (this.pageIndex == pageCount) {
	      buf.append("<div align=\"right\" class='FormFont'>");
	      buf.append("共有").append(this.totalRecord).append("条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	      buf.append("<a href=\"javascript:show(1)\">首页</a>&nbsp;");
	      buf.append("<a href=\"javascript:show(").append(this.pageIndex - 1).append(")\">上页</a>");
	      buf.append("&nbsp;&nbsp;&nbsp;输入页码：<input type=\"text\" id=\"pageItem\" size=\"4\" maxlength=\"5\" class=\"TextStyle\"onkeydown=\"if(event.keyCode==0xD) go()\">");
	      buf.append("<a  href=\"javascript:go()\">跳转</a>&nbsp;&nbsp;&nbsp;");
	      buf.append("&nbsp;第").append(this.pageIndex).append("页/共").append(pageCount).append("页<p/>");
	      buf.append("</div>");
	    }
	    else {
	      buf.append("<div align=\"right\" class='FormFont'>");
	      buf.append("共有").append(this.totalRecord).append("条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	      buf.append("<a href=\"javascript:show(1)\">首页</a>&nbsp;");
	      buf.append("<a href=\"javascript:show(").append(this.pageIndex - 1).append(")\">上页</a>&nbsp;");
	      buf.append("<a href=\"javascript:show(").append(this.pageIndex + 1).append(")\">下页</a>&nbsp;");
	      buf.append("<a href=\"javascript:show(").append(pageCount).append(")\">尾页</a>");
	      buf.append("&nbsp;&nbsp;&nbsp;输入页码：<input type=\"text\" id=\"pageItem\" size=\"4\" maxlength=\"5\" class=\"TextStyle\" onkeydown=\"if(event.keyCode==0xD) go()\">");
	      buf.append("<a href=\"javascript:go()\">跳转</a>&nbsp;&nbsp;&nbsp;");
	      buf.append("第").append(this.pageIndex).append("页/共").append(pageCount).append("页<p/>");
	      buf.append("</div>");
	    }

	    buf.append("\n<script language=\"javascript\">\n");
	    buf.append("\nvar parentUrl = String(this.location);  //父窗口的地址");
	    buf.append("\nvar tmp;");
	    buf.append("\nvar index;");
	    buf.append("\nindex=parentUrl.indexOf(\"?\");");
	    buf.append("\nif(index<0) parentUrl=parentUrl+\"?1=1\";");
	    buf.append("\ntmp = parentUrl.split(\"&pageIndex=\");");
	    buf.append("\nparentUrl = tmp[0];");

	    buf.append("\nfunction show(input){  ");
	    buf.append("\nif(!checkAllTextValid(document.all(\"").append(this.formName).append("\")))return");
	    buf.append("\nif (isNumberInt(input) && parseInt(input) > 0){");
	    buf.append("\n   if (document.all(\"").append(this.formName).append("\") != null) {");
	    buf.append("\n  ").append(this.formName).append(".action = parentUrl + \"&pageIndex=\"+input;    ");
	    buf.append("\n  ").append(this.formName).append(".submit();");
	    buf.append("\n }");
	    buf.append("\n else");
	    buf.append("\n   this.location = parentUrl + \"&pageIndex=\"+input;");

	    buf.append("\n }");
	    buf.append("\n else{");
	    buf.append("\n  if (document.all(\"").append(this.formName).append("\") != null) {");
	    buf.append("\n       ").append(this.formName).append(".action = parentUrl  ;");
	    buf.append("\n       ").append(this.formName).append(".submit();");
	    buf.append("\n  }");
	    buf.append("\n  else");
	    buf.append(" \n        this.location = parentUrl;");
	    buf.append("\n }");
	    buf.append("\n}");

	    buf.append("\n function isNumberInt(inputString){");
	    buf.append("\n     if(/^[0-9]+$/.test(inputString)){");
	    buf.append("\n      return true;");
	    buf.append("\n    }");
	    buf.append("\n    else{");
	    buf.append("\n      return false;");
	    buf.append("\n   }");
	    buf.append("\n}");

	    buf.append("\nfunction go(){");
	    buf.append("\nif(!checkAllTextValid(document.all(\"").append(this.formName).append("\")))return");
	    buf.append("\n var input = document.getElementById(\"pageItem\").value;");

	    buf.append("\n var pageNum = parseInt(\"").append(pageCount).append("\");");
	    buf.append("\n var pageIndex =parseInt(\"").append(this.pageIndex).append("\");");

	    buf.append("\n if (input>pageNum){");
	    buf.append("\n   alert(\"输入的页数超过总页数！\");");
	    buf.append("\n   document.getElementById(\"pageItem\").value=\"\";");
	    buf.append("\n   return;");
	    buf.append("\n }");

	    buf.append("\n if (input<1){");
	    buf.append("\n   alert(\"输入的页数不能小于1！\");");
	    buf.append("\n   document.getElementById(\"pageItem\").value=\"\";");
	    buf.append("\n   return;");
	    buf.append("\n }");

	    buf.append("\n if (isNumberInt(input)){");
	    buf.append("\nif (document.all(\"").append(this.formName).append("\") != null) {");
	    buf.append("\n    ").append(this.formName).append(".action =  parentUrl + \"&pageIndex=\"+input;");
	    buf.append("\n    ").append(this.formName).append(".submit();");
	    buf.append("\n }");
	    buf.append("\n else");
	    buf.append("\n  this.location = parentUrl + \"&pageIndex=\"+input");
	    buf.append("\n  }");
	    buf.append("\n  else{");
	    buf.append("\n   document.getElementById(\"pageItem\").value=\"\";");
	    buf.append("\n   alert(\"请输入一个整数！\")");
	    buf.append("\n   return");
	    buf.append("\n  }");
	    buf.append("\n }");

	    buf.append("\nfunction keydown(){");
	    buf.append("\n\tvar keycode = event.keyCode ;");
	    buf.append("\n\tif(keycode==13)");
	    buf.append("\n\t\tgo();");
	    buf.append("\n\t}");

	    buf.append("\n </script>");
	    try
	    {
	      out.println(buf.toString());
	    } catch (IOException e) {
	      this.logger.error("分页标签错误：" + e.getMessage(), e);
	    }
	    return 6;
	  }

	  public static void setTotalRecord(HttpServletRequest request, long totalRecord) {
	    request.setAttribute("totalRecord", totalRecord);
	  }
}
