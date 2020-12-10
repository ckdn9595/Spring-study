<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cls/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cls/css/cls.css">
<script type="text/javascript" src="/cls/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/cls/js/board.js"></script>
</head>
<body>
	<form method="POST" action="/cls/board/boardEdit.cls" id="frm">
		<input type="hidden" name="bno" value="${DATA.bno}">
		<input type="hidden" name="nowPage" value="${param.nowPage}">
	</form>
	<div class="w3-content mw750">
		<h1 class="w3-indigo w3-center w3-round-large w3-card-4 w3-padding">파일게시글 상세보기</h1>
		<div class="w3-col pd20 w3-margin-top w3-round-large w3-card-4 w3-padding">
			<div class="w3-col pd10 w3-margin-top">
				<label class="w3-col m2 w3-right-align">작성자 : </label>
				<div class="w3-col m9 pdl20"><span class="pdl20">${DATA.id}</span></div>
			</div>
			<div class="w3-col pd10 w3-margin-top">
				<label class="w3-col m2 w3-right-align">Title : </label>
				<div class="w3-col m9 pdl20">
					<div class="w3-col pdl20">${DATA.title}</div>
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col m2 w3-right-align">File : </label>
				<div class="w3-col m9 w3-center w3-margin-bottom pdl20 filefr">
	<c:forEach var="fdata" items="${LIST}">
					<div class="imgboxfr w3-border w3-center ">
						<div class="w3-margin-bottom imgbox3">
							<a href="/cls/img/upload/${fdata.savename}" class="inblock w3-display-container imgfr2">
								<img src="/cls/img/upload/${fdata.savename}" class="w3-display-middle imgsrc2" onLoad="resize(this, 'addImgW', 'addImgH')">
							</a>
							<span class="inblock w3-margin-bottom w3-text-grey imgname"><small><b>${fdata.oriname.substring(0, 8)}...</b></small></span>
						</div>
					</div>
	</c:forEach>
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col m2 w3-right-align w3-label">Message : </label>
				<div class="w3-col m9 pdl20">
					<div class="w3-col h70 pdl20">${DATA.body}</div>
				</div>
			</div>
		</div>
		<div class="w3-col w3-margin-top w3-margin-bottom">
			<div class="w3-third w3-button w3-card-4 w3-red w3-hover-deep-orange" id="cbtn">취 소</div>
	<c:if test="${SID eq DATA.id}">
			<div class="w3-third w3-button w3-card-4 w3-blue w3-hover-aqua w3-right" id="ebtn">수정</div>
	</c:if>
			<div class="w3-third w3-button w3-card-4 w3-green w3-hover-lime w3-right" id="hbtn">Home</div>
		</div>
	</div>
</body>
</html>