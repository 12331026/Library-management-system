/*
 * Powered By [BvWeb Co.,Ltd]
 * Web Site: http://
 * 
 * Since 2012 
 */

package com.bv.cn.wsbase.menu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bv.cn.base.controller.BvBaseController;
import java.util.*;


import com.bv.cn.wsbase.menu.model.*;
import com.bv.cn.wsbase.menu.dao.*;
import com.bv.cn.wsbase.menu.dao.impl.*;
import com.bv.cn.wsbase.menu.service.*;
import com.bv.cn.wsbase.menu.service.impl.*;
import com.bv.cn.wsbase.menu.vo.query.*;

/**
 * @author Jim.chen
 * @version 1.0
 * @since 1.0
 */


@Controller
public class UmmenuitemController<Ummenuitem> extends BvBaseController<Ummenuitem> {
	
	public void setListPagePath() {
		super.setListPagePath("wsbase/ummenuitem/ummenuitem_list");
	}

	public void setListChildPagePath() {
		super.setListChildPagePath("wsbase/ummenuitem/ummenuitem_list_child");
	}

	public void setEditPagePath() {
		super.setEditPagePath("wsbase/ummenuitem/ummenuitem_edit");
	}

	public void setFormPagePath() {
		super.setFormPagePath("wsbase/ummenuitem/ummenuitem_form");
	}

	public void setDeletePagePath() {
		super.setDeletePagePath("redirect:list.crs");
	}
	
}
