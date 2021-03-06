<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> -->
<link rel="stylesheet" type="text/css" href="/Traditional-Market/css/regist.css" />
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp"></jsp:include>
<title>전통시장: 회원가입</title>
<script src="/Traditional-Market/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
/* <!-- 1. 똑같은 form이여도 전송하는 위치가 다를 수 있으니
     2. 벨리데이션 체크: 공백이면 종료(return)하고 만약 이 모든것들이 이상이 없으면 submit을 해라. 
                     다시 말하면. submit하기전에 체크하는건 다 벨리데이션 체크 --> */
	$().ready(function(){
		
		$("#memberId").keyup(function(){		
			// Ajax 요쳥
			// $.post("URL", 요청 파라미터(항상 객체 리터럴 방식), function(response):응답파라미터 {})
			// short cut형식으로 쓴거임.
			$.post("/Traditional-Market/member/check/duplicate"	// URL
					, {
						"memberId":$(this).val()				// Request Parameter
					  }
					, function(response) {						// Response Call back
						if( response.duplicated ){				// true
							$("#memberId-error").slideDown(100);
						}
						else if( response.isBlockId ) {
							$("#blockId-error").slideDown(100);
						}
						else {									// false
							$("#memberId-error").slideUp(100);
							$("#blockId-error").slideUp(100);
						}
					})
		})
		
		$("#password").keyup(function(){		
			$.post("/Traditional-Market/member/check/password"	// URL
					, {
						"password":$(this).val()				// Request Parameter
					  }
					, function(response) {						// Response Call back
						if( !response.password ){				// true
							$("#password-error").slideDown(100);
						}
						else {									// false
							$("#password-error").slideUp(100);
						}
					})
		})
		
		$("#password_ckeck").keyup(function(){		
			$.post("/Traditional-Market/member/check/password_ckeck"	// URL
					, {
						"password":$("#password").val()					// Request Parameter
						, "password_ckeck":$(this).val()					
					  }
					, function(response) {								// Response Call back
						if( response.password_ckeck ){					// true
							$("#password_ckeck-error").slideDown(100);
						}
						else {											// false
							$("#password_ckeck-error").slideUp(100);
						}
					})
		})
		
		$("#email").keyup(function(){		
			$.post("/Traditional-Market/member/check/email"		// URL
					, {
						"email":$(this).val()					// Request Parameter
					  }
					, function(response) {						// Response Call back
						console.log(response.email);
						if( !response.email ){					// true
							$("#email-error").slideDown(100);
						}
						else {									// false
							$("#email-error").slideUp(100);
							
						}
					})
		})
		
		
		$("#regist").click( function(){
			if( $("#memberId").val() == "" ){	
				$("#memberId").focus();
				return;
			}
			else if( $("#password").val() == "" ){			
				$("#password").focus()
				return;
			}
			else if( $("#password_ckeck").val() == "" ){	
				$("#password_ckeck").focus()
				return;
			}
			else if( $("#name").val() == "" ){
			
				$("#name").focus()
				return;
			}
			else if( $("#birth").val() == "" ){				
				$("#birth").focus()
				return;
			}
			else if( $("#email").val() == "" ){	
				$("#email").focus()
				return;
			}
 			$("#registForm").attr({
				"method" : "post"
				, "action" : "/Traditional-Market/member/regist"
			})
			.submit()	 	
		})
	})

</script>
</head>
<body>
	<div id="menu_regist">
		> 회원가입
	</div>
	<form id="registForm">
		<div>
			<h3 class="join_title">아이디</h3>
			<input type="text" id="memberId" name="memberId" value="${memberVO.memberId}" placeholder="아이디">
			<div id="memberId-error" style="display: none;">
				이미 사용중인 아이디입니다.
			</div>
			<div id="blockId-error" style="display: none;">
				이 아이디는 사용할 수 없습니다.
			</div>
		</div>
		<div>
			<h3 class="join_title">비밀번호</h3>
			<input type="password" id="password" name="password" placeholder="비밀번호" maxlength="20">
			<div id="password-error" style="display: none;">
				10~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.
			</div>
		</div>
		<div>
			<h3 class="join_title">비밀번호 재확인</h3>
			<input type="password" id="password_ckeck" name="password_ckeck" placeholder="비밀번호 재확인" maxlength="20">
			<div id="password_ckeck-error" style="display: none;">
				비밀번호가 일치하지 않습니다.
			</div>
		</div>
		<div>
			<h3 class="join_title">이름</h3>
			<input type="text" id="name" name="name" value="${memberVO.name}" placeholder="이름">
		</div>
		<div>
			<h3 class="join_gender">성별</h3>
			<input type="radio" class="gender_size" name="gender" value="W"/>여자
			<input type="radio" class="gender_size" name="gender" value="M"/>남자
		</div>
		<div class="bir_wrap">
			<h3 class="join_title">생년월일</h3>
			<input type="date" id="birth" name="birth" min="1930-01-01" value="${memberVO.birth}">
		</div>
		<div>
			<h3 class="join_title">이메일</h3>
			<input type="text" id="email" name="email" value="${memberVO.email}" placeholder="이메일">
			<div id="email-error" style="display: none;">
				이메일 주소를 다시 확인해주세요.
			</div>
		</div>

		<div>
			<input type="button" id="regist" value="가입하기">
		</div>
	</form>

</body>
</html>