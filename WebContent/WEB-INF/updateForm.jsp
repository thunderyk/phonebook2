<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.PhoneDao" %>
<%@ page import="com.javaex.vo.PersonVo" %>

<%
	PersonVo personVo = (PersonVo)request.getAttribute("personVo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화 번호 수정</h1>
	<p>전화번호를 수정하려면<br>
	아래의 항목을 기입하고 "수정" 버튼을 클릭하세요. </p>
	<!-- 일부로 post 방식을 사용한 것임 get 방식은 이해 했으니 post를 공부해보기 위해서 사용 -->
	<!-- PhoneController에서 어떻게 post가 사용 되는지 궁긍해서 사용해봄 -->
	<form action="PhoneController" method="post" accept-charset="utf-8">
		<div>
			<label for="txt-name">이름(name)</label>
			<input type="text" id="txt-name" name="name" value="<%=personVo.getName()%>">
		</div>
		<div>
			<label for="txt-hp">핸드폰(hp)</label>
			<input type="text" id="txt-hp" name="hp" value="<%=personVo.getHp()%>">
		</div>
		<div>
			<label for="txt-company">회사(company)</label>
			<input type="text" id="txt-company" name="company" value="<%=personVo.getCompany()%>">
		</div>
		<div>
			<input type="hidden" value="<%=personVo.getPerson_id()%>" name="id">
		</div>
		<input type="hidden" value="update" name="action">
		<button type="submit">수정</button>
	</form>
	<br>
	<br>
	<a href="./PhoneController?action=list">리스트 바로가기</a>
</body>
</html>