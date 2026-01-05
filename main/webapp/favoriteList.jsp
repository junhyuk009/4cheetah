<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h1>즐겨찾기 목록</h1>

    <c:if test="${empty list}">
        <p>저장된 즐겨찾기가 없습니다.</p>
    </c:if>

    <c:if test="${not empty list}">
        <table border="1">
            <tr>
                <th>장소명</th>
                <th>주소</th>
                <th>위도</th>
                <th>경도</th>
            </tr>

            <c:forEach var="item" items="${list}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.address}</td>
                    <td>${item.lat}</td>
                    <td>${item.lng}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
    <form action="index.jsp" method="GET">
        <button type="submit">첫 페이지로</button>
    </form>
</div>

</body>
</html>
