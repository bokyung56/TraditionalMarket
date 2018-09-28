package com.ktds.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktds.member.service.MemberService;
import com.ktds.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired 
	private MemberService memberService;
	
	
	// <회원가입>
	@GetMapping("/member/regist")
	public String viewRegistNewMember() {	
		
		return "member/regist";
	} 
	
	
	@PostMapping("/member/regist")
	public String doRegistAction( @ModelAttribute MemberVO memberVO ) {
		
		this.memberService.createNewMember(memberVO);
		
		return "redirect:/main/main";
	}
	
	
	// <로그인>
	@GetMapping("/member/login")
	public String showLoginPage() {
		
		return "member/login";
	}
	
	// <일반회원-로그인>
	@PostMapping("/member/login")
	public String doLoginAction( @ModelAttribute MemberVO memberVO
									, HttpSession session) {
		
		MemberVO param = this.memberService.readOneMember(memberVO);
			
		session.setAttribute("_USER_", param);		// 1. session 등록 (session key == _USER_) -> 2. SessionInterceptor.java
		
		return "redirect:/main/main";
	}
	
	// <카카오회원-로그인>
	
	
	
	@GetMapping("/main/main")
	public String viewMain() {	
		
		return "main/main";
	} 
	
	

	
}
