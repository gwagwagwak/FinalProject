<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<title>Login V19</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- js -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/additional-methods.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/plugins/validate/messages_ko.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/main.js"></script>

<!-- css -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">


<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- 다음 도로명 주소 api  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>




<!------ Include the above in your HEAD tag ---------->


<style>
form * {
	border-radius: 1 !important;
}

form>fieldset>legend {
	font-size: 120%;
}

/* 
/* label.error{
	color:red;
	font-style: italic;
}
input.error{
	border : 1px dotted red !important;
}
  */
</style>


<script>
	/* 다음 도로명 주소 코드  */
	function showPostcode(){
		new daum.Postcode({
			oncomplete : function(data){
				var fullAddr = '';
				var extrAddr = '';
			
				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if(data.userSelectedType == 'R'){
					//사용자가 도로명 주소를 선택했을 경우
					fullAddr = data.roadAddress;
				}else{ //사용자가 지번 주소를 선택했을 경우(J)
					fullAddr = data.jibunAddress;
				}
			
				//사용자가 선택한 주소가 도로명 타입일때 조합한다
				if(data.userSelectedType == 'R'){
					//법정동명이 있을 경우 추가함
					if(data.bname !== ''){
						extrAddr += data.bname;
					}
					//법정동명이 있을 경우 추가함
					if(data.buildingName !== ''){
						extrAddr += (extrAddr !== '' ? ', '
							+ data.buildingName : data.buildingName);
					}
					//조합형 주소의 유무에 따라 양쪽 괄호를 추가하여 최종 주소를 만든다.
					fullAddr += (extrAddr !== '' ? ' (' +extrAddr
						+ ')' : '');
				}
				
				
				//우편번호와 주소 정보를 해당 필드에 넣는다. &  5자리 새 우편 번호 사용
				document.getElementById('post_code').value = data.zonecode;  	//우편번호5자리
				document.getElementById('m_addr').value = fullAddr;				//주소값
				//커서를 상세주소 필드로 이동
				document.getElementById('m_addr2').focus();
			}
		}).open();
	}

	
	
	


	/* 에이젝스 회원가입 이메일 중복확인                                 */
	/* $(function(){
		$("#btnCheckId").click(function(){
			var m_email = $("#m_email").val();
			
			if(m_email == "" || m_email==" "){
				alert("이메일을 입력해 주세요.")
			}else{
				var url = "${_ctx}/user/id/available";
				$.post(url, {m_email : m_email}, function(json){
					console.log(json) 
				});
			}
		});
	});
	 */

	/* 회원가입 란 validate  */
	$(function() {
		$("#joinBlock").validate();
		
		/* $("#btnCheckId").click(function(){
			var m_email = $("#m_email").val();
			if(m_email == "" || m_email == " "){
				alert("Email을 입력해 주세요")
			}else{
				var url = "emailputcheck.do"
				//map 키값 형태로  데이터를 url경로로 보낸다
				$.post(url, {m_email : m_email}, function(){	
					console
				});
			}
		}); */
	});

	 function registerCheckFucntion(){
		 var m_email = $("#m_email").val();
		 $.ajax({
			 type : "post",
			url : "emailputcheck.do",
			data : {m_email : m_email},
			success: function(result){
				if(result ==1){
					$("#checkMessage").html('사용할 수 있는 이메일입니다.');
					$("#checkType").attr("class", "modal-content panel-success");
				}else{
					$("#checkMessage").html('사용할 수 없는 이메일입니다.');
					$("#checkType").attr("class", "modal-content panel-warning");
				}
				$("#checkModal").modal("show");
			}
		 });		 
	 }
	 
	 
	function doJoin() {
		if ($("#joinBlock").valid()) {
			alert(11);
		}
	}
	/* 
		
		jQuery.validator.setDefaults({
			debug: true
			success: "valid"
		});
		$("joinBlock").validate({
			rules:{
				m_pw: "required"
				m_pw_check:{
					equalTo: #"m_pw";
				}
			}
		});
	 */

	$(document).ready(
			function() {
				$('#found_site').on(
						'change',
						function() {
							$(this).val() == "other" ? $('#specify').closest(
									'.form-group').show() : $('#specify')
									.closest('.form-group').hide();
						})
			})
