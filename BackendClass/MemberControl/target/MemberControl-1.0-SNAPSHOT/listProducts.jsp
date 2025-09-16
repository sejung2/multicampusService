<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <meta charset="UTF-8">
    <c:choose>
        <c:when test='${msg == "addProduct"}'>
            <script>
                window.onload = function () {
                    alert("상품을 등록했습니다.");
                }
            </script>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test='${msg == "modProduct"}'>
            <script>
                window.onload = function () {
                    alert("상품을 정보를 수정했습니다.");
                }
            </script>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test='${msg == "deleted"}'>
            <script>
                window.onload = function () {
                    alert("정보를 삭제했습니다.");
                }
            </script>
        </c:when>
    </c:choose>

    <title>상품 정보 출력창</title>
    <style>
        .cls1 {
            font-size: 40px;
            text-align: center;
        }

        .cls2 {
            font-size: 20px;
            text-align: center;
        }
    </style>

</head>
<body>
<p class="cls1">상품정보</p>
<table align="center" border="1">
    <tr align="center" bgcolor="lightgreen">
        <td width="7%"><b>상품번호</b></td>
        <td width="7%"><b>상품명</b></td>
        <td width="7%"><b>가격</b></td>
        <td width="10%"><b>제조사</b></td>
        <td width="7%"><b>색상</b></td>
        <td width="7%"><b>카테고리</b></td>
        <td width="7%"><b>수정</b></td>
        <td width="7%"><b>삭제</b></td>
    </tr>
    <c:choose>
        <c:when test="${empty productsList}">
            <tr align="center">
                <td colspan="6" class="cls2">등록된 상품이 없습니다.</td>
            </tr>

        </c:when>
        <c:when test="${!empty productsList}">
            <c:forEach var="product" items="${productsList}">
                <tr align="center">
                    <td>${product.prdNo}</td>
                    <td>${product.prdName}</td>
                    <td>${product.prdPrice}</td>
                    <td>${product.prdMaker}</td>
                    <td>${product.prdColor}</td>
                    <td>${product.ctgNo}</td>
                    <td><a href="${contextPath}/product/modProductForm.do?no=${product.prdNo}">수정</a></td>
                    <td><a href="${contextPath}/product/delProduct.do?no=${product.prdNo}">삭제</a></td>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>
</table>
<a href="${contextPath}/product/productForm.do">상품 등록하기</a>
</body>
</html>
