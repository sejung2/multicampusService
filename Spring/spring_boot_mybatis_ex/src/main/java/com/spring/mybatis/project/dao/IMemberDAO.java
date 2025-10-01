package com.spring.mybatis.project.dao;

import com.spring.mybatis.project.model.MemberVO;

public interface IMemberDAO {
    public String loginCheck(String id);
    public String idCheck(String id);
    public void insertMember(MemberVO vo);
}
