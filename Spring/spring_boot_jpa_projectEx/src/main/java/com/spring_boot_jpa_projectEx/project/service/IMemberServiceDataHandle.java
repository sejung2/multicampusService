package com.spring_boot_jpa_projectEx.project.service;

import com.spring_boot_jpa_projectEx.project.dto.MemberDTO;
import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;

import java.util.HashMap;
import java.util.Optional;

public interface IMemberServiceDataHandle {
    // 로그인 체크
    public String loginCheck(String id);

    //id 중복체크
    public String idCheck(String id);

    // 회원가입
    public void insertMember(MemberEntity entity);

    // 회원정보 수정 Form
    public Optional<MemberEntity> myInfoUpdateForm(String memId);

    // 회원정보 수정
    public void myInfoUpdate(MemberEntity entity);
}
