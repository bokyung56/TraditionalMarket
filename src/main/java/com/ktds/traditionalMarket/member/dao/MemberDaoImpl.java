package com.ktds.traditionalmarket.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.traditionalmarket.member.vo.MemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {

		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	
	@Override 
	public int insertNewMember(MemberVO memberVO) {
		
		return getSqlSession().insert("MemberDao.insertNewMember", memberVO);
	}

	@Override
	public MemberVO selectOneMember(MemberVO memberVO) {
		
		return getSqlSession().selectOne("MemberDao.selectOneMember", memberVO);
	}
	
	@Override
	public String getSaltById(String memberId) {
		
		return getSqlSession().selectOne("MemberDao.getSaltById", memberId);
	}

	@Override
	public int updatePoint(Map<String, Object> memberVO) {
		
		return getSqlSession().update("MemberDao.updatePoint", memberVO);
	}




}
