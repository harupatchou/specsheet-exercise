<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="/js/spec/window/windowsOpen.js"></script>
<title>Insert title here</title>
</head>
<body>
<form>
<h1>言語選択</h1>
<c:forEach var="lang" items="${langList}">
<p>
<label>
<input type="checkbox" name="lang" value="${lang.name}"><c:out value="${lang.name}"/>
<c:if test="${lang.name.equals('その他')}"><input type="text" name="langOther" id="langOther"/></c:if>
</label>
</p>
</c:forEach>
<p><input type="button" value="選択完了" onclick="goBackLang(${btnNo});"></p>
</form>
</body>
</html>