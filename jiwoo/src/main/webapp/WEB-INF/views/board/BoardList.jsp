<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Board List</title>
<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/cls/js/board.js"></script>

<script type="text/javascript">
/* 	alert('${LIST.get(0).cnt}'); */
</script>
</head>
<body>
	<form method="POST" action="" id="bfrm">
		<input type="hidden" name="bno" id="bno" value="">
		<input type="hidden" name="nowPage" id="nowPage" value="${PAGE.nowPage}">
	</form>

	<div class="w3-content mw800">
		<!-- top -->
		<div class="w3-col w3-center w3-card-4">
			<!-- 타이틀 -->
			<div class="w3-col w3-pink w3-padding txt24">CLS 파일 게시판</div>
			
			<!-- 메뉴 -->
			<div class="w3-col">
				<div class="w3-col m1 w3-deep-orange w3-hover-lime w3-button w3-tiny w3-left" 
					id="hbtn">home</div>
	<c:if test="${not empty SID}">
				<div class="w3-col m1 w3-red w3-hover-deep-orange w3-button w3-tiny w3-right" 
					id="obtn">logout</div>
				<div class="w3-col m1 w3-deep-purple w3-hover-deep-orange w3-button w3-tiny w3-right" 
					id="rbtn">write</div>
	</c:if>
	<c:if test="${empty SID}">
				<div class="w3-col m1 w3-deep-purple w3-hover-deep-orange w3-button w3-tiny w3-right" 
					id="lbtn">login</div>
				<div class="w3-col m1 w3-purple w3-hover-deep-orange w3-button w3-tiny w3-right" 
					id="jbtn">join</div>
	</c:if>
				<div class="w3-rest w3-purple" style="opacity: 0.7; height: 31px;"> </div>
			</div>
		</div>
		
		<!-- 게시글리스트 -->
		<div class="w3-col w3-margin-top w3-padding w3-card-4">
			<div class="w3-col w3-center w3-border w3-margin-top">
				<div class="w3-col m1 w3-light-grey w3-border-right">글번호</div>
				<div class="w3-col m2 w3-light-grey w3-border-right">작성자</div>
				<div class="w3-col m5 w3-light-grey w3-border-right">글제목</div>
				<div class="w3-col m3 w3-light-grey w3-border-right">작성일</div>
				<div class="w3-col m1 w3-light-grey">조회수</div>
			</div>
<c:if test="${not empty LIST}">
			<div class="w3-col w3-border-left w3-border-right w3-margin-bottom">
		<c:forEach var="data" items="${LIST}">
					<div class="w3-col w3-center w3-hover-lime w3-border-bottom brow" id="${data.bno}">
					<div class="w3-col m1 w3-border-right">${data.bno}</div>
					<div class="w3-col m2 w3-border-right">${data.id}</div>
					<div class="w3-col m5 w3-border-right w3-left-align pdl10">
		<c:if test="${data.cnt != 0}">
						<span class="w3-text-blue"><b>[첨부파일]</b></span>
		</c:if>
						${data.title}
					</div>
					<div class="w3-col m3 w3-border-right">${data.sdate}</div>
					<div class="w3-col m1">${data.click}</div>
				</div>
	</c:forEach>
			</div>
</c:if>
		</div>
		
		<!-- 페이징 버튼 -->
		<div class="w3-col w3-center w3-margin-top w3-margin-bottom">
			<form class="w3-bar w3-border w3-round" method="POST" action="/cls/board/boardList.cls" name="pfrm" id="pfrm">
				<!-- 이전버튼 처리 -->
				<c:if test="${PAGE.startPage != 1}">
					<span class="w3-bar-item w3-button w3-hover-lime pagebtn" id="${PAGE.startPage - 1}">&laquo;</span>
				</c:if>
				<c:if test="${PAGE.startPage == 1}">
					<span class="w3-bar-item w3-light-grey">&laquo;</span>
				</c:if>
				<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
					<c:if test="${page == PAGE.nowPage}">
						<span class="w3-bar-item w3-button w3-green w3-hover-lime pagebtn">${page}</span>
					</c:if>
					<c:if test="${page != PAGE.nowPage}">
						<span class="w3-bar-item w3-button w3-hover-lime pagebtn">${page}</span>
					</c:if>
				</c:forEach>
				<!-- 다음버튼 처리 -->
				<c:if test="${PAGE.endPage != PAGE.totalPage}">
						<span class="w3-bar-item w3-button w3-hover-lime pagebtn" id="${PAGE.endPage + 1}">&raquo;</span>
				</c:if>
				<c:if test="${PAGE.endPage == PAGE.totalPage}">
					<span class="w3-bar-item w3-light-grey">&raquo;</span>
				</c:if>
			</form>
		</div>
	</div>
</body>
</html>