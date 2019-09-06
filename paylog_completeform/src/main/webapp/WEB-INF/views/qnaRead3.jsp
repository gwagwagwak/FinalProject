<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt-rt"%> --%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!-- jquery 추가 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.js"></script>
<script type="text/javascript"
	src="http:code.jquery.com/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/main.js"></script>

<!-- 댓글 작성 추가문  -->
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/additional-methods.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/messages_ko.js"></script> --%>
<style>
body {
	padding-top: 30px;
}

.widget .panel-body {
	padding: 0px;
}

.widget .list-group {
	margin-bottom: 0;
}

.widget .panel-title {
	display: inline
}

.widget .label-info {
	float: right;
}

.widget li.list-group-item {
	border-radius: 0;
	border: 0;
	border-top: 1px solid #ddd;
}

.widget li.list-group-item:hover {
	background-color: rgba(86, 61, 124, .1);
}

.widget .mic-info {
	color: #666666;
	font-size: 11px;
}

.widget .action {
	margin-top: 5px;
}

.widget .comment-text {
	font-size: 12px;
}

.widget .btn-block {
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
}

.ui-group-buttons .or {
	position: relative;
	float: left;
	width: .3em;
	height: 1.3em;
	z-index: 3;
	font-size: 12px
}

.ui-group-buttons .or:before {
	position: absolute;
	top: 50%;
	left: 50%;
	content: '';
	background-color: #5a5a5a;
	margin-top: -.1em;
	margin-left: -.9em;
	width: 1.8em;
	height: 1.8em;
	line-height: 1.55;
	color: #fff;
	font-style: normal;
	font-weight: 400;
	text-align: center;
	border-radius: 500px;
	-webkit-box-shadow: 0 0 0 1px rgba(0, 0, 0, 0.1);
	box-shadow: 0 0 0 1px rgba(0, 0, 0, 0.1);
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box
}

.ui-group-buttons .or:after {
	position: absolute;
	top: 0;
	left: 0;
	content: ' ';
	width: .3em;
	height: 2.84em;
	background-color: rgba(0, 0, 0, 0);
	border-top: .6em solid #5a5a5a;
	border-bottom: .6em solid #5a5a5a
}

.ui-group-buttons .or.or-lg {
	height: 1.3em;
	font-size: 16px
}

.ui-group-buttons .or.or-lg:after {
	height: 2.85em
}

.ui-group-buttons .or.or-sm {
	height: 1em
}

.ui-group-buttons .or.or-sm:after {
	height: 2.5em
}

.ui-group-buttons .or.or-xs {
	height: .25em
}

.ui-group-buttons .or.or-xs:after {
	height: 1.84em;
	z-index: -1000
}

.ui-group-buttons {
	display: inline-block;
}

.ui-group-buttons:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden
}

.ui-group-buttons .btn {
	float: left;
	border-radius: 0
}

.ui-group-buttons .btn:first-child {
	margin-left: 0;
	border-top-left-radius: .25em;
	border-bottom-left-radius: .25em;
	padding-right: 15px
}

.ui-group-buttons .btn:last-child {
	border-top-right-radius: .25em;
	border-bottom-right-radius: .25em;
	padding-left: 15px
}
</style>

<title>Insert title here</title>
<script>
	$(function() {
		listReply("1"); //첫번째 페이지 댓글 목록이 나옴
		$("#btnReply").click(function() {
			reply();
		});
		$("#btnList").click(function() {
			location.href = "gtQnaList.do";
		});
		$("#btnUpdate").click(function() {
			location.href = "qnaUpdatePage.do?q_no=${qna.q_no}";
		});
		$("#btnDelete").click(function() {
			if (confirm("정말 삭제하시겠습니까?")) {
				document.form1.action = "qnaDelete.do";
				document.form1.submit();
			}

			/* location.href = "qnaDelete.do?q_no=${qna.q_no}"; */
		});
	});

	function reply() {
		var comt_content = $("#comt_content").val(); //댓글내용
		var comt_textid = "${qna.q_no}"; //원글 번호
		var param = {
			"comt_content" : comt_content,
			"comt_textid" : comt_textid
		};
		$.ajax({
			type : "post",
			url : "commentInsert.do",
			data : param,
			success : function() {
				alert("댓글이 등록되었습니다.");
				listReply("1");
			}/* ,
																		error: function(req, status, errThrown) {
																			alert("network error occur");
																		} */
		});
	}

	/*댓글 리스트 불러오기  */
	function listReply(num) {
		$.ajax({
			type : "post",
			url : "getCommentList.do?q_no=${qna.q_no}&curPage=" + num,
			success : function(result) {
				console.log(result);
				$("#listReply").html(result); //listReply
			}
		});
	}
</script>


