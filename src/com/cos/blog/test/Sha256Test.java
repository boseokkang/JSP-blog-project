package com.cos.blog.test;

import java.security.MessageDigest;

import org.junit.Test;

public class Sha256Test {
				private final static String SALT = "코스";
			
				@Test
				public void encSha256() {
					
						//		int count = 0;
						//		
						//		for (int i = 0; i < bytePlain.length; i++) {
								//			count++;
								//			bytePlainAndSalt[i] = bytePlain[i];
						//		}
						//		
						//		for (int i = count; i < (byteSalt.length+count); i++) {
						//					bytePlainAndSalt[i] = byteSalt[i-count];
						//		}	
								
								
								String plain = "1234";
								String result = "";
						
								// byte화
								byte[] bytePlain = plain.getBytes();
								byte[] byteSalt = SALT.getBytes();
						
								// salt를 섞어서 막 채워 넣을 곳
								byte[] bytePlainAndSalt = new byte[bytePlain.length + byteSalt.length];
						
								int count = 0;
								for (int i = 0; i < bytePlainAndSalt.length; i++) {
						
									if (i < bytePlain.length) {
												count++;
												bytePlainAndSalt[i] = bytePlain[i];
									} else {
												bytePlainAndSalt[i] = byteSalt[i - count];
									}
												System.out.print(bytePlainAndSalt[i] + " ");
								}
								
								//배열 복사
								//0~bytePlain.length까지
								System.arraycopy
								(
													bytePlain, 
													0, 
													bytePlainAndSalt, 
													0, 
													bytePlain.length
								);
								
								//bytePlain의 length부터 salt의 length까지
								System.arraycopy
								(
													byteSalt,
													0,
													bytePlainAndSalt,
													bytePlain.length,
													byteSalt.length
								);
								
								
								
								try {
									//SHA-256 고름
									MessageDigest md = MessageDigest.getInstance("SHA-256");
									md.update(bytePlainAndSalt);
									
									byte[] byteData = md.digest();
									//스트링 버퍼랑 스트링 빌드랑 차이
									//동기화 차이
									//스트링버퍼는 동시접근 불가능! (임계구역 존재)
									StringBuffer sb = new StringBuffer();
									
									for (int i = 0; i < byteData.length; i++) {
													//0xFF로 인해서 16진수로 바뀜
													//안의 알고리즘은 몰라도 된다.
													sb.append(Integer.toHexString((byteData[i] & 0xFF)+256).substring(1));
									}
													result = sb.toString();
													System.out.println(result);
								} catch(Exception e) {
									
								}	
				}
				
				
}
