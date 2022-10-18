package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	// DI(= 의존성 주입, Dependency Injection) => @Autowired
	@Autowired
	private BoardMapper mapper;
	
	// /boardList.do
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		
		List<Board> list=mapper.getLists();
		
		// Controller가 가지고있는 데이터를 jsp로 forwarding할때 쓰는 메모리가 Model 객체
		// list를 boardList.jsp로 넘길려면 객체바인딩해야한다
		// 메모리명 : HttpServletRequest(at Web), Model(at Spring)
		model.addAttribute("list",list);
		
		return "boardList";	// /WEB-INF/views/boardList.jsp -> forward   => viewResolver클래스에 의해 prefix,suffix가 붙여진다
	}
	
	// 게시판양식 얻어오는 = @GetMapping
	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "boardForm";	// WEB-INF/views/boardForm.jsp -> forward
	}
	
	// 글쓰기 = 포스팅 => @PostMapping
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo) {	// 파라미터 수집(Board)
											// title, content, writer
											// Board 클래스에도 똑같이 title, content, writer 변수가 있어야한다
											// 그래야 수집이 된다
		
		mapper.boardInsert(vo);		// 등록
		return "redirect:/boardList.do"; // redirect
	}
	
	@GetMapping("/boardContent.do")
	public String boardContent(@RequestParam("idx") int idx, Model model) {
		
		Board vo=mapper.boardContent(idx);
		
		// 조회수 증가
		mapper.boardCount(idx);
		
		// 객체 바인딩
		model.addAttribute("vo",vo);		// jsp파일에서는 EL로 조회하면된다. ${vo.idx} .....
		
		return "boardContent";	// boardContent.jsp
	}
	
//	@GetMapping("/boardDelete.do")
//	public String boardDelete(@RequestParam("idx") int idx) {
//		mapper.boardDelete(idx);
//		return "redirect:/boardList.do";
//	}
	
	@GetMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) {
		
		mapper.boardDelete(idx);
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx") int idx, Model model) {
		Board vo=mapper.boardContent(idx);
		
		model.addAttribute("vo",vo);
		
		return "boardUpdate"; // boardUpadte.jsp
	}
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) {	// idx, title, content
		
		mapper.boardUpdate(vo);
		
		return "redirect:/boardList.do";
	}
}
