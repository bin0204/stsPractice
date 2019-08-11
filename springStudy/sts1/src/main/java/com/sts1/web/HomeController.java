package com.sts1.web;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sts1.dao.MemberDAO;


@Controller
public class HomeController {
	
	//����� DAO�� ��ü�� ����
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private RedisTemplate<String, String> strTemplate;
	@RequestMapping(value = "/c3_chart.do", method = RequestMethod.GET)
	public String c3_chart(Model model) {
		
		strTemplate.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
		strTemplate.setValueSerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
		strTemplate.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
		strTemplate.setHashValueSerializer(new StringRedisSerializer(StandardCharsets.UTF_8));

		String t1 = (String)strTemplate.opsForHash()
			.get("seobin:id1", "tel");
		String t2 = (String)strTemplate.opsForHash()
			.get("seobin:id1", "age");
		
		System.out.println("LOAD : " + t1 + "," + Integer.parseInt(t2));
		return "c3_chart"; //c3_chart.jsp�� ǥ��
	}
	

//
//	//127.0.0.1:8080/web/redis_test.do
//	@RequestMapping(value="/redis_test.do",method = RequestMethod.GET)
//	public @ResponseBody String redis() {
//		strTemplate.setKeySerializer(new StringRedisSerializer());
//		strTemplate.setValueSerializer(new StringRedisSerializer());
//		
//		//�� �����ϱ�
//		strTemplate.opsForValue().set("STS1", "asdf");
//		strTemplate.opsForValue().set("STS2", "asdf");
//		strTemplate.opsForValue().set("STS3", "asdf");
//		
//		//�� ��������
//		String ret = strTemplate.opsForValue().get("key7");
//		System.out.println(ret);
//		
//		return ret; 
//	}
//	
//	
//	//127.0.0.1:8090/web/chart.do
//	@RequestMapping(value = "/chart.do",method = RequestMethod.GET)
//	public String chart(Model model) {
//		//jsp�� ���� ������.
//		model.addAttribute("num", new Random().nextInt(1000)+1);
//		//jsp������ ǥ����.
//		return "chart";
//	}
//	
//	
//	
//	//127.0.0.1:8090/web/mlist
//	@RequestMapping(value = "/mlist",method = RequestMethod.GET)
//	public String mlist(Model model) {
//		//DB���� ȸ������� �޾ƿ�.
//		List<Map<String, Object>> list = mDAO.selectMemberList();
//		
//		//jsp�� ���� ����
//		model.addAttribute("list", list);
//		
//		//mlist.jsp�� ȭ�鿡 ǥ����.
//		return "mlist";	
//	}
//	
//	
//	@RequestMapping(value = "/join", method = RequestMethod.POST)
//	public String join(
//			MultipartHttpServletRequest request,
//			@RequestParam("id") String a,
//			@RequestParam("pw") String b,
//			@RequestParam("name") String c) throws IOException {
//		
//		//���� �ޱ�
//		MultipartFile file = request.getFile("img");
//		//������ ���� ����Ÿ : file.getBytes(); 	//BLOB
//		//���ϻ����� : file.getSize(); 			//number
//		//���ϸ� : file.getOriginalFilename() 	//varchar2
//		
//		//join.jsp���� �Ѿ�� 3���� ���� �ֿܼ� ����ؼ� Ȯ����.
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		
//		//1.�Ѿ�� ���� map�� ����
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ID", a);
//		map.put("PW", b);
//		map.put("NA", c);
//		map.put("FD", file.getBytes());
//		
//		//2.DAO�� ���� �ѱ�� �߰��� ������.
//		//���ϰ����� 0 �Ǵ� 1�� ����
//		int ret = mDAO.insertMemberOne(map);
//		
//		if(ret > 0) { //�����ߴٸ�
//			
//		}
//		else { //�����ߴٸ� 
//			
//		}
//		//�����ϸ� ������(?) �������� �̵���.
//		//127.0.0.1:8090/web/join�� �Է��ϰ� ����Ű
//		return "redirect:join"; //�ּҸ� ���� �Է�
//		
//		//return "join"; //�ּҺ������ ȭ�鿡 ǥ��
//	}
//	
//	
//	
//	
//	//127.0.0.1:8090/web     /
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
//		return "home";
//	}
//	
//	//127.0.0.1:8090/web/join  
//	@RequestMapping(value="/join", method = RequestMethod.GET)
//	public String join(Model model) {
//		//view�� ���� ������.
//		model.addAttribute("a", 13);
//		model.addAttribute("b", "str");
//				
//		//������ ���� ������. ctrl+shift+o�� ������ import
//		//List<Integer> list = new ArrayList<Integer>();
//		//list.add(13);
//				
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("a", 33);
//		map.put("b", "str1");
//		map.put("c", "str2");
//				
//		model.addAttribute("vo", map);
//				
//		//join.jsp�� ǥ���϶�.
//		return "join";
	
}


