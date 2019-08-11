package com.sts1.batch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

	public MyTask() {
		
	}
	
	@Scheduled(cron = "* * 0 * * *")
	public void check() {
		//Ư���۾� : Ʈ���� => 
		//Ư���ð��� ����/ �ڷ� ����, �ڷ� ����
		try {
			//daum.net���� html�� �о� �ͼ�
			
			//import org.jsoup.nodes.Document;
			Document doc = Jsoup.connect("http://daum.net").get();
			//Elements links = doc.select("a[href]");
			
			//<div class="aaa" id="aa"></div>
			
			Elements links = doc.select("div");
			for(Element link : links ) {
				System.out.println("link : " + link.attr("class"));
			}
			
			System.out.println("check_" + System.currentTimeMillis());
			
			//DB�� ����
			
		}
		catch(Exception e) {
			System.out.println( e.getMessage() ); 
			
		}
	}
	
}
