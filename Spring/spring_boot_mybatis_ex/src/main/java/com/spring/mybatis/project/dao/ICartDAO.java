package com.spring.mybatis.project.dao;

import com.spring.mybatis.project.model.CartVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ICartDAO {

    // 장바구니 및 주문관련 작업 처리시 필요한 메소드들
    // 장바구니 추가
    public void insertCart(CartVO vo);

    // 장바구니 동일 상품 존재 여부 확인 메서드: parameter (상품번호, 회원번호)
    public int checkPrdInCart(HashMap<String, Object> map);

    // 동일 상품 존재 시 수량 변경 메서드
    public void updateQtyInCart(CartVO vo);

    // 특정 회원의 카트 리스트
    public ArrayList<CartVO> cartList(String memId);

    // 장바구니 상품 삭제 (특정)
    public void deleteCart(ArrayList<String> chkArr);
}
