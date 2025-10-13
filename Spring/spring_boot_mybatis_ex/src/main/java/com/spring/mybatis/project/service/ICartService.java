package com.spring.mybatis.project.service;

import com.spring.mybatis.project.model.CartVO;
import com.spring.mybatis.project.model.MemberVO;
import com.spring.mybatis.project.model.OrderInfoVO;
import com.spring.mybatis.project.model.OrderProductVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ICartService {
    // 장바구니 및 주문관련 작업 처리시 필요한 메소드들
    // 장바구니 추가
    public void insertCart(CartVO vo);

    // 장바구니 동일 상품 존재 여부 확인 메서드: parameter (상품번호, 회원번호)
    public int checkPrdInCart(String prdNo, String memId);

    // 동일 상품 존재 시 수량 변경 메서드
    public void updateQtyInCart(CartVO vo);

    // 특정 회원의 카트 리스트
    public ArrayList<CartVO> cartList(String memId);

    // 장바구니 상품 삭제 (특정)
    public void deleteCart(ArrayList<String> chkArr);

    // 주문 처리 작업에 필요한 추상 메소드
    public void updateCart(CartVO vo); // 주문 전 장바구니 수정했을 경우를 위한 메소드

    public MemberVO getMemberInfO(String memId); // 회원 정보 조회

    public void insertOrderInfo(OrderInfoVO orderInfoVO); // 주문 정보 입력

    public void insertOrderProduct(HashMap<String, Object> map); // 주문 정보 입력

    public void deleteCartAfterOrder(String memId); // 주문 완료 후 장바구니 비우기
}
