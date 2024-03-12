package kr.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smhrd.entity.Board;
import kr.smhrd.mapper.BoardMapper;

@Controller
public class BoardController {


	@Autowired
	private BoardMapper mapper;
	
	@GetMapping("/home.do")
	public String GoHome() {
		System.out.println("git test");
		return "home";
	}
	
	@GetMapping("/boardList.do") //글 목록 기능
	public String boardList(Model model) {

		List<Board> list = mapper.getLists();
		model.addAttribute("list",list);
		
		return "board/boardList";
	}
	@GetMapping("boardForm.do") //글작성 페이지 이동
	public String boardForm() {
		return "board/boardForm";
	}
	
	@PostMapping("boardInsert.do") //글쓰기 기능
	public String boardInsert(Board vo) {
		
		mapper.boardInsert(vo);
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("boardContent.do")
	public String boardContent(@RequestParam("idx") int idx,Model model) {
		
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo",vo);
		
		return "board/boardContent";
	}
	
	@GetMapping("boardDelete.do/{idx}") //삭제하기
	public String boardDelete(@PathVariable("idx") int idx) { 
		
		mapper.boardDelete(idx);
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("boardUpdateForm.do/{idx}") //수정 폼으로 가기
	public String boardModify(@PathVariable("idx") int idx,Model model) {
		
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo",vo);
		
		return "board/boardUpdate";
	}
	
	@PostMapping("boardUpdate.do") //수정하기
	public String boardUpdate(Board vo) {
		
		mapper.boardUpdate(vo);
		return "redirect:/boardList.do";
	}
	
	
}
