<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
	<h1>회원조회</h1>
	<table border='1'>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>이메일</th>
		</tr>
		<c:forEach items="${users }" var="user">
		<tr>
			<td>
				${user.id }
			</td>
			<td>
				${user.name }
			</td>
			<td>
				${user.Pw }
			</td>
			<td>
				${user.email }
			</td>
			<td>
				<a href="${pageContext.request.contextPath }/updateUser?id=${user.id }">회원정보수정</a>
			</td>
		</tr>
		</c:forEach>
	</table>

<script>
	var result = '${msg}';
	if (result == 'success') {
		alert('정보 수정에 성공하였습니다')
	}
</script>

<c:remove var="msg" scope="session" />
</body>
</html>