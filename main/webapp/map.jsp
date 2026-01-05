<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 검색 결과</title>
<link rel="stylesheet" href="css/style.css">

<!-- Kakao Map JS -->
<script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=16dbc186bc85ec3f50b6d76f1ad379ff"></script>
<script src="js/map.js"></script>
</head>
<body>
<input type="hidden" id="ctx" value="<%=request.getContextPath()%>">
<div class="container">
    <h1>주소 위치</h1>

    <p><b>장소명:</b> ${placeName}</p>
    <p><b>주소:</b> ${address}</p>

    <div id="map" style="width:100%;height:350px;"></div>

    <br>

    <form action="addFavorite.do" method="POST" onsubmit="return confirmAdd();">
        <input type="hidden" name="name" value="${placeName}">
        <input type="hidden" name="address" value="${address}">
        <input type="hidden" name="lat" value="${lat}">
        <input type="hidden" name="lng" value="${lng}">
        <button type="submit">즐겨찾기 추가</button>
    </form>

    <br>

    <form action="index.jsp">
        <button type="submit">주소 입력 페이지로 돌아가기</button>
    </form>
</div>

<script>
function confirmAdd() {
    return confirm("즐겨찾기에 추가할까요?");
}

let lat = ${lat};
let lng = ${lng};

let mapContainer = document.getElementById('map');
let mapOption = {
    center: new kakao.maps.LatLng(lat, lng),
    level: 3
};

let map = new kakao.maps.Map(mapContainer, mapOption);

// 마커
let marker = new kakao.maps.Marker({
    position: new kakao.maps.LatLng(lat, lng)
});
marker.setMap(map);

// 정보창
let infowindow = new kakao.maps.InfoWindow({
    content: `<div style="padding:6px;">${` ${placeName} `}<br>${` ${address} `}</div>`
});

infowindow.open(map, marker);
</script>

</body>
</html>
