package kr.seobin.gold.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//��� ��û�� �޾Ƶ��̴� DispatcherServlet�� Ư�� ��û�� ó�� �� �� �ֵ���  
//@Controller ������̼��� �ۼ��� Ŭ�������� �о���δ�
@Controller 
public class HelloController {
	//�� Ŭ������ ���� ������̼� �߿��� @RequestMappiing ������̼���
	//�о���δ� -> url�� �޼��尡 ������ �̷������
	@RequestMapping(value="/hello.gold")
	public String hello() {
		return "hello";
	}
}
