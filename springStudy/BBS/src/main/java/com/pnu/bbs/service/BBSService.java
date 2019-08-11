package com.pnu.bbs.service;

import java.util.List;

import com.pnu.bbs.dto.BBSDto;

public interface BBSService {
	public List<BBSDto> list();
	public void write(BBSDto article);
	public BBSDto content(int articleNum);
}

