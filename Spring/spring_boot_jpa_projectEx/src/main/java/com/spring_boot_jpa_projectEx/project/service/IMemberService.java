package com.spring_boot_jpa_projectEx.project.service;

import com.spring_boot_jpa_projectEx.project.dto.MemberDTO;

import java.util.HashMap;


public interface IMemberService {
	// 로그인 체크
	public String loginCheck(HashMap<String, Object> map);
	
	//id 중복체크
	public String idCheck(String id);
	// 회원가입
	public void insertMember(MemberDTO dto);
	// 회원정보 수정 Form
	public MemberDTO myInfoUpdateForm(String memId);
	
	// 회원정보 수정
	public void myInfoUpdate(MemberDTO myInfo);

    // 회원 탈퇴
    public void myInfoDelete(String memId);
}

