<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<head>
    <meta charset="UTF-8">
    <title>상품 정보 수정창</title>
    <style>
        .cls1 {
            font-size: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1 class="cls1">상품 정보 수정창</h1>
<form method="post" action="${contextPath}/product/modProduct.do?id=${productInfo.prdNo}">
    <table align="center">
        <tr>
            <td width="200"><p align="right">상품번호</td>
            <td width="400"><input type="text" name="prdNo" value="${productInfo.prdNo}" disabled></td>

        </tr>
        <tr>
            <td width="200"><p align="right">상품명</td>
            <td width="400"><input type="password" name="prdName" value="${productInfo.prdName}">
            </td>
        </tr>
        <tr>
            <td width="200"><p align="right"> 상품가</td>
            <td width="400"><input type="text" name="prdPrice" value="${productInfo.prdPrice}"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">제조사</td>
            <td width="400"><input type="text" name="prdMaker" value="${productInfo.prdMaker}"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">색상</td>
            <td width="400"><input type="text" name="prdColor" value="${productInfo.prdColor}"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">분류번호</td>
            <td width="400"><input type="text" name="ctgNo" value="${productInfo.ctgNo}"></td>
        </tr>
        <tr align="center">
            <td colspan="2" width="400"><input type="submit" value="수정하기">
                <input type="reset" value="다시입력"></td>
        </tr>
    </table>
</form>
</body>
</html>
