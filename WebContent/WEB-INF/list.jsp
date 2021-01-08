<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.PhoneDao" %>
<%@ page import="com.javaex.vo.PersonVo" %>
<%@ page import="java.util.List" %>

<%
	//object에서 list로 형변환 할 때 확인 안된 거라면서 에러가 있을 수 도 있지만 이걸로 그냥 안나오게만 하는 것 근본적인 문제 해결은 아님
	@SuppressWarnings("unchecked") 
	List<PersonVo> personList = (List<PersonVo>)request.getAttribute("personList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>김영관 전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>
		<%for(int i=0;i<personList.size();i++){ %>
			<table border="1">
				<tr>
					<td>이름(name)</td>
					<td><%=personList.get(i).getName()%></td>
				</tr>
				<tr>
					<td>핸드폰(hp)</td>
					<td><%=personList.get(i).getHp()%></td>
				</tr>
				<tr>
					<td>회사(company)</td>
					<td><%=personList.get(i).getCompany()%></td>
				</tr>
				<tr>
					<td><a href="./updateForm.jsp?action=updateForm&id=<%=personList.get(i).getPerson_id()%>">수정</a></td>
					<td><a href="./PhoneController?action=delete&id=<%=personList.get(i).getPerson_id()%>">삭제</a></td>
				</tr>
			</table>
			<br>
		<%} %>
	<a href="./PhoneController?action=writeForm">추가번호 등록</a>
</body>
</html>