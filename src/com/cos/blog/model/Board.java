package com.cos.blog.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	
@AllArgsConstructor
@Builder
	public class Board {
		private int id;
		private int userId;
		private String title;
		private String content;
		private int readCount;
		private Timestamp createDate;
		
//		public String getTitle() { // DB에서 꺼낼 때
			// 꺽쇠 치환
//			title = title.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
//			return title;
//		}
	}
