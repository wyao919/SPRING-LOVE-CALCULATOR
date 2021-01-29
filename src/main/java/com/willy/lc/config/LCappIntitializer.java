package com.willy.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LCappIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
			
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class arr[] = {LoveCalculatorConfig.class};
		return arr;
	}

	@Override  //servlet mapping
	protected String[] getServletMappings() {
		
		System.out.println("inside servlet mapping page");
		String arr[] = {"/"};
		
		return arr;
	}

}
