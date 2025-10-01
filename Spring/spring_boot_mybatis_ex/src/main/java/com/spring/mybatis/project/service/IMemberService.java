package com.spring.mybatis.project.service;

import com.spring.mybatis.project.model.MemberVO;

import java.util.HashMap;

public interface IMemberService {

    String loginCheck(HashMap<String, Object> map);

    String idCheck(String id);

    void insertMember(MemberVO vo);
}
