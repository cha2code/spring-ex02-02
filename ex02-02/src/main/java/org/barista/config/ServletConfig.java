package org.barista.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = { "org.barista.controller" })
public class ServletConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean); // controller의 실행 결과를 보여주는 bean
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}

/*
WebMvcConfigurer

- spring 프레임워크에서 제공하는 인터페이스
- 요구사항에 맞게 프레임워크 조정이 가능
- 특정한 spring 클래스를 구현하거나 상속할 필요 없이 MVC 구성 정보를 제어할 수 있게 함
- @EnableWebMvc를 통해 활성화 된 Web MVC 애플리케이션의 구성 정보를 커스터마이징하는 것을 도움
	

1. 기존에 설정 된 bean을 유지하고, 기능을 단순히 추가할 때
	-> WebMvcConfigurer를 구현하고 @Configuration을 추가한 클래스를 만듦

2. 기존과 다르게 Spring MVC를 제어하려 할 때
	-> @EnableWebMvc 추가
	

*** 메소드 이름별 구조
- add~ : 기본 설정이 없는 bean들에 대하여 새로운 bean을 추가함
- configure~ : 수정자를 통해 기존의 설정을 대신하여 등록함
- extend~ : 기존의 설정을 이용하며 추가로 설정을 확장함
*/


/*
ViewResolver

- 실행할 view를 찾음
	(페이지 컨트롤러가 리턴한 뷰 이름에 해당하는 뷰 컴포넌트를 찾음)
	
- 리턴 값으로 url을 받아 웹 애플리케이션 디렉토리에서 JSP를 찾음
*/


/*
addResourceHandlers

- 정적 파일들의 경로를 지정
	(어느 경로로 들어왔을 때 mapping 해줄 지 경로를 지정)
*/
