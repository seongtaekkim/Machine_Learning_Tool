package org.taek.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.taek.domain.BoardVO;
import org.taek.domain.SearchCriteria;
import org.taek.persistence.BoardDAO;
import org.taek.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class mybatis {

	private static final Logger  logger = LoggerFactory.getLogger(SearchBoardController.class);
	@Inject
	BoardDAO dao;
	@Inject
	BoardService service;
	
	
	@Test
	public void test() throws Exception{
		
//		BoardVO vo = new BoardVO();
//		vo.setContent("11111");
//		vo.setTitle("1111");
//		vo.setWriter("22aerhaerh");
//		dao.create(vo);
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setkeyword("11");
		cri.setSearchType("t");
		
		logger.info("=========================================================");
		List<BoardVO> list = dao.listSearch(cri);
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ": "+boardVO.getTitle());
		}
		logger.info("=========================================================");
		logger.info("count : "+dao.listSearchCount(cri));
//		System.out.println(sf);
//		System.out.println(ss);
	}
}
