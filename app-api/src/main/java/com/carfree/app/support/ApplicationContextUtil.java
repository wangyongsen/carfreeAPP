package com.carfree.app.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 * liwenlong
 */
@Service
public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {

		ApplicationContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 获取指定BEAN
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public static <T> T getBeanOfType(Class<T> clazz) {

		return (T) applicationContext.getBean(clazz);
	}
	
	public static <T> Map<String,T> getBeansOfType(Class<T> clazz) {
		return applicationContext.getBeansOfType(clazz);
	}
	

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

}
