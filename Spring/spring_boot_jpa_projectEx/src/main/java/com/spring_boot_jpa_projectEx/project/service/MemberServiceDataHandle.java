package com.spring_boot_jpa_projectEx.project.service;

import com.spring_boot_jpa_projectEx.project.dao.MemberDAO;
import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class MemberServiceDataHandle implements IMemberServiceDataHandle{

    @Autowired
    MemberDAO dao;

    @Override
    public String loginCheck(String id) {
        Optional<MemberEntity> entity = dao.loginCheck(id);
        String pwd = entity.get().getMemPwd();
        return pwd;
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
