package com.ktds.traditionalmarket.board.reply.vo;

import com.ktds.traditionalmarket.board.vo.BoardVO;
import com.ktds.traditionalmarket.member.vo.MemberVO;

public class BoardReplyVO {
	// DB에 있는 columns 6개
	private String boardReplyId;
	private String reply;
	private String crtDate;
	private String memberId;
	private String boardId;
	private String parentReplyId;
	
	// 아마 Rownum 역할?
	private int level;

	// MEMBER --- BOARDREPLY --- BOARD
	private BoardVO boardVO;
	private MemberVO memberVO;

	
	
	// getter, setter
	public String getBoardReplyId() {
		return boardReplyId;
	}

	public void setBoardReplyId(String boardReplyId) {
		this.boardReplyId = boardReplyId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getParentReplyId() {
		return parentReplyId;
	}

	public void setParentReplyId(String parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

	
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	public BoardVO getBoardVO() {
		return boardVO;
	}

	public void setBoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
}