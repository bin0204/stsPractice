package com.pnu.bbs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pnu.bbs.dto.BBSDto;

@Repository
public class BBSDaoImpl implements BBSDao {
	
// 직접하지않는다. 왜냐하면 query문을 적어야하기때문에
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession; //자식이 DI된다!

	final String nameSpace = "com.pnu.bbs.dao.BBSDao";//변경하면 안된다
	
	@Override
	public List<BBSDto> list() {
		return sqlSession.selectList(nameSpace + ".list");//id가  list인 쿼리문을 부른다
	}

	@Override
	public void write(BBSDto article) {
		sqlSession.insert(nameSpace + ".write", article);
	}

	@Override
	public BBSDto content(int articleNum) {
		return sqlSession.selectOne(nameSpace + ".content", articleNum);
	}

	@Override
	public void upHit(int articleNum) {
		sqlSession.update(nameSpace+".upHit", articleNum);
	}
	

	
}
