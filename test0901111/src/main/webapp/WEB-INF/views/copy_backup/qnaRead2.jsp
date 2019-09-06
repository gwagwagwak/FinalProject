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
<%@ page import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/additional-methods.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/messages_ko.js"></script> --%>


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
			if(confirm("정말 삭제하시겠습니까?")){
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
			success : function(){
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
				$("#listReply").html(result);		//listReply
			}
		});
	}
</script>


</head>
<body>
	<h2>게시물 보기 연습2</h2>
	<form id="form1" name="form1" method="post" action="">
		<div>
			작성일자 : <%-- ${qna.q_date} --%>
			<fmt:formatDate value="${qna.q_date}" pattern="yyyy-MM-dd" />
			<%-- <fmt:formatDate value="${row.q_date}" pattern="yyyy-MM-dd" /> --%>
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
		<br>
		<br>
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


	<br>
	<!-- 댓글 작성 란 -->
	<div style="width: 700px; text-align: center">
		<!--현재는 로그인을 해야만 보임  -->
		<%-- <c:if test="${sessionScope.userid != null}"> --%>
		<textarea rows="5" cols="80" name="comt_content" id="comt_content"
			placeholder="댓글을 작성하세요">
				
			</textarea>
		<br>
		<button type="button" id="btnReply">댓글 작성</button>
		<%-- </c:if> --%>
	</div>



	<!-- 댓글 목록 출력 영역 -->
	<div id="listReply"></div>


</body>
</html>