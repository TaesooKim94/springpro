package kr.board.entity;

import lombok.Data;

// @Data => Lombok API
@Data
public class Board {
	private int idx;	// 게시판 번호
	private String title;	// 게시판 제목
	private String content;	// 게시판 내용
	private String writer;	// 게시판 작성자
	private String indate;	// 작성일
	private int count;	// 조회수
	
	// setter, getter
	
}
