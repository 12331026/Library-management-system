package com.bv.cn.wsbase.base.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.exception.BvServiceException;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.report.AbstractJasperReporterExporter;
import com.bv.cn.base.report.JasperReportExporter;
import com.bv.cn.base.service.BvBaseServiceException;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module ����ģ��
 */

@Controller
public class BvReportController {

	protected Log logger = LogFactory.getLog(getClass());
	@Resource
	private JdbcTemplate jdbcTemplate;

	protected String baseURL = "";

	@RequestMapping(value = "reporttest1", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void reporttest1(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			// response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			// PrintWriter out = response.getWriter();
			OutputStream os = response.getOutputStream();

			try {
				String doctype = StringUtils.trimToEmpty(request
						.getParameter("doctype"));
				// String mpid = StringUtils.trimToEmpty(request
				// .getParameter("mpid"));
				String mpidstart = StringUtils.trimToEmpty(request
						.getParameter("mpidstart"));
				String mpidend = StringUtils.trimToEmpty(request
						.getParameter("mpidend"));
				logger.info("doctype=" + doctype);
				// logger.info("mpid=" + mpid);
				logger.info("mpidstart=" + mpidstart);
				logger.info("mpidend=" + mpidend);
				baseURL = request.getScheme() + "://" + request.getServerName()
						+ ":" + request.getServerPort()
						+ request.getContextPath() + "/";
				ServletContext context = request.getSession()
						.getServletContext();
				final File reportFile = new File(context
						.getRealPath("/reports/t1-v.jrxml"));
				if (!reportFile.exists()) {
					throw new BvServiceException(
							"File /reports/t1-v.jrxml not found. The report design must be compiled first.");
				}
				// logger.info(System
				// .getProperty("javax.xml.parsers.SAXParserFactory"));

				JasperReportExporter exporter = new AbstractJasperReporterExporter(
						Integer.parseInt(doctype), response) {

					@Override
					protected InputStream getJrxmlInputStream() {
						try {
							return new FileInputStream(reportFile);
						} catch (FileNotFoundException e) {
							logger.error(
									"get file [" + reportFile + "] error!", e);
							throw new BvServiceException("get file ["
									+ reportFile + "] error!", e);
						}
					}

				};

				// JasperReport jasperReport = JasperCompileManager
				// .compileReport(new FileInputStream(reportFile));
				Map<String, Object> params = new HashMap<String, Object>();

				String zheng = baseURL + "/images/1/zheng.png";
				String fan = baseURL + "/images/1/fan.png";
				String i1 = baseURL + "/images/1/1.png";
				String i2 = baseURL + "/images/1/2.png";
				String i3 = baseURL + "/images/1/3.png";
				String i4 = baseURL + "/images/1/4.png";
				// Map imageMap = new HashMap();
				// request.getSession().setAttribute("IMAGES_MAP", imageMap);
				// imageMap.put("zheng", zheng);
				// imageMap.put("fan", fan);
				// logger.info("imageFilePath=" + imageFilePath);
//				InputStream zhengis = new FileInputStream(new File(context
//						.getRealPath("/images/1/zheng.png")));
				params.put("zheng", zheng);
				params.put("fan", fan);
				params.put("i1", i1);
				params.put("i2", i2);
				params.put("i3", i3);
				params.put("i4", i4);
				// params.put("pmpid", mpid);
				params.put("mpidstart", mpidstart);
				params.put("mpidend", mpidend);
				// JasperPrint jasperPrint = JasperFillManager.fillReport(
				// jasperReport, params, jdbcTemplate.getDataSource()
				// .getConnection());
				// HtmlExporter exporter = new HtmlExporter();
				//
				// exporter.setExporterInput(new
				// SimpleExporterInput(jasperPrint));
				// SimpleHtmlExporterOutput output = new
				// SimpleHtmlExporterOutput(
				// out);
				// exporter.setExporterOutput(output);
				// exporter.exportReport();
				exporter.export(params, jdbcTemplate.getDataSource()
						.getConnection(), response.getOutputStream());
			} catch (JRException e) {
				PrintWriter out = new PrintWriter(os);
				out.println("<html>");
				out.println("<head>");
				out
						.println("<title>JasperReports - Web Application Sample</title>");
				out
						.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
				out.println("</head>");

				out.println("<body bgcolor=\"white\">");

				out
						.println("<span class=\"bnew\">JasperReports encountered this error :</span>");
				out.println("<pre>");

				e.printStackTrace(out);

				out.println("</pre>");

				out.println("</body>");
				out.println("</html>");
			}

		} catch (BvBaseServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error(e.toString());
			throw new BaseActionException("���?���?", e);
		}
	}
}
