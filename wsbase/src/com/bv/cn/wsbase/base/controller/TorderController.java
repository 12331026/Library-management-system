/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2014
 */

package com.bv.cn.wsbase.base.controller;

import java.io.Writer;
import java.math.BigDecimal;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.consts.WSConstants;
import com.bv.cn.base.common.utils.GenericsUtils;
import com.bv.cn.base.controller.BaseActionException;
import com.bv.cn.base.conts.BvConstants;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.base.service.BvAppBaseService;
import com.bv.cn.wsbase.base.model.Torder;
import com.bv.cn.wsbase.base.model.Tshopping;
import com.bv.cn.wsbase.base.model.Tuser;
import com.bv.cn.wsbase.base.service.TorderService;
import com.bv.cn.wsbase.base.service.TuserService;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 * @email tigerchen2004@126.com
 * @module 订单管理
 */

@Controller
public class TorderController extends AS1BaseController<Torder> {
	@Resource
	private TorderService<Torder> torderService;
	@Resource
	private TuserService<Tuser> tuserService;

	@Override
	public BvAppBaseService<Torder> getBaseService() {
		return torderService;
	}

	public void setListPagePath() {
		super.setListPagePath("wsbase/Torder/Torder_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/Torder/Torder_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/Torder/Torder_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/Torder/Torder_form");
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
	protected void exeAfterEdit(Torder t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeAfterEdit(t, request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("front".equals(comefrom)) { // for frontend
			setEditPagePath("wsbase/Torder/Torder_edit_front");
			setFormPagePath("wsbase/Torder/Torder_form_front");
		} else {// backend
			setEditPagePath("wsbase/Torder/Torder_edit");
			setFormPagePath("wsbase/Torder/Torder_form");
		}
	}

	@Override
	protected void exeAfterSave(Torder t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		// TODO Auto-generated method stub
		super.exeAfterSave(t, request, response, sessionStatus, modelMap);
	}

	@Override
	protected void exeBeforeList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeList(request, response, sessionStatus, modelMap);
		String comefrom = StringUtils.trimToEmpty(request
				.getParameter("comefrom"));
		if ("front".equals(comefrom)) {// for front
			String ordertype = StringUtils.trimToEmpty(request
					.getParameter("ordertype"));
			String frontordertype = StringUtils.trimToEmpty(request
					.getParameter("frontordertype"));
			LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
					Constants.LOGONVO);
			String hql = "from " + clazzName + " t where 1=1 and t."
					+ Torder.ALIAS_ORDERBELONG + "." + Tuser.ALIAS_RESOURCEID
					+ " = '" + logonVO.getUserid() + "' ";
			String orderBy = " order by t." + Torder.ALIAS_SHOWORDER + " desc ";
			List<Object> params = new ArrayList<Object>();
			if (!ordertype.isEmpty()) {
				hql += " and t." + Torder.ALIAS_ORDERTYPE + " = '" + ordertype
						+ "' ";
			}
			// else if (!frontordertype.isEmpty()) {
			// hql += " and t." + Torder.ALIAS_ORDERTYPE + " = '"
			// + frontordertype + "' ";
			// }
			request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
			request.setAttribute(BvConstants.QUERY_PARAM, params);
			setListPagePath("wsbase/Torder/Torder_list_front");
			setListChildPagePath("wsbase/Torder/Torder_list_child_front");
		} else {// for back
			String status = StringUtils.trimToEmpty(request
					.getParameter("status"));
			String orderstatus = StringUtils.trimToEmpty(request
					.getParameter("orderstatus"));
			String vccode = StringUtils.trimToEmpty(request
					.getParameter("vccode"));
			String hql = "from " + clazzName + " t where 1=1 ";
			String orderBy = " order by t." + Torder.ALIAS_SHOWORDER + " desc ";
			List<Object> params = new ArrayList<Object>();
			hql += " and t." + Torder.ALIAS_ORDERTYPE + " = '"
					+ WSConstants.TORDER_ORDERTYPE_XGDD + "' ";
			if (!status.isEmpty()) {
				hql += " and t." + Torder.ALIAS_STATUS + " = '" + status + "' ";
			} else if(!orderstatus.isEmpty()) {
				hql += " and t." + Torder.ALIAS_STATUS + " = '" + orderstatus + "' ";
			}
			if (!vccode.isEmpty()) {
				hql += " and t." + Torder.ALIAS_ORDERBELONG + "."
						+ Tuser.ALIAS_VCCODE + " = '" + vccode + "' ";
			}
			request.setAttribute(BvConstants.QUERY_HQL, hql + orderBy);
			request.setAttribute(BvConstants.QUERY_PARAM, params);
			setListPagePath("wsbase/Torder/Torder_list");
			setListChildPagePath("wsbase/Torder/Torder_list_child");
		}
	}

