package kr.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.smhrd.entity.Board;

@Controller
public class BoardController {

	
	@GetMapping("/home.do")
	public String GoHome() {
		System.out.println("git test");
		return "home";
	}
	
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		Board vo = new Board();
		vo.setIdx(1);
		vo.setTitle("게시판 실습");
		vo.setContent("게시판 실습");
		vo.setWriter("오재민");
		vo.setIndate("23");
		
		
		List<Board> list = new ArrayList<Board>();
		list.add(vo);
		
		model.addAttribute("list",list);
		
		return "board/boardList";
	}
	
	
	
}
