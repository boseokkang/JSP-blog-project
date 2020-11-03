package com.cos.blog.dto;

import com.cos.blog.model.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailResponseDto {
			private Board board;
			private String username; // 여기에 users 객체 넣으면 낭비 일어남 -> 다른 데이터까지 같이 불러오기 때문
}
