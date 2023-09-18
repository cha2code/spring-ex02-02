<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../layouts/header.jsp"%>

<script>
$(document).ready(function() {

	$('.remove').click(function(){
		if(!confirm('정말 삭제할까요?')) return;
		document.forms.removeForm.submit();
	});	
}); 

</script>

<br>

<h1 class="page-header">
	<i class="far fa-file-alt"></i> ${travel.title}
</h1>

<br>

<div class="d-flex justify-content-between">
	
	<div>
		<i class="fas fa-user"></i> ${travel.region}
	</div>
	
	<div>
		<i class="fa-solid fa-location-dot"></i> ${travel.address}
	</div>
	
	<div>
		<i class="fa-solid fa-phone"></i> ${travel.phone}
	</div>
	
</div>

<hr>

<div>${travel.description}</div>

<br>

<!-- 지도 영역 설정 -->
<div id="map" style="width:100%;height:300px;background:gray"></div>

<div class="mt-4">
	<a href="${cri.getLink('list')}" class="btn btn-primary list"><i class="fas fa-list"></i> 목록</a>
	<a href="${cri.getLink('modify')}&no=${travel.no}" class="btn btn-primary modify"> <i class="far fa-edit"></i> 수정</a>
	<a href="#" class="btn btn-danger remove"> <i class="far fa-trash-alt"></i> 삭제</a>
</div>

<form action="remove" method="post" name="removeForm">
	<input type="hidden" name="no" value="${travel.no}" />
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}" />
	<input type="hidden" name="keyword" value="${cri.keyword}" />
</form>

<!-- javascript로 dom 처리 -->
<!-- map을 생성 후 고정된 좌표로 이동 후 빠르게 비동기 파트 실행 -->
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=549b4a588c392d67d9937e3a07032a20&libraries=services">
</script>
<script>

	let geocoder = new kakao.maps.services.Geocoder();
	let address = '${travel.address}'; // address로 지도 위치 지정
	
	// 비동기 : callback 등록
	geocoder.addressSearch(address, function(result, status){ // result = Array
		
		// 주소를 찾았을 때만 출력
		if(status === kakao.maps.services.Status.OK){
			
			// 배열의 첫번째 위치로 이동
			// result[0].y, result[0].x : 좌표로 찍힘
			let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
			// 'map' : 해당 div 태그에 대한 참조를 리턴
			let mapContainer = document.getElementById('map');
			
			let mapOption = {
					center: coords, // 중심 좌표
					level: 3 // 지도의 확대 레벨
			};
			
			let map = new kakao.maps.Map(mapContainer, mapOption);
			
			let marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});
		}
	
		// address에 입력 된 문자열이 주소가 아닌 경우
		else {
			
			alert("잘못된 주소입니다.");
		}
		
	})
</script>
<%@ include file="../layouts/footer.jsp"%>