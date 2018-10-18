package com.ktds.traditionalmarket.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.traditionalmarket.board.biz.BoardBiz;
import com.ktds.traditionalmarket.board.vo.BoardVO;
import com.ktds.traditionalmarket.member.biz.MemberBiz;
import com.ktds.traditionalmarket.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberBiz memberBiz;
	
	@Autowired
	private BoardBiz boardBiz;

	// 입력한 아이디가 DB에 있는지 확인하기
	@Override
	public boolean readOneId(String memberId) {

		return this.memberBiz.readOneId(memberId);
	}
		
	// <회원가입>
	@Override
	public boolean createNewMember(MemberVO memberVO) {		
			
		return this.memberBiz.createNewMember(memberVO);
	}
	

	// <로그인>
	@Override
	public boolean readOneMember(MemberVO memberVO, HttpSession session) {		

		return this.memberBiz.readOneMember(memberVO, session);
	}
	
	@Override
	public boolean isBlockUser(String memberId) {
		return this.memberBiz.isBlockUser(memberId);
	}
	
	// main 페이지에서 게시글 날짜순 10개 띄어줄려고
	public List<BoardVO> readTenDateBoard(){
		
		return this.boardBiz.readTenDateBoard();
	}
	
	// main 페이지에서 게시글 추천순10개 띄어줄려고
	public List<BoardVO> readTenRecommendBoard(){
		
		return this.boardBiz.readTenRecommendBoard();
	}
}
