<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../layouts/header.jsp"%>

<!-- summernote -->
<link rel="stylesheet"
	href="/resources/css/summernote/summernote-lite.min.css">
<script src="/resources/js/summernote/summernote-lite.js"></script>
<script src="/resources/js/summernote/lang/summernote-ko-KR.js"></script>

<script>
	$(document).ready(function() {
		$('#content').summernote({
			height : 300, // 에디터높이
			focus : true, // 에디터로딩후포커스를맞출지여부
			lang : "ko-KR",// 한글설정
		});
	});
	// 기본글꼴설정
	$('#content').summernote('fontName', 'Arial');
</script>

<br>

<%--개별페이지--%>
<h1 class="page-header">
	<i class="far fa-edit"></i> Board Register
</h1>
<div class="panel panel-default">
	<div class="panel-body">
		<form role="form" method="post">
			<div class="form-group">
				<label>Title</label> <input name="title" class="form-control">
				<!-- name은 BoardVO에 있는 멤버변수 이름을 사용 -->
			</div>
			<div class="form-group">
				<label>Writer</label> <input name="writer" class="form-control">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" id="content" name="content" rows="10"></textarea>
			</div>

			<button type="submit" class="btn btn-primary">
				<i class="fa-solid fa-check"></i> 확인
			</button>
			<button type="reset" class="btn btn-primary">
				<i class="fas fa-undo"></i> 취소
			</button>
			<!-- href:url이 아닌 javascript로 실행 -->
			<!-- 상황에 따라 적절하게 사용해야 함 (예외 상황도 있음) -->
			<a href="javascript:history.back()" class="btn btn-primary"> <i class="fas fa-list"></i> 목록
			</a>
		</form>
	</div>
</div>
<%@ include file="../layouts/footer.jsp"%>