package com.spring.mybatis.project.service;

import com.spring.mybatis.project.dao.ICartDAO;
import com.spring.mybatis.project.model.CartVO;
import com.spring.mybatis.project.model.MemberVO;
import com.spring.mybatis.project.model.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CartService implements ICartService{

    @Autowired
    @Qualifier("ICartDAO")
    ICartDAO dao;

    @Override
    public void insertCart(CartVO vo) {
        dao.insertCart(vo);
    }

    @Override
    public int checkPrdInCart(String prdNo, String memId) {
        // dao의 동일상품 확인 메소드에서 파라미터 map 요구, dao 요구에 따라 서비스 해당 data 가공처리
        HashMap<String, Object> map = new HashMap<>();
        map.put("prdNo", prdNo);
        map.put("memId", memId);
        return dao.checkPrdInCart(map);
    }

    @Override
    public void updateQtyInCart(CartVO vo) {
        dao.updateQtyInCart(vo);
    }

    @Override
    public ArrayList<CartVO> cartList(String memId) {
        return dao.cartList(memId);
    }

    @Override
    public void deleteCart(ArrayList<String> chkArr) {
        dao.deleteCart(chkArr);
    }

    @Override
    public void updateCart(CartVO vo) {
        dao.updateCart(vo);
    }

    @Override
    public MemberVO getMemberInfO(String memId) {
        return dao.getMemberInfo(memId);
    }

    @Override
    public void insertOrderInfo(OrderInfoVO orderInfoVO) {
        // 컨트롤러에서 주문 수령인과 관계된 정보를 전달
        // (1) 주문 수령인 관련 정보 저장(orderInfo 테이블에 저장)
        dao.insertOrderInfo(orderInfoVO);
        // (2) 주문 상품 관련 정보 저장(orderProduct 테이블에 저장)
        // mapper에서 상품관련 정보 cart 테이블에서 추출 orderProduct로 저장
        // memId, ordNo 필요 -> HashMap으로 두 data 전달
        HashMap<String, Object> map = new HashMap<>();
        map.put("ordNo", orderInfoVO.getOrdNo());
        map.put("memId", orderInfoVO.getMemId());
        dao.insertOrderProduct(map);
        // (3) 주문 완료된 상품 장바구니에서 비우기(memId 필요)
        dao.deleteCartAfterOrder(orderInfoVO.getMemId());
    }

    @Override
    public void insertOrderProduct(HashMap<String, Object> map) {

    }

    @Override
    public void deleteCartAfterOrder(String memId) {

    }
}
