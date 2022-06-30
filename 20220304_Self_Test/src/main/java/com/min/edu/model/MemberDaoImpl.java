package com.min.edu.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.db.SqlSessionFactoryManager;
import com.min.edu.vo.MemberVo;

public class MemberDaoImpl implements IMemberDao {
	
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.MemberDaoImpl.";
	
	//회원가입 
	@Override
	public boolean signin(MemberVo vo) {
		int cnt=0;
			SqlSession session = manager.openSession(true);
			cnt = session.insert(NS+"signUp",vo);
			session.commit();
		return cnt>0? true : false;
	}
	
	//로그인
	@Override
	public MemberVo loginSelect(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"loginSelect",map);
	}
	
	//아이디 중복검사 
	@Override
	public int idChk(String id) {
		SqlSession session = manager.openSession();
		int cnt = session.selectOne(NS+"idChk",id);
		return cnt;
	}
	//아이디 찾기
	@Override
	public MemberVo findId(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"findId",map);
	}
	//비밀번호 변경 전 일치하는 정보인지 확인하는 메소드
	@Override
	public MemberVo findPw(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"findPw",map);
	}
	//비밀번호를 변경해주는 메소드
	@Override
	public int pwUpdate(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		int cnt = session.update(NS+"updatePw",map);
		return cnt;
	}
	
}
