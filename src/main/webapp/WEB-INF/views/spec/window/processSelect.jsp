<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="/js/spec/windowsOpen.js"></script>
<title>Insert title here</title>
</head>
<body>
<form>
<h1>OS選択</h1>
<c:forEach var="process" items="${processList}">
<p>
<label><input type="checkbox" name="process" value="${process.name}"><c:out value="${process.name}"/></label>
</p>
</c:forEach>
<p><input type="button" value="選択完了" onclick="goBackProcess(${proNo});"></p>
</form>
</body>
</html>