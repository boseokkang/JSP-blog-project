package com.cos.blog.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JSoupParserTest {
	@Test
	public void youtube() {

		//String content = "<a href=https://www.youtube.com/watch?v=D-c0smnjYjI> </a>";
		String content = "<a href=https://youtu.be/a9t_TpinIYc></a>";
		Document doc = Jsoup.parse(content);
		System.out.println(doc);
		
		Elements els = doc.select("a");
		Element el = els.get(0);

		String value = el.attr("href");
		System.out.println(value);
		
		if(value.contains("https://www.youtube.com")||
				value.contains("https://youtu.be")) {
			System.out.println("테스트");
			
			//String[] id = value.split("=");
			//el.after("<iframe src=\"http://www.youtube.com/embed/"+id[1]+"\" width=\"800px\" height=\"400px\" frameborder=\"0\" allowfullscreen=\"\"></iframe>");
			
			String[] id2 = value.split("/");
			System.out.println(id2[3]);
			
			//el.after("<iframe src=\"http://www.youtube.com/embed/"+id2[1]+"\" width=\"800px\" height=\"400px\" frameborder=\"0\" allowfullscreen=\"\"></iframe>");
		}else {
			System.out.println("취소");
		}
		//System.out.println(doc);
		
		
		
	}
}

