package org.barista.controller;

import org.barista.config.RootConfig;
import org.barista.config.ServletConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@WebAppConfiguration
@ContextConfiguration(classes = {
		RootConfig.class,
		ServletConfig.class
})
public class BoardControllerTest {

	@Setter(onMethod_ = {@Autowired}) // == @Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//@Test
	public void testList() throws Exception {
		
		log.info(
				//get 방식의 호출
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn() // 테스트한 결과 객체를 통해
				.getModelAndView() // Model에 어떤 데이터가 담겨있는 지
				.getModelMap() // Map 형식으로 확인
		);
	}
	
	//@Test
	public void testRegister() throws Exception{
		
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "new text title")
				.param("content", "new text content")
				.param("writer", "santa"))
				.andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}

	//@Test
	public void testGet() throws Exception {
		
		log.info(
				mockMvc
				.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}
	
	@Test
	public void testModify() throws Exception {
		
		String resultPage = mockMvc
				.perform(
						MockMvcRequestBuilders
						.post("/board/modify")
						.param("bno", "1")
						.param("title", "new test text title")
						.param("content", "new test text content")
						.param("writer", "santa"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		
		log.info(resultPage);
	}
	
	//@Test
	public void testRemove() throws Exception {
		
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders
						.post("/board/remove")
						.param("bno", "25"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		
		log.info(resultPage);
	}
	
	@Test
	public void testListPaging() throws Exception {
		
		log.info(
				mockMvc.perform(
						MockMvcRequestBuilders
						.get("/board/list")
						.param("pageNum", "2")
						.param("amount", "50"))
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
	}
}

/*

@WebAppConfiguration

- Spring Framework에서 Application context의 웹 버전을 생성하는데 사용

- Class Level Annotation

- WebApplicactionContext가 MockMvc 개체를 build하는 데 사용됨
	(일반적으로 통합 테스트에서 어노테이션 사용)

*/

/*

MockMvc

- 웹 어플리케이션을 애플리케이션 서버에 배포하지 않고 테스트용 MVC환경을 만들어
	요청 및 전송, 응답 기능을 제공하는 유틸리티 클래스

*/

/*

@Before

- 반복되는 준비 작업을 별도의 메소드에 넣어주고,
	매번 테스트 메소드를 실행하기 전에 먼저 자동으로 실행시킴
	(모든 테스트 전에 매번 실행되는 메소드)
	
	cf) @After : @Before와 기능은 같지만 @Test가 붙은 메소드를 호출한 후 실행됨

*/

/*

RedirectAttributes

- Model의 기능을 그대로 확장

- redirect가 발생하기 전에 모든 flash 속성을 session에 복사함

- redirection 이후 저장된 flash 속성을 session에서 model로 이동시킴

- header에 parameter를 붙이지 않기 때문에 URL에 노출 되지 않음
	(header가 아닌 session을 통해 전달하기 때문)

- addFlashAttribute() : redirect 직전 플래시에 저장하는 메소드
										(redirect 이후에는 소멸함)
										
*/