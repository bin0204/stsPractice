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
	
	//사용할 DAO를 객체를 만듬
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
		return "c3_chart"; //c3_chart.jsp를 표시
	}
	

//
//	//127.0.0.1:8080/web/redis_test.do
//	@RequestMapping(value="/redis_test.do",method = RequestMethod.GET)
//	public @ResponseBody String redis() {
//		strTemplate.setKeySerializer(new StringRedisSerializer());
//		strTemplate.setValueSerializer(new StringRedisSerializer());
//		
//		//값 저장하기
//		strTemplate.opsForValue().set("STS1", "asdf");
//		strTemplate.opsForValue().set("STS2", "asdf");
//		strTemplate.opsForValue().set("STS3", "asdf");
//		
//		//값 가져오기
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
//		//jsp로 값을 전달함.
//		model.addAttribute("num", new Random().nextInt(1000)+1);
//		//jsp파일을 표시함.
//		return "chart";
//	}
//	
//	
//	
//	//127.0.0.1:8090/web/mlist
//	@RequestMapping(value = "/mlist",method = RequestMethod.GET)
//	public String mlist(Model model) {
//		//DB에서 회원목록을 받아옴.
//		List<Map<String, Object>> list = mDAO.selectMemberList();
//		
//		//jsp로 값을 보냄
//		model.addAttribute("list", list);
//		
//		//mlist.jsp를 화면에 표시함.
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
//		//파일 받기
//		MultipartFile file = request.getFile("img");
//		//파일의 실제 데이타 : file.getBytes(); 	//BLOB
//		//파일사이즈 : file.getSize(); 			//number
//		//파일명 : file.getOriginalFilename() 	//varchar2
//		
//		//join.jsp에서 넘어온 3개의 값을 콘솔에 출력해서 확인함.
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		
//		//1.넘어온 값을 map에 압축
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ID", a);
//		map.put("PW", b);
//		map.put("NA", c);
//		map.put("FD", file.getBytes());
//		
//		//2.DAO로 값을 넘기고 추가를 수행함.
//		//리턴값으로 0 또는 1을 받음
//		int ret = mDAO.insertMemberOne(map);
//		
//		if(ret > 0) { //성공했다면
//			
//		}
//		else { //실패했다면 
//			
//		}
//		//성공하면 적절한(?) 페이지로 이동함.
//		//127.0.0.1:8090/web/join를 입력하고 엔터키
//		return "redirect:join"; //주소를 새로 입력
//		
//		//return "join"; //주소변경없이 화면에 표시
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
//		//view로 값을 전달함.
//		model.addAttribute("a", 13);
//		model.addAttribute("b", "str");
//				
//		//전달할 값을 압축함. ctrl+shift+o를 눌러서 import
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
//		//join.jsp를 표시하라.
//		return "join";
	
}


