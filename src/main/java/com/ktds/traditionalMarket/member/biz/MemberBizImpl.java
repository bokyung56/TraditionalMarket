package com.ktds.traditionalmarket.member.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.traditionalmarket.member.dao.MemberDao;
import com.ktds.traditionalmarket.member.vo.MemberVO;


@Component
public class MemberBizImpl implements MemberBiz{
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean readOneId(String memberId) {
		
		return memberDao.selectOneId(memberId) > 0;
	}
	
	@Override
	public boolean createNewMember(MemberVO memberVO) {
		
		return memberDao.insertNewMember(memberVO) > 0;
	}

	@Override
	public MemberVO readOneMember(MemberVO memberVO) {
		
		return memberDao.selectOneMember(memberVO);
	}

	@Override
	public String getSaltById(String memberId) {
	
		return memberDao.getSaltById(memberId);
	}


	
	
	
}