package org.barista.service;

import java.util.List;

import org.barista.config.RootConfig;
import org.barista.domain.BoardVO;
import org.barista.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BoardServiceTest {

	@Autowired
	private BoardService service;
	
	//@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("new text");
		board.setContent("new Content");
		board.setWriter("christmas");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	
	//@Test
	public void testGet() {
		
		log.info(service.get(1L));
	}
	
	//@Test
	public void testUpdate() {
		
		BoardVO board = service.get(1L);
		
		if (board == null) {
			
			return;
		}
		
		board.setTitle("제목을 수정합니다.");
		log.info("modify result : " + service.modify(board));
	}
	
	//@Test
	public void testDelete() {
		
		log.info("Remove result : " + service.remove(2L));
	}
	
	@Test
	public void testGetList() {
		
		List<BoardVO> list = service.getList(new Criteria(2, 10));
		
		for(BoardVO board : list) {
			
			log.info(board);
		}
		
		
		// 페이징 하기 전의 list
		// forEach 람다식 - for문보다 훨씬 간편하게 같은 결과를 얻을 수 있음
		//service.getList().forEach(board -> log.info(board));
	}

}