</head>
<body>
	<%-- 	<h2>게시물 보기 연습2</h2>
	<form id="form1" name="form1" method="post" action="">
		<div>
			작성일자 :
			${qna.q_date}
			<fmt:formatDate value="${qna.q_date}" pattern="yyyy-MM-dd" />
			<fmt:formatDate value="${row.q_date}" pattern="yyyy-MM-dd" />
		</div>
		<div>이름:${qna.q_writer}</div>
		<div>제목:${qna.q_title}</div>
		<div>분류:${qna.q_divide}</div>
		<div>
			내용:
			<textarea rows="4" cols="80" name="q_content" id="q_content" readonly>${qna.q_content}</textarea>
		</div>
		<div>${qna.q_replytype}</div>
		<div>${qna.q_private}</div>
		<div>${qna.q_complete}</div>
		<br> <br>
		<div>
			<input type="hidden" name="q_no" value="${qna.q_no}">
			<c:if test="${sessionScope.userid == qna.writer}">
			<c:if test="${loginMember.m_email == qna.q_writer}">
				<button type="button" id="btnUpdate">수정</button>
				<button type="button" id="btnDelete">삭제</button>
			</c:if>
			<button type="button" id="btnList">목록</button>
		</div>
	</form>
 --%>

	<!-- <br> -->
	<!-- 댓글 작성 란 -->
	<!-- <div style="width: 700px; text-align: center"> -->
	<!--현재는 로그인을 해야만 보임  -->
	<%-- <c:if test="${sessionScope.userid != null}"> --%>
	<!-- <textarea rows="5" cols="80" name="comt_content" id="comt_content"
			placeholder="댓글을 작성하세요">
				
			</textarea>
		<br>
		<button type="button" id="btnReply">댓글 작성</button> -->
	<%-- </c:if> --%>
	<!-- </div> -->


	<div class="container">
		<h2>Q&A</h2>
		<hr>
		<div class="row">
			<form id="form1" name="form1" method="post" action="">


				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-2 col-md-6">
							<p>qna 게시글의 제목입니다.</p>
						</div>
						<div class="col-sm-10 col-md-6">
							<p>
								<fmt:formatDate value="${qna.q_date}" pattern="yyyy-MM-dd" />
							</p>
						</div>
					</div>
				</div>

				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-2 col-md-6">
							<p>${qna.q_writer}</p>
						</div>

					</div>
				</div>
				<div class="container-fluid">
					<div class="row">
						<div>
							
							<textarea rows="4" cols="80" name="q_content" id="q_content"
								readonly>${qna.q_content}</textarea>
						</div>
					</div>
				</div>

			<%-- 	<div>
					작성일자 :
					${qna.q_date}
					<fmt:formatDate value="${qna.q_date}" pattern="yyyy-MM-dd" />
					<fmt:formatDate value="${row.q_date}" pattern="yyyy-MM-dd" />
				</div>
				<div>이름:${qna.q_writer}</div>
				<div>제목:${qna.q_title}</div>
				<div>분류:${qna.q_divide}</div>
				<div>
					
					<textarea rows="4" cols="80" name="q_content" id="q_content"
						readonly>${qna.q_content}</textarea>
				</div>
				 --%>
				<br> <br>
				
				
				<div>
					<input type="hidden" name="q_no" value="${qna.q_no}">
					<%-- <c:if test="${sessionScope.userid == qna.writer}"> --%>
					<c:if test="${loginMember.m_email == qna.q_writer}">
						<button type="button" id="btnUpdate">수정</button>
						<button type="button" id="btnDelete">삭제</button>
					</c:if>
					<button type="button" id="btnList">목록</button>
				</div>



			</form>

			<!-- <div class="ui-group-buttons">
				<a href="http://www.jquery2dotnet.com" class="btn btn-danger"
					role="button"><span class="glyphicon glyphicon-pencil"
					style="padding-right: 4px;"></span>Compose</a>
				<div class="or"></div>
				<a href="http://www.jquery2dotnet.com" class="btn btn-danger"
					role="button"><span class="glyphicon glyphicon-inbox"
					style="padding-right: 4px;"></span>Inbox</a>
				<div class="or"></div>
				<a href="http://www.jquery2dotnet.com" class="btn btn-danger"
					role="button"><span class="glyphicon glyphicon-send"
					style="padding-right: 4px;"></span>Send</a>
			</div> -->

			<div class="panel panel-default widget">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-comment"></span>
					<h3 class="panel-title">Comment</h3>


				</div>

				<!--WRITE-->
				<button type="button" id="btnReply" class="[ btn btn-info ]"
					data-loading-text="Loading...">Post reply</button>
				<br>
				<div class="col">
					<div class="panel-body">
						<form role="form">
							<fieldset>
								<div class="form-group">
									<textarea class="form-control" rows="3"
										placeholder="Write in your wall" autofocus=""></textarea>
								</div>
							</fieldset>
						</form>
					</div>
				</div>


				<!-- ajax로 불러온 댓글 -->
				<!-- 	<div class="panel-body">
				<div id="listReply"></div>
			</div> -->



				<!--REPLY-->

				<div class="panel-body">
					<ul class="list-group">
						<li class="list-group-item">
							<div class="row">
								<div class="col-xs-2 col-md-1">
									<img src="http://placehold.it/80"
										class="img-circle img-responsive" alt="" />
								</div>
								<div class="col-xs-10 col-md-11">
									<div>
										<a href="#"> Congratulations</a>
										<div class="mic-info">
											By: <a href="#">Check My Athletics</a> on 12 Jun 2014
										</div>
									</div>
									<div class="comment-text">We would like to congratulate
										John on his achievement...</div>
								</div>
							</div>
						</li>
					</ul>
				</div>

				<div class="panel-body">
					<ul class="list-group">
						<li class="list-group-item">
							<div class="row">
								<div class="col-xs-2 col-md-1">
									<img src="http://placehold.it/80"
										class="img-circle img-responsive" alt="" />
								</div>
								<div class="col-xs-10 col-md-11">
									<div>
										<a href="#"> Congratulations</a>
										<div class="mic-info">
											By: <a href="#">Check My Athletics</a> on 12 Jun 2014
										</div>
									</div>
									<div class="comment-text">We would like to congratulate
										John on his achievement...</div>
								</div>
							</div>
						</li>
					</ul>
				</div>


			</div>
		</div>
	</div>




	<!-- 댓글 목록 출력 영역 -->
	<!-- <div id="listReply"></div> -->


</body>
</html>