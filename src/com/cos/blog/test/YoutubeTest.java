package com.cos.blog.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class YoutubeTest {

				@Test
				public void preview() {
								String content = "<a href=\"https://youtu.be/1djtHemxECk\">\r\n" + "https://www.youtube.com/watch?v=4cHr6uwDP2s\r\n" + "</a>";
								
								Document doc = Jsoup.parse(content);
								Elements els = doc.select("a");
								Element el = els.get(0);
								
								String value = el.attr("href");
								System.out.println(value);
								
								if (value.contains("http://www.youtube.com") || value.contains("http://youtu.be")) {
									System.out.println("유튜브");
									String[] id = value.split("=");
									
									el.after(
											"<iframe width=\"754\" height=\"424\" src=\"https://www.youtube.com/embed/" + id[1] + "frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>");	
								} else {
									System.out.println("유튜브 X");
									String arr[] = value.split("/");
									for (String s : arr) {
										System.out.println(s);									
									}
									System.out.println(doc);
								}
				}
}
