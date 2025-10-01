package com.spring.mybatis.project.service;

import com.spring.mybatis.project.dao.IMemberDAO;
import com.spring.mybatis.project.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService implements IMemberService {

    @Autowired
    @Qualifier("IMemberDAO")
    IMemberDAO dao;

    @Autowired
    PasswordEncoder pwd;

    // 비밀번호 암호화 하지 않은 경우의 처리
//    @Override
//    public String loginCheck(HashMap<String, Object> map) {
//        return dao.loginCheck(map);
//    }

    @Override
    public String loginCheck(HashMap<String, Object> map) {
        // 로그인여부 서비스가 결정(id만 dao로 전달해서 id의 레코드가 있으면 비밀번호 전달)
        String encodedPwd = dao.loginCheck((String) map.get("id"));

        String result = "fail";
        if (encodedPwd != null && pwd.matches((String) map.get("pwd"), encodedPwd)) {
            result = "success";
        }
        return result;
    }

    @Override
    public String idCheck(String id) {
        return dao.idCheck(id);
    }

    @Override
    public void insertMember(MemberVO vo) {
        // 비밀번호 암호화 처리
        String encodedPwd = pwd.encode(vo.getMemPwd());
        vo.setMemPwd(encodedPwd);

        dao.insertMember(vo);
    }
}
