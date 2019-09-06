<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Home</title>

<!-- 
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 -->

<!-- 부트스트랩 3 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>



<script>
	/*  글쓰기 버튼 작동 jquery*/
	$(function() {
		$("#btnWrite").click(function() {
			/* location.href="${path}/qna/qnaWrite.do"; */
			location.href = "qnaWritePage.do";
			/* location.href = "&{path}/qna/qnaWritePage.do"; */
		})
	});

	/* 페이징 처리 스크립트 */
	function list(page) {
		location.href = "qnaReplyIncomplete.do?curPage=" + page;

	};
	
	/*페이징 글 번호   */
	/* ${map.count}, ${map.pager.curPage} */
	
</script>



<!-- 부트스트랩 4 버전 -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

 -->

<!-- include로 헤더 포함 -->
<%-- 	<%@ include file="../include/header.jsp" %> --%>


<style>
thead {
	background-color: #ADD8E6;
	font-size: 20px;
}

td.number_dot:after {
	content: ". ";
	margin-right: 10px;
}
</style>


</head>
<body>


	<!-- include로 네비바 추가 -->
	<%-- <%@ include file="../include/menu.jsp" %> --%>

	<!-- 네비게이션 바~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  -->

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">PayLog</a>
		</div>

		<ul class="nav navbar-nav ">
			<li class="active"><a href="#">개인</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">구매 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">모바일 구매</a></li>
					<li><a href="#">온라인 구매</a></li>
				</ul></li>

			<li><a href="#">카드</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</div>
	</nav>


	<!--qna list table~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  -->

	<div class="container">

		<!-- 완료, 미완료 구분 버튼 ===================================================================== -->
		<!--
	 <div class="btn-toolbar">
		<button class="btn btn-primary">New User</button>

		<button class="btn disabled">
			<strong>Complete</strong>
		</button>
		<button class="btn">
			<strong>Incomplete</strong>
		</button>
	</div>
	
 -->


		<h2>Q&A</h2>
		<h3>${loginMember.m_lname}</h3>
		<br>
		<ul class="nav nav-tabs">
			<li ><a href="qnaReplyComplete.do"><Strong>Complete</Strong></a></li>
			<li class="active"><a href="#"><Strong>Incomplete</Strong></a></li>
		</ul>
	
		
		<!-- <button type="button" id="btnWrite" class="btn btn-info float-right">글 작성</button> -->
		<!--글 작성 버튼  -->
		<%-- <div class="container">
            <div class="container-fluid full-width">
				총 ${map.incomplete_count}개의 게시물이 있습니다.
				<button type="button" id="btnWrite" class="btn btn-info pull-right" style="align:right">글 작성</button>
			</div>
		</div> --%>
		
		<!-- 테이블 리스트 =============================================================================== -->
		<!-- test table -->
		<div class="well">
			<table class="table">
				<thead>
					<tr>
						<th style="width: 70px">No.</th>
						<th style="width: 150px">Division</th>
						<th style="width: 670px">Title</th>
						<th style="width: 180px">Writer</th>
						<th style="width: 160px">Date</th>
						<th style="width: 60px">check</th>
					</tr>
				</thead>
				<!-- <span class="glyphicon glyphicon-pencil"></span>
				<span class="glyphicon glyphicon-ok"></span> -->
				<tbody>
					<c:forEach var="row" items="${map.incomplete_qlist}" varStatus="i">
						<tr>
							<!--글번호  -->
							<!--
								!!!!!!!!!!!!!!!!!!!!!!!게시물 순번
								전체 레코드 수 - ( (현재 페이지 번호 - 1) * 한 페이지당 보여지는 레코드 수 + 현재 게시물 출력 순서 )
							  	${count} -(${pager.curPage}-1) * 10 + 0(0번부터 9번까지 한페이지에 들어감) 
							  -->
							<%-- <td class="number_dot">${row.q_no}</td> --%>
							<td class="number_dot">
								<strong>${map.count -((map.pager.curPage - 1)*10 + i.index)}</strong>
							</td>
							<%-- <td class="number_dot">${row.q_no}</td> --%>

							<td><strong>${row.q_divide}</strong></td>
							<td>
			
								<!--관리자용은 비밀글 확인 + 모든 글 열람 가능  -->
								<c:choose>
									<c:when test="${row.q_private eq 'private'}">
										<strong><a href="qnaRead2.do?q_no=${row.q_no}&curPage=${map.pager.curPage}">${row.q_title}</a></strong>&nbsp;&nbsp;<span class="glyphicon glyphicon-lock"></span></strong>
									</c:when>
									<c:otherwise>
										<strong><a href="qnaRead2.do?q_no=${row.q_no}&curPage=${map.pager.curPage}">${row.q_title}</a></strong>
									</c:otherwise>
								</c:choose>
							
							</td>
							<td>
								<c:set var="dott" value="...."/>
								<Strong>${fn:substring(row.q_writer,0,5)}${dott}</Strong>
								
							</td>
							<td>
								<fmt:formatDate value="${row.q_date}" pattern="yyyy-MM-dd" />
							</td>
							<!--pattern="yyyy-MM-dd HH:mm:ss"  -->
							<td>
								<c:choose>
									<c:when test="${row.q_complete eq '답변미완료'}">
								  		<span class="glyphicon glyphicon-remove"></span>
									</c:when>
									<c:otherwise>
										<span class="glyphicon glyphicon-ok"></span>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>

					<!--페이징 :pager  -->
					<%--  <tr>
						<td colsapn="5" align="center">
							<c:if test="${map.pager.curBlock > 1}">
								<a href="javascript:list('1')">[처음]</a>
							</c:if>
							
							<c:if test="${map.pager.curBlock > 1}">
								<a href="javascript:list('${map.pager.prevPage}')">[이전]</a>
							</c:if>
							
							<c:forEach var="num" begin="${map.pager.blockBegin}" end="${map.pager.blockEnd}">
								<c:choose>
									<c:when test="${num == map.pager.curPage}">
										<sapn style="clolr:red;">${num}</span>&nbsp;
									</c:when>
									<c:otherwise>
										<a href="javascript:list('${num}')">${num}</a>&nbsp;
									</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<c:if test="${map.pager.curBlock <= map.pager.totBlock}">
								<a href="javascript:list('${map.pager.nextPage}')">[다음]</a>
							</c:if>
								
							<c:if test="${map.pager.curPage <= map.pager.totPage}">
								<a href="javascript:list('${map.pager.totPage}')">[끝]</a>
							</c:if>
							
						</td>
					</tr>  --%>
					<%-- 페이징 처리 기초 예시 
							<c:forEach var="num" begin="1"
								end="${map.pager.totPage}">
								<a href="javascript:list('${num}')">${num}</a>
							</c:forEach> --%>
				</tbody>
			</table>




			<!-- ================== -->
			<div class="container" align="center">
				<ul class="pagination">

					<!-- 페이징 부분 -->
					<c:if test="${map.pager.curBlock > 1}">
						<li><a href="javascript:list('1')">[처음]</a></li>
					</c:if>

					<c:if test="${map.pager.curBlock > 1}">
						<li><a href="javascript:list('${map.pager.prevPage}')">[이전]</a></li>
					</c:if>

					<c:forEach var="num" begin="${map.pager.blockBegin}"
						end="${map.pager.blockEnd}">
						<c:choose>
							<c:when test="${num == map.pager.curPage}">
								<%-- <li><span style="clolr:red;">${num}</span>&nbsp;</li> --%>
								<%-- 								<li><a href="#" target="blank" style="color: red; font-weight: bold">${num}</a>&nbsp;</li> --%>
								<li><span style="color: #FF6347; font-weight: bold">${num}</span>&nbsp;</li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:list('${num}')">${num}</a>&nbsp;</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${map.pager.curBlock <= map.pager.totBlock}">
						<li><a href="javascript:list('${map.pager.nextPage}')">[다음]</a></li>
					</c:if>

					<c:if test="${map.pager.curPage <= map.pager.totPage}">
						<li><a href="javascript:list('${map.pager.totPage}')">[끝]</a></li>
					</c:if>
				</ul>
			</div>




			<!--페이징 처리 : Pager  -->
			<!-- <div class="container" align="center">
				<ul class="pagination">
					<li><a href="#">Prev</a></li>
					<li><a href="#">1</a></li>
					<li class="active"><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</div> -->
		</div>

		<!-- 페이지네이션~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
		<!-- <div class="pagination" align="center">
		<ul>
			<li><a href="#">Prev</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">Next</a></li>
		</ul>
	</div> -->




	</div>




	<div class="modal small hide fade" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Delete Confirmation</h3>
		</div>
		<div class="modal-body">
			<p class="error-text">Are you sure you want to delete the user?</p>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
			<button class="btn btn-danger" data-dismiss="modal">Delete</button>
		</div>
	</div>

</body>
</html>