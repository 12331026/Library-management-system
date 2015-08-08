/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.io.Writer;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Tgoods;
import com.bv.cn.wsbase.base.model.Torder;
import com.bv.cn.wsbase.base.model.Tshopping;
import com.bv.cn.wsbase.base.model.Tuser;
import com.bv.cn.wsbase.base.service.TgoodsService;
import com.bv.cn.wsbase.base.service.TorderService;
import com.bv.cn.wsbase.base.service.TshoppingService;
import com.bv.cn.wsbase.base.service.TuserService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 商品管理
 */

@Controller
public class TgoodsController extends AS1BaseController<Tgoods> {
	@Resource
	private TgoodsService<Tgoods> tgoodsService;
	@Resource
	private TorderService<Torder> torderService;
	@Resource
	private TshoppingService<Tshopping> tshoppingService;
	@Resource
	private TuserService<Tuser> tsuerService;
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public BvAppBaseService<Tgoods> getBaseService() {
		return tgoodsService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Tgoods/Tgoods_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Tgoods/Tgoods_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Tgoods/Tgoods_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Tgoods/Tgoods_form");
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

	@Override
	protected String _getSaveForwardPath(HttpServletRequest request,
			String resourceid, String useType, ModelMap modelMap) {
		String strPath = "";
		StringBuffer strBuf = new StringBuffer("");
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		try {
			String editUrl = "/"
					+ GenericsUtils.getGenericClass(super.getClass())
							.getSimpleName().toLowerCase() + "/edit."
					+ Constants.URL_PATTERN;
			strPath = editUrl + "?todo=show&resourceid=" + resourceid;
			strPath += "&comefrom=" + comefrom + "&beforeaction=save";
			strBuf.append(strPath);
		} catch (Exception exp) {
			this.logger.error(exp.getMessage());
		}
		return strBuf.toString();
	}

	@Override
	protected void exeAfterEdit(Tgoods t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("front".equals(comefrom)) { // for frontend
			setEditPagePath("wsbase/Tgoods/Tgoods_edit_front");
			setFormPagePath("wsbase/Tgoods/Tgoods_form_front");
		} else {// backend
			setEditPagePath("wsbase/Tgoods/Tgoods_edit");
			setFormPagePath("wsbase/Tgoods/Tgoods_form");
		}
	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		// request.setAttribute("comefrom", comefrom);
		if ("front".equals(comefrom)) {// for front
			setListPagePath("wsbase/Tgoods/Tgoods_list_front");
			setListChildPagePath("wsbase/Tgoods/Tgoods_list_child_front");
			String hql = "from " + clazzName + " t where t."
					+ Tgoods.ALIAS_FLG_DELETED + " = 'N' ";
			String orderBy = " order by t." + Tgoods.ALIAS_CREATEDATE
					+ " desc ";
			List<String> params = new ArrayList<String>();
			request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
			request.setAttribute(BvConstants.QUERY_PARAM, params);

			LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
					Constants.LOGONVO);
			String hql2 = "from " + Torder.class.getName() + " t where 1=1 ";
			String orderBy2 = " order by t." + Torder.ALIAS_SHOWORDER
					+ " desc ";
			hql2 += " and t." + Torder.ALIAS_ORDERBELONG + "."
					+ Tuser.ALIAS_RESOURCEID + " = '" + logonVO.getUserid()
					+ "' and t." + Torder.ALIAS_ORDERTYPE + " = '"
					+ WSConstants.TORDER_ORDERTYPE_GWC + "' ";
			Torder shoppingtorders = torderService.getUniqueByHql(hql2
					+ orderBy2, new Object[0]);
			if (null != shoppingtorders) {
				request.setAttribute("shoppingtorders", shoppingtorders);
			}
		} else {
			setListPagePath("wsbase/Tgoods/Tgoods_list");
			setListChildPagePath("wsbase/Tgoods/Tgoods_list_child");
			String hql = "from " + clazzName + " t where t."
					+ Tgoods.ALIAS_FLG_DELETED + " = 'N' ";
			String orderBy = " order by t." + Tgoods.ALIAS_CREATEDATE
					+ " desc ";
			List<String> params = new ArrayList<String>();
			request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
			request.setAttribute(BvConstants.QUERY_PARAM, params);
		}
	}

	@Override
	protected void exeBeforeSave(Tgoods t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		if (null != t && !"".equals(StringUtils.trimToEmpty(t.getResourceid()))) {
			// for 更新
			Tgoods tg = getBaseService().getEntityById(t.getResourceid());
			t.setTshoppings(new HashSet<Tshopping>(tg.getTshoppings()));
		}
	}

