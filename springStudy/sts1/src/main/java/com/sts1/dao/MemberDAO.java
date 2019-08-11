package com.sts1.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {

	//mybatis-context.xml�� ���� ȯ�漳�� ���� ��ü��
	//sqlSession��ü�� ����
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	//INSERT,UPDATE, DELETE ������ int => 0 �Ǵ� 1
	public int insertMemberOne( Map<String, Object> map  ){
		return sqlSession.insert("MemberMapper.insertMemberOne", map);
	}
	
	public List<Map<String, Object>> selectMemberList(){
		return sqlSession.selectList("MemberMapper.selectMemberList");
	}
	
}
