package com.increpas.cls.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.ReBoardVO;

public class ReBoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public String selAvt(String id) {
		return sqlSession.selectOne("reSQL.selAvt", id);
	}
	public int selCnt() {
		return sqlSession.selectOne("reSQL.selCnt");
	}
	public List<ReBoardVO> selReBoard(PageUtil page) {
		return sqlSession.selectList("reSQL.selReBoard", page);
	}
	public int addContent(ReBoardVO reVO) {
		return sqlSession.insert("reSQL.addContent", reVO);
	}
	public int delProc(int bno) {
		return sqlSession.update("reSQL.delProc", bno);
	}
	public int editProc(ReBoardVO reVO) {
		return sqlSession.update("reSQL.editProc", reVO);
	}
	public int addReBoard(ReBoardVO reVO) {
		return sqlSession.insert("reSQL.addReBoard", reVO);
	}
}
