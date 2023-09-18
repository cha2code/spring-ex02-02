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
		height: 300,                 // 에디터 높이
		focus : true, // 에디터 로딩후 포커스를 맞출지 여부
		lang: "ko-KR",					// 한글 설정
	});
});

//기본 글꼴 설정
$('#description').summernote('fontName', 'Arial');

</script>

<br>

<h1 class="page-header">
<i class="far fa-edit"></i> 관광지 정보 수정</h1>
<div class="panel panel-default">
	<div class="panel-body">
		<form:form modelAttribute="travel" role="form">
		
			<!-- 아래 값이 존재 하면 modify / 없으면 register -->
			<!-- 둘의 form 형태가 같기 때문에 하나로 통합이 가능함 -->
			<form:hidden path="no"/>
			
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
				<i class="fas fa-check"></i> 확인
			</button>
			
			<button type="reset" class="btn btn-primary">
				<i class="fas fa-undo"></i> 취소
			</button>
			
			<a href="${cri.getLink('get')}&no=${travel.no}" class="btn btn-primary get"> <i class="fas fa-list-alt"></i> 돌아가기
			</a>
		</form:form>
	</div>
</div>

<%@ include file="../layouts/footer.jsp"%>