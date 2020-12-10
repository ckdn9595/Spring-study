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
	<form method="post" action="" id="frm">
		<input type="hidden" name="nowPage" value="${PAGE.nowPage}">
	</form>
	<div class="w3-content mw750">
		<h1 class="w3-indigo w3-center w3-round-large w3-card-4 w3-padding">파일게시판 글쓰기</h1>
		<form class="w3-col w3-margin-top w3-round-large w3-card-4 w3-padding"
			method="POST" action="/cls/board/boardWriteProc.cls" encType="multipart/form-data"
			id="wfrm" name="wfrm">
			<input type="hidden" name="id" value="${SID}">
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">작성자</label>
				<div class="w3-col m9 pdl20 w3-label">${SID}</div>
			</div>
			<div class="w3-col w3-margin-top">
				<label class="w3-col m2 w3-right-align w3-label">Title</label>
				<div class="w3-col m9 pdl20">
					<input type="text" name="title" id="title" 
							class="w3-col w3-input w3-border pdl20" placeholder="제목을 입력하세요!">
				</div>
			</div>
			<div class="w3-col w3-margin-top">
					<label class="w3-col m2 w3-right-align w3-label">File</label>
					<div class="w3-col m9 pdl20">
						<div class="w3-col w3-margin-bottom" id="filefr"><!-- 
							자바스크립트에서 태그를 추가...
					 --></div>
						<div class="w3-col w3-padding w3-center" id="fileimg"><!-- 
							이미지 파일이 추가되면 이 부분에 이미지를 보여주기로 한다.
					 --></div>
					</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col m2 w3-right-align w3-label">Message</label>
				<div class="w3-col m9 pdl20">
					<textarea name="body" id="body" 
							class="w3-col w3-input w3-border" placeholder="제목을 입력하세요!" rows="10" style="resize: none;"></textarea>
				</div>
			</div>
		</form>
		<div class="w3-col w3-margin-top w3-margin-bottom w3-card-4">
			<div class="w3-third w3-button w3-red w3-hover-deep-orange" id="cbtn">취 소</div>
			<div class="w3-third w3-button w3-green w3-hover-lime" id="hbtn">Home</div>
			<div class="w3-third w3-button w3-blue w3-hover-aqua" id="wbtn">작 성</div>
		</div>
	</div>
</body>
</html>