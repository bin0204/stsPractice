package com.pnu.bbs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.pnu.bbs.dto.BBSDto;
import com.pnu.bbs.service.BBSService;

@Controller
public class BBSController {

	//���࿡ BBSService�� �θ�� ������ �ֵ��� �ϳ��̻��̸� �����߻�
	//Autowired�� �θ�� ������ �ְ� �ϳ��϶� ��밡���ϴ�
	@Autowired // �������� �����ϴ� annotation, type���� bean�� ã�� 
	private BBSService bbsService; //controller�� service�� DI����
	
	@RequestMapping(value="/list.bbs")
	public String list(Model model) {//Model�� ���� �����Ѵ�
//		BBSDto article = null;
//		ArrayList<BBSDto> ar = new ArrayList<>();
//		for (int i = 0; i < 5; i++) {
//			article = new BBSDto();
//			article.setArticleNum(i);
//			article.setContent("Hello, JavaScript!");
//			article.setId("JS");
//			article.setTitle("Programming");
//			ar.add(article);
//		}
		//Model�� key�� value �� ����
		model.addAttribute("articleList", bbsService.list());
		return "list";
	}
	
	//@RequestMapping(value="/write.bbs", method= RequestMethod.GET)
	@GetMapping(value="/write.bbs")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping(value="/write.bbs")
	public String write(BBSDto article, @RequestPart("fname") List<MultipartFile> fileList) { //input�� name�Ӽ��� fname�̴�, ���ε��� ���� list�� �ø���
		article.setId("Spring");//�������� ����
		//System.out.println(article.toString());
		bbsService.write(article);
		return "redirect:/list.bbs";
	}
	
	@RequestMapping(value="/content.bbs") //������ �̸��� ������ ��������
	public String content(@RequestParam("articleNum") int articleNum, Model model) {
		model.addAttribute("article", bbsService.content(articleNum));
		return "content";
	}
}
