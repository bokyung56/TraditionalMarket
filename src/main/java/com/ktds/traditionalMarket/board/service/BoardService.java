package com.ktds.traditionalmarket.board.service;

import java.util.List;

import com.ktds.traditionalmarket.board.vo.BoardSearchVO;
import com.ktds.traditionalmarket.board.vo.BoardVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface BoardService {

	public boolean createOneBoard(BoardVO boardVO);			// 글 쓰기
	
	public BoardVO readOneBoard(String boardId);			// 글 하나 읽어오기
	//public boolean updateRecommendCount(String boardId);	// 게시글 추천수 증가시키기
	
	public boolean updateOneBoard(BoardVO boardVO);			// 글 수정하기
	//public boolean deleteOneBoard(String boardId);		// 글 지우기
	
	public PageExplorer readAllBoards(BoardSearchVO boardSearchVO);

	public boolean createOneBoardRecommend(String boardId, String memberId);	// 한 게시글당 추천 누른 회원정보 추가
	public boolean deleteOneBoardRecommend(String boardId, String memberId);	// 하나의 게시글을 추천한 회원 정보 삭제
	public int readOneBoardRecommendCount(String boardId);	// 하나의 게시글을 추천 수
	
	public boolean updateDeleteOneBoard(String boardId);		// 게시글 지운 여부

}
