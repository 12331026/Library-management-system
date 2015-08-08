/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bv.cn.base.controller.BvBaseController;
import java.util.*;


import com.bv.cn.wsbase.user.model.*;
import com.bv.cn.wsbase.user.dao.*;
import com.bv.cn.wsbase.user.dao.impl.*;
import com.bv.cn.wsbase.user.service.*;
import com.bv.cn.wsbase.user.service.impl.*;
import com.bv.cn.wsbase.user.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */


@Controller
public class UmorgtypeController<Umorgtype> extends BvBaseController<Umorgtype> {
	
	public void setListPagePath() {
		super.setListPagePath("wsbase/umorgtype/umorgtype_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/umorgtype/umorgtype_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/umorgtype/umorgtype_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/umorgtype/umorgtype_form");
	}

	public void setDeletePagePath() {
		super.setDeletePagePath("redirect:list.crs");
	}
	
}
