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
	private BBSDao bbsDao; //service는 dao를 DI받음
	
	//여기밑에 두개의 방법이 있다. 같은타입이 여러개 있어서 이름만 맞춰주면 쓸 수 있다!
	@Autowired
	private String saveDir;//String을 DI 받음

	//@Resource는 빈의 이름으로 찾음
	@Resource(name="saveDir1")
	private String saveDir1;//String을 DI 받음
	
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

	@Transactional //aop가 발생 //service에서 
	@Override
	public BBSDto content(int articleNum) {
		//return bbsDao.content(articleNum);
		bbsDao.upHit(articleNum);
		BBSDto article = bbsDao.content(articleNum);
		return article;
	}
}
