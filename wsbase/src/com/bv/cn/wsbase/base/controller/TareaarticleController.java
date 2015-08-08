/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Tareaarticle;
import com.bv.cn.wsbase.base.model.Tarticle;
import com.bv.cn.wsbase.base.model.Tshowarea;
import com.bv.cn.wsbase.base.service.TareaarticleService;
import com.bv.cn.wsbase.base.service.TarticleService;
import com.bv.cn.wsbase.base.service.TshowareaService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 区域文章关系
 */

@Controller
public class TareaarticleController extends AS1BaseController<Tareaarticle> {
	@Resource
	private TareaarticleService<Tareaarticle> tareaarticleService;
	@Resource
	private TshowareaService<Tshowarea> tshowareaService;
	@Resource
	private TarticleService<Tarticle> tarticleService;

	@Override
	public BvAppBaseService<Tareaarticle> getBaseService() {
		return tareaarticleService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tareaarticle/Tareaarticle_list");
	}

	public void setListChildPagePath() {
		super
				.setListChildPagePath("wsbase/Tareaarticle/Tareaarticle_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tareaarticle/Tareaarticle_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tareaarticle/Tareaarticle_form");
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

	@RequestMapping(value = "add", method = { RequestMethod.GET })
	public final void add(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String articleid = StringUtils.trimToEmpty(request
				.getParameter("articleid"));
		String showareaid = StringUtils.trimToEmpty(request
				.getParameter("showareaid"));
		JSONObject json = new JSONObject();
		try {
			Tareaarticle aa = new Tareaarticle();
			aa.setIsshow(WSConstants.ISSHOW_YES);
			Tshowarea sa = tshowareaService.getEntityById(showareaid);
			Tarticle a = tarticleService.getEntityById(articleid);
			aa.setTarticle(a);
			aa.setTshowarea(sa);
			sa.getTareaarticles().add(aa);
			a.getTareaarticles().add(aa);
			tareaarticleService.saveEntity(aa);
			json.put(SUCCESS, "true");
		} catch (Exception e) {
			logger.error("", e);
			json.put(SUCCESS, "false");
			json.put(ERRORMSG, e.getMessage());
		} finally {
			json.write(response.getWriter());
		}
	}

	@RequestMapping(value = "del", method = { RequestMethod.GET })
	public final void del(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String articleid = StringUtils.trimToEmpty(request
				.getParameter("articleid"));
		String showareaid = StringUtils.trimToEmpty(request
				.getParameter("showareaid"));
		JSONObject json = new JSONObject();
		try {
			String hql = "from " + Tareaarticle.class.getName() + " t where t."
					+ Tareaarticle.ALIAS_ARTICLE + "."
					+ Tarticle.ALIAS_RESOURCEID + " = ? and t."
					+ Tareaarticle.ALIAS_SHOWAREA + "."
					+ Tshowarea.ALIAS_RESOURCEID + " = ? ";
			Tareaarticle aa = tareaarticleService.getUniqueByHql(hql,
					new String[] { articleid, showareaid });
			if (null != aa) {
				tareaarticleService.delete(aa);
			} else {
				throw new BaseActionException("未知的文章区域关系。");
			}
			json.put(SUCCESS, "true");
		} catch (Exception e) {
			logger.error("", e);
			json.put(SUCCESS, "false");
			json.put(ERRORMSG, e.getMessage());
		} finally {
			json.write(response.getWriter());
		}
	}

	@RequestMapping(value = "changeisshow", method = { RequestMethod.GET })
	public final void changeisshow(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String resid = StringUtils.trimToEmpty(request.getParameter("resid"));
		String pvalue = StringUtils.trimToEmpty(request.getParameter("pvalue"));
		JSONObject json = new JSONObject();
		try {
			if (!pvalue.isEmpty()) {
				Tareaarticle aa = tareaarticleService.getEntityById(resid);
				if (null != aa) {
					aa.setIsshow(pvalue);
					tareaarticleService.updateEntity(aa);
				} else {
					throw new BaseActionException("找不到相关的的文章区域关系。");
				}
			} else {
				throw new BaseActionException("未知的更新状态.");
			}
			json.put(SUCCESS, "true");
		} catch (Exception e) {
			logger.error("", e);
			json.put(SUCCESS, "false");
			json.put(ERRORMSG, e.getMessage());
		} finally {
			json.write(response.getWriter());
		}
	}
}
