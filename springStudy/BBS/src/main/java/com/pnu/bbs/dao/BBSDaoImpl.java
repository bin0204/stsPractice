package com.pnu.bbs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pnu.bbs.dto.BBSDto;

@Repository
public class BBSDaoImpl implements BBSDao {
	
// ���������ʴ´�. �ֳ��ϸ� query���� ������ϱ⶧����
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession; //�ڽ��� DI�ȴ�!

	final String nameSpace = "com.pnu.bbs.dao.BBSDao";//�����ϸ� �ȵȴ�
	
	@Override
	public List<BBSDto> list() {
		return sqlSession.selectList(nameSpace + ".list");//id��  list�� �������� �θ���
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
