<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Traditional-Market/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
/* <!-- 1. 똑같은 form이여도 전송하는 위치가 다를 수 있으니
     2. 벨리데이션 체크: 공백이면 종료(return)하고 만약 이 모든것들이 이상이 없으면 submit을 해라. 
                     다시 말하면. submit하기전에 체크하는건 다 벨리데이션 체크 --> */
	$().ready(function(){
		
		$("#modifyBtn").click(function() {
			if( $("#title").val() == "" ) {				
				$("#title").focus();
				return;
			}
			else if ( $("#content").val() == "" ) {		
				$("#content").focus();
				return;
			}			
			$("#modifyForm").attr({
				method : "post"
				, action : "/Traditional-Market/board/modify"
				, enctype : "multipart/form-data"
			})
			.submit();		
		});
		
	});
</script>
</head>

<body>
	<form id="modifyForm">
		<div>
			<input type="hidden" name="boardId" value="${boardVO.boardId}"/>
		</div>
		<div>
			<input type="text" id="title" name="title" placeholder="제목" value="${boardVO.title}"/>
		</div>
		<div>
			<textarea type="text" id="content" name="content" placeholder="내용">${boardVO.content}</textarea>
		</div>
		<div>
			<input type="file" id="pictureFile" name="pictureFile" placeholder="파일선택" accept=".jpg, .img, .png"/>
		</div>
		<div>
			<!-- <input type="submit" id="wirte" value="글쓰기"/> -->
			<input type="button" id="modifyBtn" name="modifyBtn" value="수정하기"/>
		</div>
	</form>

</body>
</html>