package org.barista.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// root-context.xml 을 대신하는 클래스 생성
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
	}
}

/*
AbstractAnnotationConfigDispatcherServletInitializer

 - root application context와 servlet application context를 지정하고 올리는 방식이
 	복잡하게 구성되어 있어 사용하기 어려운 단점을 보완함
 
 - 해당 기능이 이미 구현 된 클래스를 상속 받아 보다 쉽게 적용이 가능함
 
 - spring xml 설정을 java class로 하는 방법

*/