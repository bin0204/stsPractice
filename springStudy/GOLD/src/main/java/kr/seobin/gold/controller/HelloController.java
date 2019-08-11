package kr.seobin.gold.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//모든 요청을 받아들이는 DispatcherServlet이 특정 요청을 처리 할 수 있도록  
//@Controller 어노테이션이 작성된 클래스들을 읽어들인다
@Controller 
public class HelloController {
	//그 클래스의 많은 어노테이션 중에서 @RequestMappiing 어노테이션을
	//읽어들인다 -> url과 메서드가 매핑이 이루어진다
	@RequestMapping(value="/hello.gold")
	public String hello() {
		return "hello";
	}
}
