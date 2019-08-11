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

	//만약에 BBSService를 부모로 가지는 애들이 하나이상이면 에러발생
	//Autowired는 부모로 가지는 애가 하나일때 사용가능하다
	@Autowired // 스프링이 지원하는 annotation, type으로 bean을 찾음 
	private BBSService bbsService; //controller는 service를 DI받음
	
	@RequestMapping(value="/list.bbs")
	public String list(Model model) {//Model은 값을 저장한다
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
		//Model은 key와 value 로 저장
		model.addAttribute("articleList", bbsService.list());
		return "list";
	}
	
	//@RequestMapping(value="/write.bbs", method= RequestMethod.GET)
	@GetMapping(value="/write.bbs")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping(value="/write.bbs")
	public String write(BBSDto article, @RequestPart("fname") List<MultipartFile> fileList) { //input의 name속성이 fname이다, 업로드한 값을 list에 올린다
		article.setId("Spring");//수동으로 셋함
		//System.out.println(article.toString());
		bbsService.write(article);
		return "redirect:/list.bbs";
	}
	
	@RequestMapping(value="/content.bbs") //변수의 이름이 같으면 생략가능
	public String content(@RequestParam("articleNum") int articleNum, Model model) {
		model.addAttribute("article", bbsService.content(articleNum));
		return "content";
	}
}
