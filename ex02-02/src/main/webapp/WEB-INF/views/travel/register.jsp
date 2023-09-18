<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="../layouts/header.jsp"%>

<!-- summernote -->
<link rel="stylesheet"
	href="/resources/css/summernote/summernote-lite.min.css">
<script src="/resources/js/summernote/summernote-lite.js"></script>
<script src="/resources/js/summernote/lang/summernote-ko-KR.js"></script>

<script>
	$(document).ready(function() {
		$('#description').summernote({
			height : 300, // 에디터높이
			focus : true, // 에디터로딩후포커스를맞출지여부
			lang : "ko-KR",// 한글설정
		});
	});
	// 기본글꼴설정
	$('#description').summernote('fontName', 'Arial');
</script>

<br>

<%--개별페이지--%>
<h1 class="page-header">
<i class="fa-solid fa-map-location-dot"></i> 여행지 등록</h1>
<div class="panel panel-default">
	<div class="panel-body">
	
		<!-- form:form으로 인해 자동으로 post 요청 -->
		<form:form modelAttribute="travel" role="form">
			
			<div class="form-group">
				<form:label path="region">권역</form:label>
				<form:input path="region" cssClass="form-control"/>
				<form:errors path="region" cssClass="error"/>
			</div>
			
			<div class="form-group">
				<form:label path="title">제목</form:label>
				<form:input path="title" cssClass="form-control"/>
				<form:errors path="title" cssClass="error"/>
			</div>
			
			<div class="form-group">
				<form:label path="address">주소</form:label>
				<form:input path="address" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="phone">전화번호</form:label>
				<form:input path="phone" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="description">내용</form:label>
				<form:textarea path="description" cssClass="form-control" id="description" rows="10"></form:textarea>
				<form:errors path="description" cssClass="error"/>
			</div>

			<button type="submit" class="btn btn-primary">
				<i class="fa-solid fa-check"></i> 확인
			</button>
			
			<button type="reset" class="btn btn-primary">
				<i class="fas fa-undo"></i> 취소
			</button>
			
			<!-- href:url이 아닌 javascript로 실행 -->
			<!-- 상황에 따라 적절하게 사용해야 함 (예외 상황도 있음) -->
			<a href="javascript:history.back()" class="btn btn-primary"> <i class="fas fa-list"></i> 목록</a>
		</form:form>
	</div>
</div>
<%@ include file="../layouts/footer.jsp"%>