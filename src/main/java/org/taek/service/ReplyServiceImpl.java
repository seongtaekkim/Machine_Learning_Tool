package org.taek.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.taek.domain.Criteria;
import org.taek.domain.ReplyVO;
import org.taek.persistence.ReplyDAO;

@Repository
public class ReplyServiceImpl implements ReplyService {

	@Inject
	ReplyDAO dao;
	
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		dao.delete(rno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		return dao.listPage(bno, cri);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return dao.count(bno);
	}

}
