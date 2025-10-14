package com.spring_boot_jpa_projectEx.project.dao;

import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;
import com.spring_boot_jpa_projectEx.project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberDAO implements IMemberDAO{

    @Autowired
    MemberRepository memRepo;

    @Override
    public Optional<MemberEntity> loginCheck(String id) {
        // 특정 회원의 대한 정보를 추출 findById(id) -> Optional<MemberEntity> -> 특정 회원의 레코드
        return memRepo.findById(id);
    }

    @Override
    public String idCheck(String id) {
        return "";
    }

    @Override
    public void insertMember(MemberEntity entity) {

    }

    @Override
    public Optional<MemberEntity> myInfoUpdateForm(String memId) {
        return Optional.empty();
    }

    @Override
    public void myInfoUpdate(MemberEntity entity) {

    }
}
