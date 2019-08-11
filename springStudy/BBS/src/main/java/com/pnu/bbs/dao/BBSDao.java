package com.pnu.bbs.dao;

import java.util.List;

import com.pnu.bbs.dto.BBSDto;

public interface BBSDao {
	public List<BBSDto> list();
	public void write(BBSDto article);
	public BBSDto content(int articleNum);
	public void upHit(int articleNum);
}
