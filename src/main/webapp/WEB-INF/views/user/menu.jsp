<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

<a href="/userRegist/">ユーザー新規登録</a><br>
<a href="/userEdit/?staffId=${user.staffId}">ユーザー編集</a><br>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>