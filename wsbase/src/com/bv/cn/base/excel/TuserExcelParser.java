package com.bv.cn.base.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.read.biff.BiffException;

import org.apache.commons.lang.StringUtils;

import com.bv.cn.base.common.consts.Constants;
import com.bv.cn.base.common.exception.BvServiceException;
import com.bv.cn.base.security.model.LogonVO;
import com.bv.cn.wsbase.base.model.Tuser;

public class TuserExcelParser extends CommonExcelParser<Tuser> {
	protected HttpServletRequest request;

	public TuserExcelParser(InputStream is, ItemModel rmodel, String sheetName,
			HttpServletRequest request) throws IOException, BiffException {
		super(is, rmodel, sheetName);
		this.request = request;
	}

	@Override
	protected void afterDoProcess(Sheet sheet, Integer lastestRow,
			List<Tuser> datalist) {
		LogonVO logonVO = (LogonVO) request.getSession().getAttribute(
				Constants.LOGONVO);
		
		if (datalist.size() > 1) {
			Collections.sort(datalist, new Comparator<Tuser>() {

				@Override
				public int compare(Tuser o1, Tuser o2) {
					return StringUtils.trimToEmpty(o1.getVccode()).compareTo(
							StringUtils.trimToEmpty(o2.getVccode()));
				}

			});
			String preLogonid = StringUtils.trimToEmpty(datalist.get(0)
					.getVccode());
			for (int i = 1; i < datalist.size(); i++) {
				Tuser u = datalist.get(i);
				if (StringUtils.trimToEmpty(u.getVccode()).equals(preLogonid)) {
					throw new BvServiceException("登陆ID重复[" + preLogonid + "]");
				} else {
					preLogonid = StringUtils.trimToEmpty(u.getVccode());
				}
			}
			Collections.sort(datalist, new Comparator<Tuser>() {

				@Override
				public int compare(Tuser o1, Tuser o2) {
					return StringUtils
							.trimToEmpty(o1.getEmployeeno())
							.compareTo(
									StringUtils.trimToEmpty(o2.getEmployeeno()));
				}

			});
			String preEmployeeno = StringUtils.trimToEmpty(datalist.get(0)
					.getEmployeeno());
			for (int i = 1; i < datalist.size(); i++) {
				Tuser u = datalist.get(i);
				if (StringUtils.trimToEmpty(u.getEmployeeno()).equals(
						preEmployeeno)) {
					throw new BvServiceException("工号重复[" + preEmployeeno + "]");
				} else {
					preEmployeeno = StringUtils.trimToEmpty(u.getEmployeeno());
				}
			}
		}
	}

}