	@RequestMapping(value = "addintoshpping", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void addintoshpping(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		JSONObject json = new JSONObject();
		try {
			LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
					Constants.LOGONVO);
			String goodsid = StringUtils.trimToEmpty(request
					.getParameter("goodsid"));
			String goodsnum = StringUtils.trimToEmpty(request
					.getParameter("goodsnum"));
			Tgoods goods = getBaseService().getEntityById(goodsid);
			if (null != goods) {
				String hql = "from " + Torder.class.getName() + " t where t."
						+ Torder.ALIAS_ORDERTYPE + " = '"
						+ WSConstants.TORDER_ORDERTYPE_GWC + "' and t."
						+ Torder.ALIAS_ORDERBELONG + "."
						+ Tuser.ALIAS_RESOURCEID + " = '" + logonVO.getUserid()
						+ "'";
				Torder shoppingOrder = torderService.getUniqueByHql(hql,
						new Object[0]);
				if (null != shoppingOrder) {
					setBaseModel(shoppingOrder, Constants.TODO_UPDATE, request,
							Constants.EXEACTION_SAVE);
					Set<Tshopping> shoppings = shoppingOrder.getTshoppings();

					Tshopping shopping = new Tshopping();
					shopping.setGoodsnum(Integer.parseInt(goodsnum));
					shopping.setTgoods(goods);
					shopping.setTorder(shoppingOrder);
					shopping = tshoppingService.saveEntity(shopping);
					shoppings.add(shopping);

					BigDecimal bdOrderAmount = countOrderAmount(shoppingOrder);
					logger.info("countOrderAmount bdOrderAmount="
							+ bdOrderAmount);
					shoppingOrder.setOrderamount(bdOrderAmount);
					shoppingOrder.setBookdate(Calendar.getInstance().getTime());
					torderService.updateEntity(shoppingOrder);

					goods.getTshoppings().add(shopping);
					tgoodsService.updateEntity(goods);
				} else {
					shoppingOrder = new Torder();
					setBaseModel(shoppingOrder, Constants.TODO_CREATE, request,
							Constants.EXEACTION_SAVE);
					shoppingOrder.setStatus(WSConstants.TORDER_STATUS_SHOPPING);
					Tuser u = tsuerService.getEntityById(logonVO.getUserid());
					shoppingOrder.setOrderbelonguser(u);
					shoppingOrder
							.setPaymethod(WSConstants.TORDER_PAYMETHOD_GWB);
					shoppingOrder
							.setOrdertype(WSConstants.TORDER_ORDERTYPE_GWC);
					if (null == shoppingOrder.getShoworder()) {
						String sql = "select max(t.showorder) from "
								+ Torder.TABLE_ALIAS + " t";
						Integer maxShoworder = jdbcTemplate.query(sql,
								new ResultSetExtractor<Integer>() {

									@Override
									public Integer extractData(ResultSet rs)
											throws SQLException,
											DataAccessException {
										if (rs.next()) {
											return rs.getInt(1);
										}
										return 0;
									}

								});
						shoppingOrder.setShoworder(maxShoworder + 1);
					}
					shoppingOrder.setBookdate(Calendar.getInstance().getTime());
					shoppingOrder = torderService.saveEntity(shoppingOrder);

					Tshopping shopping = new Tshopping();
					shopping.setGoodsnum(Integer.parseInt(goodsnum));
					shopping.setTgoods(goods);
					shopping.setTorder(shoppingOrder);
					shopping = tshoppingService.saveEntity(shopping);
					shoppingOrder.getTshoppings().add(shopping);

					BigDecimal bdOrderAmount = countOrderAmount(shoppingOrder);
					logger.info("countOrderAmount bdOrderAmount="
							+ bdOrderAmount);
					shoppingOrder.setOrderamount(bdOrderAmount);
					torderService.updateEntity(shoppingOrder);

					goods.getTshoppings().add(shopping);
					tgoodsService.updateEntity(goods);
					u.getTorders().add(shoppingOrder);
				}
				json.put("success", true);
			} else {
				json.put("success", false);
				json.put("msg", "所选物品不存在");
			}
			Writer w = response.getWriter();
			json.write(w);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			json.put("success", false);
			json.put("msg", e.toString());
		}
	}

	public static BigDecimal countOrderAmount(Torder order) {
		BigDecimal rtnVal = new BigDecimal(0);
		if (null != order.getTshoppings()) {
			for (Tshopping s : order.getTshoppings()) {
				Tgoods g = s.getTgoods();
				if (null != g.getMenberprice() && null != s.getGoodsnum()) {
					BigDecimal bdAmount = g.getMenberprice().multiply(
							new BigDecimal(s.getGoodsnum()));
					rtnVal = rtnVal.add(bdAmount);
				}
			}
		}
		return rtnVal;
	}

	@RequestMapping(value = "undercarriage", method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public final void undercarriage(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		String resids = StringUtils.trimToEmpty(request.getParameter("resids"));
		JSONObject json = new JSONObject();
		try {
			String[] idArr = resids.split(",");
			for (String resid : idArr) {
				if (!StringUtils.trimToEmpty(resid).isEmpty()) {
					Tgoods t = getBaseService().getEntityById(
							StringUtils.trimToEmpty(resid));
					t.setFlgDeleted(Constants.FLGDELETED_YES);
					getBaseService().updateEntity(t);
				}
			}
			json.put("success", "true");
		} catch (Exception e) {
			logger.error("下架商品出错!", e);
			json.put("success", "false");
			throw e;
		} finally {
			json.write(response.getWriter());
		}
	}
}
