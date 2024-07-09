package com.security.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		Class[] configFiles = { MySecurityConfig.class};
		return configFiles;

	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configFiles = { MyAppConfig.class};
		return configFiles;
	}

	@Override
	protected String[] getServletMappings() {
		String[] defaultMapping = { "/" };
		return defaultMapping;
	}
	  
}
