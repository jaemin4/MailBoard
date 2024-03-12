package kr.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/boardList.do")
	public String boardList(Model model) {

		List<Board> list = mapper.getLists();
		model.addAttribute("list",list);
		
		return "board/boardList";
	}
	@GetMapping("boardForm.do")
	public String boardForm() {
		return "board/boardForm";
	}
	
	@PostMapping("boardInsert.do")
	public String boardInsert(Board vo) {
		
		mapper.boardInsert(vo);
		
		return "redirect:/boardList.do";
	}
	
	
	
}
