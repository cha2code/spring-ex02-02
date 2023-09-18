package org.barista.mapper;

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
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	//@Test
	public void testGetList() {
		
		mapper.getList().forEach(board -> log.info(board));
	}
	
	//@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("new text");
		board.setContent("new content");
		board.setWriter("christmas");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	//@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		
		board.setTitle("new text");
		board.setContent("new content");
		board.setWriter("christmas");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	//@Test
	public void testRead() {
		
		BoardVO board = mapper.read(2L);
		
		log.info(board);
	}
	
	//@Test
	public void testDelete() {
		
		log.info("Delete count : " + mapper.delete(1L));
	}
	
	//@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		
		board.setBno(1L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		
		log.info("UPDATE COUNT: " + count);
	}
	
	//@Test
	public void testPaging() {
		
		Criteria cri = new Criteria();
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		for(BoardVO board : list) {
			
			log.info(board);
		}
	}
	
	//@Test
	public void testPaging2() {
		
		// 10개씩 3 페이지
		Criteria cri = new Criteria(3, 10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		for(BoardVO board : list) {
			
			log.info(board);
		}
	}
	
	/*
	 * @Test public void testSearch() {
	 * 
	 * Criteria cri = new Criteria();
	 * 
	 * cri.setKeyword("새로"); cri.setType("TC"); // 제목, 내용에서 검색
	 * 
	 * List<BoardVO> list = mapper.getListWithPaging(cri);
	 * 
	 * for(BoardVO board : list) { log.info(board); } }
	 */

}
