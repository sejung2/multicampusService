package com.spring.mvcProject2.dao;

import com.spring.mvcProject2.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class ProductDAO {
	private DataSource dataFactory;

    @Autowired
	public ProductDAO(DataSource dataFactory) {
		try {
            this.dataFactory = dataFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProductDTO> productSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 데이터 저장해서 반환할 ArrayList 객체 생성
		ArrayList<ProductDTO> productList = new ArrayList<>();
		
		
		try {
			con = dataFactory.getConnection();

			String sql = "select * from product3";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String prdNo = rs.getString("prdNo");
                String prdName = rs.getString("prdName");
                String prdPrice = rs.getString("prdPrice");
                String prdMaker = rs.getString("prdMaker");
                String prdColor = rs.getString("prdColor");
                String ctgNo = rs.getString("ctgNo");

                ProductDTO vo = new ProductDTO();
                vo.setPrdNo(prdNo);
                vo.setPrdName(prdName);
                vo.setPrdPrice(prdPrice);
                vo.setPrdMaker(prdMaker);
                vo.setPrdColor(prdColor);
                vo.setCtgNo(ctgNo);

				// ArrayList에 추가
				productList.add(vo);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		
		return productList; // ArrayList 반환
	}
}




