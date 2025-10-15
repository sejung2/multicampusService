package com.spring_boot_jpa_projectEx.project.dao;

import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;

import java.util.Optional;

public interface IMemberDAO {

    // 로그인 체크
    public Optional<MemberEntity> loginCheck(String id);

    // id 중복체크
    String idCheck(String id);

    // 회원가입
    void insertMember(MemberEntity entity);

    // 특정 회원 정보 조회
    Optional<MemberEntity> myInfoUpdateForm(String memId);

    // 회원정보 수정
    void myInfoUpdate(MemberEntity entity);

    // 회원 탈퇴
    public void myInfoDelete(String memId);
}