	@Override
	protected void exeAfterList(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		List<Torder> list = (List<Torder>) request.getAttribute("sublist");
		for (Torder o : list) {
			Set<Tshopping> ss = o.getTshoppings();
			String detail = "";
			for (Tshopping s : ss) {
				if (s.getTgoods() != null) {
					detail += s.getTgoods().getGoodsname() + "*"
							+ s.getGoodsnum() + ";\r\n";
				}
			}
			o.setDetail(detail);
		}

		request.setAttribute("sublist", list);
	}

	@Override
	protected void exeBeforeSave(Torder t, HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		super.exeBeforeSave(t, request, response, sessionStatus, modelMap);
		if (null != t && !"".equals(StringUtils.trimToEmpty(t.getResourceid()))) {
			// for 更新
			Torder to = getBaseService().getEntityById(t.getResourceid());
			t.setTshoppings(new HashSet<Tshopping>(to.getTshoppings()));
		}
	}

	@RequestMapping(value = "prepay", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void prepay(HttpServletRequest request,
			HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap modelMap) throws Exception {
		JSONObject json = new JSONObject();
		try {
			LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
					Constants.LOGONVO);
			String resid = StringUtils.trimToEmpty(request
					.getParameter("resid"));
			String paymethod = StringUtils.trimToEmpty(request
					.getParameter("paymethod"));
			Torder t = getBaseService().getEntityById(resid);
			if (null != t) {
				if (t.getOrderamount().compareTo(new BigDecimal(0)) > 0) {

				} else {
					throw new BaseActionException("订单总金额为0！");
				}
				// 检查支付方式及支付金额
				//FIXME 支付方式需重新编写
//				if (!paymethod.isEmpty()) {
//					if (StringUtils.trimToEmpty(paymethod).equals(
//							WSConstants.TORDER_PAYMETHOD_GWB)) {
//						Tuser u = t.getOrderbelonguser();
//						if (u.getShopmoney().compareTo(t.getOrderamount()) >= 0) {
//							// pass
//						} else {
//							throw new BaseActionException("购物币不足扣订单总金额！");
//						}
//					} else if (StringUtils.trimToEmpty(paymethod).equals(
//							WSConstants.TORDER_PAYMETHOD_DZB)) {
//						Tuser u = t.getOrderbelonguser();
//						if (u.getElectron().compareTo(t.getOrderamount()) >= 0) {
//							// pass
//						} else {
//							throw new BaseActionException("电子币不足扣订单总金额！");
//						}
//					} else {
//						throw new BaseActionException("未知的支付方式！");
//					}
//				} else {
//					throw new BaseActionException("未知的支付方式！");
//				}
				// 检查订单状态
				if (null != t.getStatus()) {
					if (StringUtils.trimToEmpty(t.getStatus()).equals(
							WSConstants.TORDER_STATUS_SHOPPING)) {

					} else {
						throw new BaseActionException(
								"订单状态已经改变，请检查订单是否是在购物车的状态！");
					}
				} else {
					throw new BaseActionException("未知的订单状态，请联系管理员！");
				}
				// 检查订单类型
				if (null != t.getOrdertype()) {
					if (StringUtils.trimToEmpty(t.getOrdertype()).equals(
							WSConstants.TORDER_ORDERTYPE_GWC)) {

					} else {
						throw new BaseActionException(
								"订单类型已经改变，请检查订单类型是否是 购物车订单！");
					}
				} else {
					throw new BaseActionException("未知的订单类型，请联系管理员！");
				}
			} else {
				throw new BaseActionException("未找到相关订单!");
			}

			json.put(SUCCESS, true);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			json.put(SUCCESS, false);
			json.put(ERRORMSG, e.getMessage());
		} finally {
			Writer w = response.getWriter();
			json.write(w);
		}
	}

