package com.haozileung.scau.server.common.listener;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.haozileung.scau.server.common.context.SpringApplicationContextHolder;

/**
 * 接口或类的说明：Spring上下文加载监听器的扩展类
 */
public class ExtendedSpringContextLoaderListener extends ContextLoaderListener {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		super.contextDestroyed(servletContextEvent);
		SpringApplicationContextHolder.destroy();
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		super.contextInitialized(servletContextEvent);
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContextEvent
						.getServletContext());
		SpringApplicationContextHolder.init(ctx);
		if (logger.isInfoEnabled()) {
			logger.info("Spring上下文初始化完毕！");
		}
	}
}
