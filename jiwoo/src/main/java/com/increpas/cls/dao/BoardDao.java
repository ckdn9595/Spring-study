package com.increpas.cls.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.cls.util.*;
import com.increpas.cls.vo.*;

public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	public List<BoardVO> getList(PageUtil page) {
		return sqlSession.selectList("bSQL.getList", page);
	}
	public int getTotal() {
		return sqlSession.selectOne("bSQL.getTotal");
	}
	public BoardVO getDetail(int bno) {
		return sqlSession.selectOne("bSQL.getDetail", bno);
	}
	public List<FileVO> getImage(int bno) {
		return sqlSession.selectList("bSQL.getImage", bno);
	}
	public int addBoard(BoardVO bVO) {
		return sqlSession.insert("bSQL.addBoard", bVO);
	}
	//첨부파일 정보 저장 전담 처리함수
	public int addFile(FileVO fVO) {
		return sqlSession.insert("bSQL.addFile", fVO);
	}
	//게시글 모두 입력 전담 처리함수
	@Transactional
	public int addAll(BoardVO bVO) {
		int cnt = 0;
		//게시글 등록해주고
		addBoard(bVO);
		int bno = bVO.getBno();
		//첨부파일 등록해주고
		List<FileVO> list = bVO.getList();
		for(FileVO fVO : list) {
			fVO.setBno(bno);
			addFile(fVO);
		}
		return cnt;
	}
}