	@RequestMapping(value = "pay", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void pay(HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		JSONObject json = new JSONObject();
		try {
			LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
					Constants.LOGONVO);
			String resid = StringUtils.trimToEmpty(request
					.getParameter("resid"));
			String paymethod = StringUtils.trimToEmpty(request
					.getParameter("paymethod"));
			Torder t = getBaseService().getEntityById(resid);
			if (null != t) {
				// 检查支付方式及支付金额
				//FIXME 支付方式需重新编写
				/*if (!paymethod.isEmpty()) {
					if (StringUtils.trimToEmpty(paymethod).equals(
							WSConstants.TORDER_PAYMETHOD_GWB)) {
						Tuser u = t.getOrderbelonguser();
						if (u.getShopmoney().compareTo(t.getOrderamount()) >= 0) {
							// pass
							u.setShopmoney(u.getShopmoney().subtract(
									t.getOrderamount()));
							t.setPaymethod(paymethod);
							t.setStatus(WSConstants.TORDER_STATUS_PAYED);
							t.setOrdertype(WSConstants.TORDER_ORDERTYPE_XGDD);
							t.setBookdate(Calendar.getInstance().getTime());
							setBaseModel(t, Constants.TODO_UPDATE, request,
									Constants.EXEACTION_SAVE);
							tuserService.updateEntity(u);
							getBaseService().updateEntity(t);
						} else {
							throw new BaseActionException("购物币不足扣订单总金额！");
						}
					} else if (StringUtils.trimToEmpty(paymethod).equals(
							WSConstants.TORDER_PAYMETHOD_DZB)) {
						Tuser u = t.getOrderbelonguser();
						if (u.getElectron().compareTo(t.getOrderamount()) >= 0) {
							// pass
							u.setElectron(u.getElectron().subtract(
									t.getOrderamount()));
							t.setPaymethod(paymethod);
							t.setStatus(WSConstants.TORDER_STATUS_PAYED);
							t.setOrdertype(WSConstants.TORDER_ORDERTYPE_XGDD);
							t.setBookdate(Calendar.getInstance().getTime());
							setBaseModel(t, Constants.TODO_UPDATE, request,
									Constants.EXEACTION_SAVE);
							tuserService.updateEntity(u);
							getBaseService().updateEntity(t);
						} else {
							throw new BaseActionException("电子币不足扣订单总金额！");
						}
					} else {
						throw new BaseActionException("未知的支付方式！");
					}
				} else {
					throw new BaseActionException("未知的支付方式！");
				}*/
			} else {
				throw new BaseActionException("未找到相关订单!");
			}

			json.put(SUCCESS, true);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			json.put(SUCCESS, false);
			json.put(ERRORMSG, e.getMessage());
		} finally {
			Writer w = response.getWriter();
			json.write(w);
		}
	}

	@RequestMapping(value = "ship", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void ship(HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap modelMap) throws Exception {
		JSONObject json = new JSONObject();
		try {
			LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
					Constants.LOGONVO);
			String resid = StringUtils.trimToEmpty(request
					.getParameter("resid"));
			Torder t = getBaseService().getEntityById(resid);
			if (null != t) {
				// 检查订单状态
				if (null != t.getStatus()) {
					if (StringUtils.trimToEmpty(t.getStatus()).equals(
							WSConstants.TORDER_STATUS_PAYED)) {

					} else {
						throw new BaseActionException("订单状态不是已支付的状态！");
					}
				} else {
					throw new BaseActionException("未知的订单状态，请联系管理员！");
				}
				// 检查订单类型
				if (null != t.getOrdertype()) {
					if (StringUtils.trimToEmpty(t.getOrdertype()).equals(
							WSConstants.TORDER_ORDERTYPE_XGDD)) {

					} else {
						throw new BaseActionException("订单类型不是续购订单！");
					}
				} else {
					throw new BaseActionException("未知的订单类型，请联系管理员！");
				}
				setBaseModel(t, Constants.TODO_UPDATE, request,
						Constants.EXEACTION_SAVE);
				t.setStatus(WSConstants.TORDER_STATUS_SHIPPED);
				getBaseService().updateEntity(t);
			} else {
				throw new BaseActionException("未找到相关订单!");
			}

			json.put(SUCCESS, true);
		} catch (Exception e) {
			logger.error(e.toString(), e);
			json.put(SUCCESS, false);
			json.put(ERRORMSG, e.getMessage());
		} finally {
			Writer w = response.getWriter();
			json.write(w);
		}
	}

}
