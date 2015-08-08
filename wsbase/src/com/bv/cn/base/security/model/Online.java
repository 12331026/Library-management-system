package com.bv.cn.base.security.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Online implements Serializable {
	private static final long serialVersionUID = -6331600086511418700L;
	protected static Log logger = LogFactory.getLog(Online.class);
	private static boolean isStart = false;
	private static long sleepTime = 300000L;
	private static long timeout = 120000L;
	private static ConcurrentHashMap onlineUser = new ConcurrentHashMap();

	private static void run() {
		new Thread() {
			public void run() {
				try {
					sleep(Online.sleepTime);
				} catch (InterruptedException e) {
					Online.logger.error(e);
				}
				try {
					Calendar now = Calendar.getInstance();
					List sessionidList = new ArrayList();
					Collection col = Online.onlineUser.values();
					for (Iterator localIterator1 = col.iterator(); localIterator1
							.hasNext();) {
						Object object = localIterator1.next();
						Element element = (Element) object;
						Calendar lastModTime = element.getLastModTime();
						long time = now.getTimeInMillis()
								- lastModTime.getTimeInMillis();
						if (time <= Online.timeout)
							break;
						LogonVO logon = (LogonVO) element.getValue();
						sessionidList.add(logon.getSessionid());
						StringBuffer sb = new StringBuffer("在线用户：");
						sb.append(logon.getUsername()).append("(")
								.append(logon.getLoginip())
								.append(") 距离上次的激活时间超过 ")
								.append(Online.timeout).append(" ms(")
								.append(time).append("ms),即将被销毁在线状态。");
						Online.logger.debug(sb);
					}

					for (Iterator it = sessionidList.iterator(); it.hasNext();)
						Online.remove((String) it.next());
				} catch (Exception e) {
					Online.logger.error("刷新在线用户出错：", e);
				}
			}
		}.start();
	}

	public static void mod(String sessionid) {
		Element element = (Element) onlineUser.get(sessionid);
		if (element == null)
			return;
		element.setLastModTime(Calendar.getInstance());
	}

	public static boolean add(LogonVO logon) {
		String key = logon.getSessionid();
		if ((key == null) || (key.trim().length() == 0))
			return false;
		if (!(isStart)) {
			isStart = true;
		}
		Element element = new Element(logon);
		onlineUser.put(key, element);
		logger.debug("now online users size is : " + getSize());
		return true;
	}

	public static List getAllOnlines() {
		List userList = new ArrayList();
		Collection col = onlineUser.values();
		for (Iterator localIterator = col.iterator(); localIterator.hasNext();) {
			Object object = localIterator.next();
			Element element = (Element) object;
			LogonVO logon = (LogonVO) element.getValue();
			userList.add(logon);
		}
		return userList;
	}

	public static LogonVO getBySessionid(String sessionid) {
		Element element = (Element) onlineUser.get(sessionid);
		if (element == null)
			return null;
		LogonVO logon = (LogonVO) element.getValue();
		return logon;
	}

	public static List getByUserid(String userid) {
		List userList = new ArrayList();
		Collection col = onlineUser.values();
		for (Iterator localIterator = col.iterator(); localIterator.hasNext();) {
			Object object = localIterator.next();
			Element element = (Element) object;
			LogonVO logon = (LogonVO) element.getValue();
			if (!(logon.getUserid().equals(userid)))
				break;
			userList.add(logon);
		}
		return userList;
	}

	public static List getByLogonid(String logonid) {
		List userList = new ArrayList();
		Collection col = onlineUser.values();
		for (Iterator localIterator = col.iterator(); localIterator.hasNext();) {
			Object object = localIterator.next();
			Element element = (Element) object;
			LogonVO logon = (LogonVO) element.getValue();
			if (!(logon.getVccode().equals(logonid)))
				break;
			userList.add(logon);
		}
		return userList;
	}

	public static void remove(String sessionid) {
		onlineUser.remove(sessionid);
	}

	public static int getSize() {
		return onlineUser.size();
	}
}
