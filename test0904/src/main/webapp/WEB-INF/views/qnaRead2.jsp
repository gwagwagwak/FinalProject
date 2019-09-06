<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt-rt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	$(function(){
		$("#btnReply").click(function(){
			reply();
		});	
	};


	function reply(){
		var comt_content = ${"#comt_content"}.val();		//댓글내용
		var comt_textid = "${qna.q_no}";					//원글 번호
		var param = {"comt_content": replytext, "comt_textid":comt_textid};
		$.ajax({
			type: "post",
			url: "commentInsert.do",
			data: param,
			success: function(){
				alert("댓글이 등록되었습니다.");
			}
		});
	}


</script>


</head>
<body>
	<h2>게시물 보기 연습</h2>
	<form id="form1" name="form1" method="post">
		<div>
			작성일자 :
			
			<%-- <fmt:formatDate value="${qna.q_date}" pattern="yyyy-MM-dd" /> --%>
		</div>
		<div>이름:${qna.q_writer}</div>
		<div>제목:${qna.q_title}</div>
		<div>분류:${qna.q_divide}</div>
		<div>
			내용:
			<textarea rows="4" cols="80" name="q_content" id="q_content">${qna.q_content}</textarea>
		</div>
		<div>:${qna.q_complete}</div>
		<div>
			<input type="hidden" name="q_no" value="${qna.q_no}">
			<%-- <c:if test="${sessionScope.userid == qna.writer}"> --%>
			<%-- <c:if test="${loginMember.m_email == qna.writer}">
				<button type="button" id="btnUpdate">수정</button>
				<button type="button" id="btnDelete">삭제</button>
			</c:if> --%>
			<button type="button" id="btnUpdate">수정</button>
			<button type="button" id="btnDelete">삭제</button>

			<button type="button" id="btnList">목록</button>
		</div>
	</form>
	<br>
	<!-- 댓글 작성 란 -->
	<div style="width: 700px; text-align:center">
		<!--현재는 로그인을 해야만 보임  -->
		<%-- <c:if test="${sessionScope.userid != null}"> --%>
			<textarea rows="5" cols="80" name="comt_content" id="comt_content" placeholder="댓글을 작성하세요">
				
			</textarea>
			<br>
			<button type="button" id="btnReply">댓글 작성</button>
		<%-- </c:if> --%>
	</div>
	
	<!-- 댓글 목록 출력 영역 -->
	<div id="listReply">
	
	
	</div>
	

</body>
</html>