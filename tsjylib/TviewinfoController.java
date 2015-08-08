/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.bvstatics.base.BvFsTemplateFactory;
import com.bv.cn.bvstatics.define.model.Tviewinfo;
import com.bv.cn.bvstatics.filter.BvAccessFilter;
import com.bv.cn.bvstatics.service.iface.BvViewinfoStaticsServiceIface;
import com.bv.cn.bvstatics.service.impl.BvViewinfoStaticsServiceImpl;
import com.bv.cn.fs.define.FsDefineUtils;
import com.bv.cn.fs.define.model.FsCritierial;
import com.bv.cn.fs.define.model.FsCritierialUnit;
import com.bv.cn.fs.define.model.FsMetadata;
import com.bv.cn.fs.define.model.TableMeta;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 查看信息
 */

@Controller
public class TviewinfoController extends AS1BaseController<Tviewinfo> {
	protected static BvViewinfoStaticsServiceIface<Tviewinfo> bvViewinfoStaticsService;

	@Override
	public BvAppBaseService<Tviewinfo> getBaseService() {
		return null;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tviewinfo/Tviewinfo_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tviewinfo/Tviewinfo_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tviewinfo/Tviewinfo_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tviewinfo/Tviewinfo_form");
	}

	@Override
	protected void exeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		try {
			if (null == bvViewinfoStaticsService) {
				FsMetadata fsMetadata = FsDefineUtils.getFsMetadata();
				TableMeta tmeta = fsMetadata.getTableMetaMap().get("004");

				bvViewinfoStaticsService = new BvViewinfoStaticsServiceImpl(
						BvFsTemplateFactory.getBvViewinfoStaticsTempalte(tmeta));
			}
			int pageSize = getPageSize(request);
			int pageIndex = getPageIndex(request);

			String viewuser = request.getParameter("viewuser");
			String belongmodule = request.getParameter("belongmodule");

			FsCritierial<Tviewinfo> fcr = new FsCritierial<Tviewinfo>();
			if (!StringUtils.trimToEmpty(viewuser).isEmpty()) {
				FsCritierialUnit unit = new FsCritierialUnit();
				unit.setPropertyName("viewuser");
				unit.setCritierial(FsCritierial.EQ);
				unit.setValueStr(viewuser);
				fcr.add(unit);
			}
			if (!StringUtils.trimToEmpty(belongmodule).isEmpty()) {
				FsCritierialUnit unit2 = new FsCritierialUnit();
				unit2.setPropertyName("belongmodule");
				unit2.setCritierial(FsCritierial.EQ);
				unit2.setValueStr(belongmodule);
				fcr.add(unit2);
			}
			List<Tviewinfo> list = bvViewinfoStaticsService.select(fcr);

			Collections.sort(list, new Comparator<Tviewinfo>() {

				@Override
				public int compare(Tviewinfo o1, Tviewinfo o2) {
					return o2.getViewcnt().compareTo(o1.getViewcnt());
				}

			});

			List<Tviewinfo> sublist = new ArrayList<Tviewinfo>(pageSize);
			for (int i = pageSize * (pageIndex - 1); i < Math.min(pageSize
					* pageIndex, list.size()); i++) {
				sublist.add(list.get(i));
			}

			request.setAttribute("totalRecord", String.valueOf(list.size()));
			request.setAttribute("sublist", sublist);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
			throw exp;
		}
	}

	@Override
	protected String _getDeleteForwardPath(HttpServletRequest request,
			ModelMap modelMap) {
		String strPath = "";
		StringBuffer strBuf = new StringBuffer("");
		try {
			String editUrl = "redirect:/"
					+ GenericsUtils.getGenericClass(super.getClass())
							.getSimpleName().toLowerCase() + "/list."
					+ Constants.URL_PATTERN;

			strPath = editUrl;
			strBuf.append(strPath);
			logger.info(strBuf.toString());
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
		}

		return strBuf.toString();
	}
}
