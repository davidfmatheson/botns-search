package com.mathesonconsulting.botns.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	private static final String DISPATCHER_SERVLET_PATH = "/api/*";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(new ContextLoaderListener(getWebApplicationContext(AppConfig.class, JpaConfig.class)));
		
		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, 
				new DispatcherServlet(getWebApplicationContext(MvcConfig.class)));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping(DISPATCHER_SERVLET_PATH);
	}
	
	private static WebApplicationContext getWebApplicationContext(Class<?> ... annotatedClasses) {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(annotatedClasses);
		
		return webApplicationContext;
	}
}
