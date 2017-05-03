package com.gxq.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 创建时间：2016年6月14日 下午7:47:27
 * 
 * @author andy
 * @version 2.2
 */

public class ConfigUtil {

	private static Logger logger = LogManager.getLogger(ConfigUtil.class);

	private static Properties config = null;

	/**
	 * 返回系统config.properties配置信息
	 * @param key key值
	 * @return value值
	 */
	public static String getProperty(String key) {
		if (config == null) {
			synchronized (ConfigUtil.class) {
				if (null == config) {
					try {
						Resource resource = new ClassPathResource("config.properties");
						config = PropertiesLoaderUtils.loadProperties(resource);
					} catch (IOException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}

		return config.getProperty(key);
	}
}
