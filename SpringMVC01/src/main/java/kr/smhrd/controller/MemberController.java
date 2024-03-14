package kr.smhrd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@RequestMapping("/memRegisterCheck.do")
	public int RegisterCheck(@RequestParam("memID") String memID) {
		
		Member m = membermapper.memberIdCheck(memID);
		if(m.getMemID().equals(null)) {
			System.out.println("회원존재");
			return 0;
		}
		
		return 1;
	}
	
	@RequestMapping("/memRegister.do")
	public String join(Member member,HttpSession session) {
		
		int result = membermapper.memberJoin(member);
	
		if(result==1) { // 회원가입 성공 메세지
			session.setAttribute("mvo", member);
			System.out.println("session : " + member);
			
		   return "redirect:/boardList.do";
		}else {
		   return "redirect:/memJoin.do";
		}	
	}
	@RequestMapping("/GoMemLogin.do")
	public String gomem() {
		return "member/memLoginForm";
	}
	
	@PostMapping("/memLogin.do")
	public String MemberLogin(Member member,HttpSession session) {
		
		Member checkmem = membermapper.memberLogin(member);
		System.out.println("로그인 컨트롤러");
		System.out.println(checkmem );
		
		if(checkmem != null) {
			System.out.println("로그인 성공");
			session.setAttribute("mvo", member);
			System.out.println(session);

			return "redirect:/boardList.do";
		}
		
		else {
			System.out.println("로그인 실패");
			return "member/memLoginForm";
		}
		
	}
	@RequestMapping("/memLogout.do")
	public String memLoginForm(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
		
	}
	
	

}
