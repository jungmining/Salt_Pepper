package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.MemberVo;


public interface IMemberDao {
	
	/**
	 * 회원가입 
	 * @param 이름,아이디,패스워드,전화번호
	 * @return 성공적으로 회원가입 완료되면 true/실패하면 false
	 */
	public boolean signin(MemberVo vo);
	
	/**
	 * 로그인
	 * 회원가입이 되어있는 회원인지 확인하기 위한 메소드
	 * @param 아이디,비밀번호
	 * @return 회원가입이 된 회원이라면 값 회원정보를 리턴
	 */
	public MemberVo loginSelect(Map<String, Object> map); 
	/**
	 * 회원가입시 아이디 중복여부를 확인하기 위한 메소드 
	 * @param 입력한 아이디 
	 * @return 중복이 있다면 true / 중복없다면 false
	 */
	public int idChk(String id);
	/**
	 * 아이디를 찾아주는 메소드
	 * @param 이름,전화번호,생년월일
	 * @return 일치하는 정보가 있다면 회원아이디를 리턴
	 */
	public MemberVo findId(Map<String, Object> map);
	/**
	 * 비밀번호를 변경 전 회원정보를 확인하는 메소드
	 * @param 아이디,이름,전화번호
	 * @return 일치하는 정보가 있다면 비밀번호를 변경할 수 있도록 함
	 */
	public MemberVo findPw(Map<String, Object> map);
	/**
	 * 비밀번호를 변경시켜주는 메소드
	 * @param 변경할 비밀번호
	 * @return 비밀번호 변경에 성공하면 true
	 */
	public int pwUpdate(Map<String, Object>map);
}
