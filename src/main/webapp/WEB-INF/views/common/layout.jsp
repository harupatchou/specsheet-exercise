<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spec管理</title>
</head>
<body>

<header>
	<c:import url="/WEB-INF/views/common/header.jsp" charEncoding="UTF-8"/>
</header>
<article>
	${param.content}
</article>
<footer>
	<c:import url="/WEB-INF/views/common/fotter.jsp" charEncoding="UTF-8"/>
</footer>

</body>
</html>