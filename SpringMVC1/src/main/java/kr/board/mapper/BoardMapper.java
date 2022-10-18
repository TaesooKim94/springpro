package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;

// @Mapper => mybatis가 가지고 있는 API, API를 추가해줘야 쓸수있다
@Mapper
public interface BoardMapper {	// CRUD 메서드들 작성
	// 방법1.
	public List<Board> getLists();	// 전체리스트	=> 이 메서드 이름과 연결된 SQL Query문을 담고 있는 Mapper.xml파일 필요하다 
									//             or @어노테이션으로 
	
	// 방법2.
//	@Delete("delete from board where idx=#{dix}")
//	public void boardDelete(int idx);
	
	public void boardInsert(Board vo);
	
	public Board boardContent(int idx);
	
	public void boardDelete(int idx);
	
	public void boardUpdate(Board vo);
	
	@Update("update myboard set count=count+1 where idx=#{idx}")
	public void boardCount(int idx);
}
