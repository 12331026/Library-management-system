package com.bv.cn.as1sys.as1lib.intercepter;

import java.sql.Timestamp;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bv.cn.as1sys.as1lib.constance.AS1Constance;
import com.bv.cn.wsbase.base.model.TperfStat;
import com.bv.cn.wsbase.base.service.TperfStatService;

@Component("traceInterceptor")
public class TraceInterceptor implements MethodInterceptor {

	protected Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected TperfStatService<TperfStat> tperfStatService;

	/*
	 * OpenSessionInViewFilter4Java sessionInView = new
	 * OpenSessionInViewFilter4Java() {
	 * 
	 * @Override protected SessionFactory lookupSessionFactory() { if
	 * (this.logger.isDebugEnabled()) this.logger.debug("Using SessionFactory '" +
	 * getSessionFactoryBeanName() + "' for OpenSessionInViewFilter"); return
	 * ((SessionFactory) SpringHelper.getBean( getSessionFactoryBeanName(),
	 * SessionFactory.class)); } };
	 */

	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodname = "";
		String params = "";
		Object rtn = null;
		Integer duration = -1;
		long starttime = System.currentTimeMillis();
		TperfStat tperfStat = new TperfStat();
		try {
			// sessionInView.open();
			methodname = invocation.getMethod().getName();
			Object[] args = invocation.getArguments();
			if (null != args && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					params += args[i] + ",";
				}
			}
			if (params.length() > 0) {
				params = params.substring(0, params.length() - 1);
			}
			// invocation.getMethod().get
			// logger.info(methodname + "(" + params + ") start.");
			rtn = invocation.proceed();
			// logger.info(methodname + " returns =" + rtn);
			duration = new Long(System.currentTimeMillis() - starttime)
					.intValue();
			return rtn;
		} catch (Exception e) {
			logger.error(methodname + " process error!", e);
			throw e;
		} finally {
			// try {
			//
			// sessionInView.close();
			// } catch (Exception e) {
			// e.printStackTrace(System.err);
			// }
			tperfStat.setClassname(invocation.getThis().getClass().getName());
			if (methodname != null && methodname.length() > 127) {
				tperfStat.setMethodname(StringUtils.substring(methodname, 0,
						127));
			} else {
				tperfStat.setMethodname(methodname);
			}
			if (params != null && params.length() > 2047) {
				byte[] bytes = String.valueOf(rtn).getBytes();
				byte[] paramBytes = new byte[2048];
				System.arraycopy(bytes, 0, paramBytes, 0, 2048);
				String paramMsg = new String(paramBytes);
				tperfStat.setParam(paramMsg);
			} else {
				tperfStat.setParam(params);
			}
			if (rtn != null && String.valueOf(rtn).getBytes().length > 2048) {
				byte[] bytes = String.valueOf(rtn).getBytes();
				byte[] rtnBytes = new byte[2048];
				System.arraycopy(bytes, 0, rtnBytes, 0, 2048);
				String rtnMsg = new String(rtnBytes);
				tperfStat.setReturnvalue(rtnMsg);
			} else {
				tperfStat.setReturnvalue("" + rtn);
			}
			tperfStat.setStarttime(new Timestamp(starttime));
			tperfStat.setExt1(AS1Constance.PERFSTAT_SRC_TRACE);
			tperfStatService.saveEntity(tperfStat);
			logger.debug(methodname + "(" + params + ") end. used "
					+ String.valueOf(duration) + " minus");
		}
	}

}
