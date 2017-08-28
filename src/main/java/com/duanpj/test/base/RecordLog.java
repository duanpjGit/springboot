package com.duanpj.test.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志打印组件
 */
public class RecordLog {

	private final static Logger loger = LoggerFactory.getLogger(RecordLog.class);
	public final static int LOG_LEVEL_ERROR = 1;
	public final static int LOG_LEVEL_WARN = 2;
	public final static int LOG_LEVEL_INFO = 3;
	public final static int LOG_LEVEL_DEBUG = 4;
	public final static int LOG_LEVEL_TRACE = 5;

	/**
	 * 常规信息打印
	 * 
	 * @param description
	 *            日志描述
	 */
	public static void printLog(String description) {
		loger.info(description);
	}

	/**
	 * 常规信息打印
	 * 
	 * @param description
	 * @param level
	 */
	public static void printLog(String description, int level) {

		switch (level) {
		case LOG_LEVEL_ERROR:
			loger.error(description);
			break;
		case LOG_LEVEL_WARN:
			loger.warn(description);
			break;
		case LOG_LEVEL_INFO:
			loger.info(description);
			break;
		case LOG_LEVEL_DEBUG:
			loger.debug(description);
			break;
		case LOG_LEVEL_TRACE:
			loger.trace(description);
			break;
		default:
			loger.info(description);
		}
	}
}
