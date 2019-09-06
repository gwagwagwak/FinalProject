<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
	
<!-- jquery 추가 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.js"></script>
<script type="text/javascript"
	src="http:code.jquery.com/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script>
	$(function() {
		$("#btnBusiness").click(function() {
			location.href = "registerForm_03_b.do";
		});
		$("#btnPersonal").click(function() {
			location.href = "registerForm_03_p.do";
		});
	});
</script>
<style>
.card-pricing.popular {
	z-index: 1;
	border: 3px solid #007bff;
}

.card-pricing .list-unstyled li {
	padding: .5rem 0;
	color: #6c757d;
}
</style>
</head>
<body>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->


	<div class="container mb-5 mt-5">
		<div class="pricing card-deck flex-column flex-md-row mb-3">


			<div class="card card-pricing text-center px-3 mb-4">
				<span
					class="h6 w-60 mx-auto px-4 py-1 rounded-bottom bg-primary text-white shadow-sm">Business</span>&nbsp;&nbsp;
				<div class="bg-transparent card-header pt-4 border-0">
					&nbsp;&nbsp;
					<h1 class="h1 font-weight-normal text-primary text-center mb-0"
						data-pricing-value="45">
						<img
							src="${pageContext.request.contextPath}/resources/img/66838.png"
							alt="" />&nbsp;<br />
					</h1>
				</div>
				&nbsp;
				<div class="card-body pt-0">
					<!-- <ul class="list-unstyled mb-4"> -->
					<ul>
						<li>가입 수수료나 월 수수료가 없습니다. 결제 금액을 수령할 때마다 <a href="#"">거래
								수수료</a>만 지급하면 됩니다.
						</li>
						<li>202개 국가의 25가지 통화로 전 세계에서 결제대금을 받을 수 있습니다.</li>
						<li>적합한 판매는 PayLog의 판매자 보호 프로그램이 적용됩니다.</li>

					</ul>
					<button type="button" id="btnBusiness"
						class="btn btn-outline-secondary mb-3">기업 회원가입</button>
				</div>
			</div>
			<div class="card card-pricing text-center px-3 mb-4">
				<span
					class="h6 w-60 mx-auto px-4 py-1 rounded-bottom bg-primary text-white shadow-sm">Personal</span>
				<div class="bg-transparent card-header pt-4 border-0">
					<h1 class="h1 font-weight-normal text-primary text-center mb-0"
						data-pricing-value="60">
						<img
							src="${pageContext.request.contextPath}/resources/img/60367.png"
							alt="" />
					</h1>
				</div>
				<div class="card-body pt-0">
					<!--  <ul class="list-unstyled mb-4"> -->
					<ul>
						<li>일반적으로 구매는 무료입니다. 해외 거래는 환전 수수료가 적용될 수 있습니다.</li>
						<li>전세계 수백만개의 온라인 매장에서 구매하면서 신용카드 포인트도 계속 적립할 수 있습니다.</li>
						<li>적합한 구매는 PayLog의 구매자 보호 프로그램에 따라 보호됩니다.</li>

					</ul>
					<button type="button" id="btnPersonal"
						class="btn btn-outline-secondary mb-3">개인 회원가입</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>