<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>등록 결과</title>
</head>
<body>
<h1>등록 결과</h1>

상품 번호: ${prdNo} <br>
상품명: ${prdName} <br>
가격: ${prdPrice} <br>
제조회사: ${prdCompany} <br>
제조일: ${prdDate} <br>
재고: ${prdStock} <br>

url을 통한 데이터 전달 <br>
품명을 서버로 전달해서 해당 품명의 정보를 확인 <br>
https://localhost:8080/product/productDetailView/청소기 <br>
품명: <a href="${pageContext.request.contextPath}/product/productDetailView/${prdName}">${prdName}</a> <br>
url 통한 데이터 여러개 전달 <br>
품명: <a href="${pageContext.request.contextPath}/product/productDetailView/${prdName}/${prdStock}/${prdNo}">${prdName}</a> <br>
</body>
</html>
