package kr.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smhrd.entity.Member;
import kr.smhrd.mapper.MemberMapper;

@Controller

public class MemberController {
	
	@Autowired
	private MemberMapper membermapper;
	
	@RequestMapping("/memJoin.do")
	public String memJoin() {
		return "member/join";  // join.jsp
	}
	
	@RequestMapping("/memRegister.do")
	public String join(Member member) {
		
		int result = membermapper.memberJoin(member);
		
		if(result==1) { // 회원가입 성공 메세지
		   return "redirect:/";
		}else {
		   return "redirect:/memJoin.do";
		}	
	}
	
	
	

}
