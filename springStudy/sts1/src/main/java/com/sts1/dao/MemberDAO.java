package com.sts1.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {

	//mybatis-context.xml로 만든 환경설정 파일 객체중
	//sqlSession객체를 얻음
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	//INSERT,UPDATE, DELETE 리턴을 int => 0 또는 1
	public int insertMemberOne( Map<String, Object> map  ){
		return sqlSession.insert("MemberMapper.insertMemberOne", map);
	}
	
	public List<Map<String, Object>> selectMemberList(){
		return sqlSession.selectList("MemberMapper.selectMemberList");
	}
	
}
