package kr.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	
	@GetMapping("/home.do")
	public String GoHome() {

		return "home";
	}
	
	
	
	
	
}
