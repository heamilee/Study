<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/register" name="join" method="post">
		<div class="error">${error }</div>
		<table>
			<tr>
				<td>
				�̸�
				<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>
				�̸���
				<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td>
				���̵�
				<input type="text" name="id">
				</td>
			</tr>
			<tr>	
				<td>
				��й�ȣ
				<input type="password" name="pw">
				</td>
			</tr>
			<tr>
				<td colspen="1">
				<button type='button' onclick="submitForm()" >����</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>