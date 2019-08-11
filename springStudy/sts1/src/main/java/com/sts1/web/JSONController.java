package com.sts1.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sts1.dao.MemberDAO;


@RestController
@RequestMapping("/json")
public class JSONController {

	//사용할 DAO를 객체를 만듬
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value="/c3_chart", method=RequestMethod.GET, produces="application/json")
		public Map<String, Object> chart2(){
			Map<String, Object> map = new HashMap<String, Object>();
			
			//for(int i=1;i<=2;i++) {
			int a = new Random().nextInt(1000)+1; //1~1000사이의 랜덤 숫자 발생
			int b = new Random().nextInt(1000)+1;
			int c = new Random().nextInt(1000)+1;
			int d = new Random().nextInt(1000)+1;
			int e = new Random().nextInt(1000)+1;
			int f = new Random().nextInt(1000)+1;
			
			//['data1', 30, 200, 100, 400, 150, 250],
			//String data = "data" + i;
			String str  //json 타입으로 변경
				= String.format("['data1', %d, %d, %d, %d, %d, %d]", //data,
						a,b,c,d,e,f);
			map.put("ret", str);
			
			
			String str1 
			= String.format("['data2', %d, %d, %d, %d, %d, %d]", 
					a,b,c,d,e,f);
			map.put("ret1", str1);
			//}
			//System.out.println(map);
			return map;
		}
//	@RequestMapping(value = "/chart2",
//			method = RequestMethod.GET, produces = "application/json")
//	public Map<String, Object> chart2(
//			HttpServletResponse response,
//			@RequestParam(value="key", required = false, 
//			defaultValue = "0") String key){
//		//크로스 도메인 해결
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("ret", "n"); //{"ret":"n"}
//        
//        //if(key == "abc") { 틀린문법
//        if(key.equals("abc")) { //{"ret":"y", "data":[{}{}{}{}]}
//        	map.put("ret", "y");
//        	
//        	List<Map<String, Object>> list 
//        		= new ArrayList<Map<String, Object>>();
//        	for(int i=0; i<5; i++) {
//        		Map<String, Object> map1 
//        			= new HashMap<String,Object>();
//        		map1.put("year", String.valueOf(2005+i));
//        		map1.put("value", new Random().nextInt(1000)+1);
//    			map1.put("value1", new Random().nextInt(1000)+1);
//
//    			list.add(map1);
//        	}
//        	map.put("data", list);
//        }
//        
//        return map;
//	}
//	//127.0.0.1:8090/web/json/chart2?key=abc
//	
//	
//	//127.0.0.1:8090/web/json/chart1
//	@RequestMapping(value = "/chart1",
//			method = RequestMethod.GET, produces = "application/json")
//	public List<Map<String, Object>> chart1(HttpServletResponse response){
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        
//		
//		List<Map<String, Object>> list 
//			= new ArrayList<Map<String, Object>>();
//		for(int i=2015;i<=2019;i++) {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("year", String.valueOf(i));
//			map.put("value", new Random().nextInt(1000)+1);
//			map.put("value1", new Random().nextInt(1000)+1);
//			list.add(map);
//		}
//		return list;
//	}
//	
//	
		
	//127.0.0.1:8090/web/json/mlist?key=123
	/* XML로 포멧
	 <xml>
	  <id>a</id>
	  <pw>b</pw>
	  <name>c</name>
	 </xml> 
	*/
	
	/*JSON 포멧:	{"id":"a", "pw":"b", "name":"c"}*/

	//http://127.0.0.1:8090/web/json/mlist?key=123
//	@RequestMapping(value = "/mlist",method = RequestMethod.GET)
//	public List<Map<String, Object>> json(
//			@RequestParam(value="key", 
//			required = false, 
//			defaultValue ="0" ) int key) {
//		if(key == 123) {
//			//DB에서 오는 값을 JSON문서로 만듬
//			List<Map<String, Object>> list = mDAO.selectMemberList();
//			return list;
//		}
//		else {
//			//에러 처리에 대한 임의의 값으로 만듬 
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("ret", "404 page");
//			
//			List<Map<String, Object>> list 
//				= new ArrayList<Map<String, Object>>();
//			list.add(map);
//			return list;
//		}
//	}
}	
	

