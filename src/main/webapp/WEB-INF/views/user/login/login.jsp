<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>
	
	 <h1>ログイン画面</h1>
	 <p style="color: red"><c:out value="${loginError}"/></p>
	 <form:form id="formId" modelAttribute="userLoginForm" action="/login">
	 	<p>スタッフID：<form:input path="staffId" value="${loginForm.staffId}" class="validate[required]"/></p>
	 	<p>パスワード：<form:password path="password" class="validate[required]"/></p><br>
	 	<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
	 	<input type="submit" value="ログイン" />
	 </form:form>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>