package com.cos.blog.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
			
				public static String youtube(String content) {
		
								Document doc = Jsoup.parse(content);
								Elements aTags = doc.select("a");
								// https://youtu.be/a9t_TpinIYc
								// https://www.youtube.com/watch?v=D-c0smnjYjI
								for (Element aTag : aTags) {
												String href = aTag.attr("href");
												String youtubeId = null;
												if (href != null && !(aTag.attr("target").equals("_blank"))) {
															if (href.contains("https://youtu.be")) {
																			String[] hrefArr = href.split("/");
																			youtubeId = hrefArr[3];
																			System.out.println("/분기");
															} else if (href.contains("https://www.youtube.com/")) {
																			String[] hrefArr = href.split("=");
																			youtubeId = hrefArr[1];
																			System.out.println("=분기");
															}
															//src 값은 youtube에서 쓰여지는 형식이라서 맞춰서 쓰면 된다
															String video = "<br/><iframe src='http://www.youtube.com/embed/" + youtubeId
																				+ "'width='800px' height='400px' frameborder='0' allowfullscreen></iframe>";
															aTag.after(video);
												}
								}
								return doc.toString();
							}
						
				public static String getContentPreview(String content) {
						
								Document doc = Jsoup.parse(content);
								Elements pTags = doc.select("p");
						
								for (Element pTag : pTags) {
											String text = pTag.text();
											if (text.length() > 0) {
													if (text.length() < 11) {
																return pTag.text();
									
													} else {
																return pTag.text().substring(0, 10) + "...";
													}
											}
									}
									return "내용 없음...";
				}
}
