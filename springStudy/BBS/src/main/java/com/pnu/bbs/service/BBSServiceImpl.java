package com.pnu.bbs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pnu.bbs.dao.BBSDao;
import com.pnu.bbs.dto.BBSDto;

@Service
public class BBSServiceImpl implements BBSService {

	@Autowired 
	private BBSDao bbsDao; //service�� dao�� DI����
	
	//����ؿ� �ΰ��� ����� �ִ�. ����Ÿ���� ������ �־ �̸��� �����ָ� �� �� �ִ�!
	@Autowired
	private String saveDir;//String�� DI ����

	//@Resource�� ���� �̸����� ã��
	@Resource(name="saveDir1")
	private String saveDir1;//String�� DI ����
	
	@Override
	public List<BBSDto> list() {
		//System.out.println("Hello, Spring");
		System.out.println(saveDir);
		return bbsDao.list();
	}

	@Override
	public void write(BBSDto article) {
		bbsDao.write(article);
	}

	@Transactional //aop�� �߻� //service���� 
	@Override
	public BBSDto content(int articleNum) {
		//return bbsDao.content(articleNum);
		bbsDao.upHit(articleNum);
		BBSDto article = bbsDao.content(articleNum);
		return article;
	}
}
