<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../layouts/header.jsp"%>



<!-- 가로줄 긋기 -->
<hr>

<h1 class="page-header my-5">
	<i class="fas fa-list"></i> 관광지 목록
</h1>

<%@ include file="../common/search_bar.jsp" %>

<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th style="width: 60px">No</th>
			<th style="width: 100px">권역</th>
			<th>제목</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="travel" items="${list}">
			<tr>
				<td>${travel.no}</td>
				<td>${travel.region}</td>
				<td><a href="${cri.getLink('get')}&no=${travel.no}">${travel.title}</a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<div class="text-right">
	<a href="register" class="btn btn-dark"> <i class="far fa-edit"></i>
		추가
	</a>
</div>

<%@include file="../common/pagination.jsp"%>

<%@include file="../layouts/footer.jsp"%>