</script>
</head>
<body>
<br><br><br><br>
	<div class="container">
		<div class="row">

			<div class="col-md-8 col-md-offset-2">
				<form id="joinBlock" name="joinBlock" role="form1" method="POST"
					action="memberInsert.do">

					<legend class="text-center">Register</legend>

					<fieldset>
						<legend>Account Details</legend>
						
						<div class="form-group col-md-12">
							<label for="">Email</label> 
							<input type="email"
							class="form-control" name="m_email" id="m_email"
							placeholder="Email" title="Email을 입력하세요" maxlength="30" style="width:70%;" required>
							<button type="button" id="btnCheckId" onclick="registerCheckFucntion();">Email 중복확인</button>
							<!-- ajax 아이디 중복 확인 -->
							<!-- <div class="check_font" id="id_check"></div> -->
						</div>


						<!-- <input type="hidden"  -->

						<div class="form-group col-md-6">
							<label for="first_name">First name</label> <input type="text"
								class="form-control error" name="m_fname" id="m_fname"
								placeholder="First Name" required  title="Email을 입력하세요">
						</div>

						<div class="form-group col-md-6">
							<label for="last_name">Last name</label> <input type="text"
								class="form-control error" name="m_lname" id="last_name"
								placeholder="Last Name" required>
						</div>


						<!-- 					<div class="form-group col-md-10">
							<label for="">Email</label> <input type="email"
								class="form-control" name="m_email" id="" placeholder="Email">
						</div>
						아이디 체크 버튼 
						<div class="form-group">
							<div class="col-md-2">
								<button type="submit" class="btn btn-primary">ID check</button>
							</div>
						</div>
 -->
						<!-- <div class="form-group"> -->
						<!-- 	<div>
							<div class="col-md-8">
								<label for="">Email</label> <input type="email"
									class="form-control" name="m_email" id="" placeholder="Email">
							</div>
							<div class="col-md-2">
							<label for="btnCheckID"></label> 
								<button type="button" class="btn" name="btnCheckID" id="btnCheckID" style="margin-top:25px">ID check</button>
							</div>

						</div>

 -->
						

						<!-- ------------------------------------------------ -->

						<!--체크버튼 -->
						<!-- 	<div class="form-group col-md-12">
						<button id="btnCheckId">Email Check</button>
						안녕하세요
						
						</div> -->

						<!-- 체크 버튼 -->
						<!-- <div class="col-md-2">
							<label for="btnCheckID"></label>
							<button type="button" class="btn" name="btnCheckID"
								id="btnCheckID" style="margin-top: 25px">ID check</button>
						</div> -->



						<div class="form-group col-md-6">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="m_pw" id="m_pw"
								placeholder="Password" maxlength="20" required >
						</div>



						<div class="form-group col-md-6">
							<label for="confirm_password">Confirm Password</label> <input
								type="password" class="form-control" name="m_pw_check"
								id="m_pw_check" placeholder="Password Check" equalTo="#m_pw"
								data-msg-equalTo="패스워드가 일치하지 않습니다." required>
						</div>

						<div class="form-group col-md-6">
							<label for="Phone">Phone</label> <input type="text"
								class="form-control" name="m_hp" id="m_hp"
								placeholder="Your Cell Phone Number" required>
						</div>


						<div class="form-group col-md-6">
							<label for="country">Country of Residence</label> <select
								class="form-control" name="m_nation" id="m_nation">
								<option value="korea" selected="selected">KOREA</option>
								<option value="uk">United Kingdom</option>
								<option value="us">United America</option>
								<option value="australia">Australia</option>
								<option value="austria">Austria</option>
								<option value="belize">Belize</option>
								<option value="benin">Benin</option>
								<option value="brz">Brazil</option>
								<option value="canada">Canada</option>
								<option value="china">China</option>
								<option value="colombia">Colombia</option>
								<option value="dominica">Dominica</option>
								<option value="eqypt">Eqypt</option>
								<option value="finland">Finland</option>
								<option value="fr">France</option>
								<option value="germany">Germany</option>
								<option value="iceland">Iceland</option>
								<option value="india">India</option>
								<option value="japan">Japan</option>
								<option value="mexico">Mexico</option>
								<option value="hongkong">Hongkong</option>
								<option value="italy">Italy</option>
								<option value="monaco">Monaco</option>
								<option value="newzealand">New Zealand</option>
								<option value="resia">Resia</option>
								<option value="switzerland">Switzerland</option>
							</select>
						</div>



						<div class="form-group col-md-6">
							<label for="Post_Number">Post Number</label> <input type="text"
								class="form-control" name="zipcode" id="post_code" readonly 
								placeholder="Post Number">
						</div>

						<div class="form-group col-md-6">
							<!-- <div class="form-group"> -->
								<!-- <div class="col-md-2"> -->
									<div><label for="buttonpost" style="color:white">우편번호찾기</label></div>
									<input type="button" value="Find post number" onclick="showPostcode()" name="buttonpost" id="buttonpost" class="btn btn-primary">
								<!-- </div> -->
							<!-- </div> -->
							<!-- <label for="last_name">Last name</label> <input type="text"
								class="form-control" name="m_lname" id="last_name"
								placeholder="Last Name" required> -->
						</div>


						<div class="form-group col-md-8">
							<label for="m_addr">Address</label> <input type="text"
								class="form-control" name="m_addr" id="m_addr"
								placeholder="Your address" required>

						</div>

						<div class="form-group col-md-12">
								<label for="m_addr2">Detail Address</label> <input type="text" class="form-control"
								name="m_addr2" id="m_addr2" placeholder="detail address"
								required>
						</div>




					</fieldset>


					<div class="form-group">
						<div class="col-md-12">
							<div class="checkbox">
								<label> <input type="checkbox" value="" id=""
									name="check"> I accept the <a href="#">terms and
										conditions</a>.
								</label>
							</div>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-12">
							<button type="submit" class="btn btn-primary" id="reg_submit"
								onclick="doJoin();">Register</button>
							<a href="loginForm.do">Already have an account?</a>
						</div>
					</div>

				</form>
			</div>

		</div>
	</div>


	<script>
		// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
		/* 	$("#m_email").blur(function() {
		 // id = "id_reg" / name = "userId"
		 var m_email = $('#m_email').val();
		 $.ajax({
		 url : '${pageContext.request.contextPath}/idCheck.do?m_email='+ m_email,
		 type : 'get',
		 success : function(data) {
		 console.log("1 = 중복o / 0 = 중복x : "+ data);							
		
		 if (data == 1) {
		 // 1 : 아이디가 중복되는 문구
		 $("#id_check").text("사용중인 아이디입니다 :p");
		 $("#id_check").css("color", "red");
		 $("#reg_submit").attr("disabled", true);
		 } else {
		
		 if(idJ.test(m_email)){
		 // 0 : 아이디 길이 / 문자열 검사
		 $("#id_check").text("");
		 $("#reg_submit").attr("disabled", false);
		
		 } else if(m_email == ""){
		
		 $('#id_check').text('아이디를 입력해주세요 :)');
		 $('#id_check').css('color', 'red');
		 $("#reg_submit").attr("disabled", true);				
		
		 } else {
		
		 $('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
		 $('#id_check').css('color', 'red');
		 $("#reg_submit").attr("disabled", true);
		 }
		
		 }
		 }, error : function() {
		 console.log("실패");
		 }
		 });
		 }); */
	</script>

</body>
</html>