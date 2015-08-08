package com.bv.cn.base.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.model.BaseModel;
import com.bv.cn.base.model.BassCreateModle;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.wsbase.base.model.Tudcommon;

public abstract class BvBaseController<T> extends CrudBaseController<T> {


	protected void setBaseModel(Object object, String method,
			HttpServletRequest request, String exeAction) {
		HttpSession session = request.getSession();
		LogonVO logonVO = (LogonVO) session.getAttribute("LOGONVO");
		String userId = logonVO.getUserid();
		String userName = logonVO.getUserName();

		try {
			if (object instanceof BaseModel) {
				if (Constants.TODO_CREATE.equals(method)) {
					PropertyUtils.setProperty(object, "flgDeleted",
							Constants.FLGDELETED_NO);
					PropertyUtils.setProperty(object, "creater", userId);
					PropertyUtils.setProperty(object, "createusername",
							userName);
					PropertyUtils.setProperty(object, "createdate", new Date());
				} else if (Constants.TODO_UPDATE.equals(method)) {
					PropertyUtils.setProperty(object, "updater", userId);
					PropertyUtils.setProperty(object, "updateusername",
							userName);
					PropertyUtils.setProperty(object, "updatedate", new Date());
				}
			} else if (object instanceof BassCreateModle) {
				if (Constants.TODO_CREATE.equals(method)) {
					PropertyUtils.setProperty(object, "flgDeleted",
							Constants.FLGDELETED_NO);
					PropertyUtils.setProperty(object, "creater", userId);
					PropertyUtils.setProperty(object, "createusername",
							userName);
					PropertyUtils.setProperty(object, "createdate", new Date());
				}
			}
		} catch (IllegalAccessException e) {
			this.logger.error("执行的方法无法访问指定类、字段、方法或构造方法的定义.");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			this.logger.error("目标异常.");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			this.logger.error("无法找到某一特定方法.");
			e.printStackTrace();
		}

	}

	protected void setSubBaseModel(Object object, String method,
			HttpServletRequest request, String exeAction) {
		HttpSession session = request.getSession();
		LogonVO logonVO = (LogonVO) session.getAttribute("LOGONVO");
		String userId = logonVO.getUserid();
		String userName = logonVO.getUserName();

		try {
			if (Constants.TODO_CREATE.equals(method)) {
				PropertyUtils.setProperty(object, "flgDeleted",
						Constants.FLGDELETED_NO);
				PropertyUtils.setProperty(object, "creater", userId);
				PropertyUtils.setProperty(object, "createusername", userName);
				PropertyUtils.setProperty(object, "createdate", new Date());
			} else if (Constants.TODO_UPDATE.equals(method)) {
				PropertyUtils.setProperty(object, "updater", userId);
				PropertyUtils.setProperty(object, "updateusername", userName);
				PropertyUtils.setProperty(object, "updatedate", new Date());
			}
		} catch (IllegalAccessException e) {
			this.logger.error("执行的方法无法访问指定类、字段、方法或构造方法的定义.");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			this.logger.error("目标异常.");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			this.logger.error("无法找到某一特定方法.");
			e.printStackTrace();
		}
	}

}
