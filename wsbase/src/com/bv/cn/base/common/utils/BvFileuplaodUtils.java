package com.bv.cn.base.common.utils;

import com.bv.cn.base.common.config.WSBaseConfig;

public class BvFileuplaodUtils {

	public static String getFileuploadRootpath() {
		return WSBaseConfig.getProperty("fileuploadrootpath", "E:/fileupload/");
	}
}
