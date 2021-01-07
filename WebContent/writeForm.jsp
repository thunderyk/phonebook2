<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화 번호 등록</h1>
	<p>전화번호를 등록하려면<br>
	아래의 항목을 기입하고 "등록" 버튼을 클릭하세요. </p>
	
	<form action="./PhoneController" method="POST">
		<div>
			<label for="txt-name">이름(name)</label>
			<input type="text" id="txt-name" name="name">
		</div>
		<div>
			<label for="txt-hp">핸드폰(hp)</label>
			<input type="text" id="txt-hp" name="hp">
		</div>
		<div>
			<label for="txt-company">회사(company)</label>
			<input type="text" id="txt-company" name="company">
		</div>
		<input type="hidden" name = "action" value="insert">
		<button type="submit">등록</button>
	</form>	     
	<br>
	<br>
	<a href="./PhoneController">리스트 바로가기</a>
</body>
</html>