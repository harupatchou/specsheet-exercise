<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

<p>下記の情報で新規登録してよろしいですか？</p>

スタッフID：<c:out value="${userRegistForm.staffId }"/><br>
姓：<c:out value="${userRegistForm.firstName }"/><br>
名：<c:out value="${userRegistForm.lastName }"/><br>
姓（フリガナ）：<c:out value="${userRegistForm.firstPhonetic }"/><br>
名（フリガナ）：<c:out value="${userRegistForm.lastPhonetic }"/><br>
性別:<c:out value="${userRegistForm.sex}"/><br>
権限：<c:if test="${userRegistForm.authorityId  == 2 }" var="flg" />
<c:if test="${flg }">管理者</c:if>
<c:if test="${!flg }">ユーザー</c:if><br>

<form:form  modelAttribute="userRegistForm" action="/userRegist/create/">
	<form:hidden path="staffId" value="${userRegistForm.staffId}"/>
	<form:hidden path="firstName" value="${userRegistForm.firstName }"/>
	<form:hidden path="lastName" value="${userRegistForm.lastName }"/>
	<form:hidden path="firstPhonetic" value="${userRegistForm.firstPhonetic}"/>
	<form:hidden path="lastPhonetic" value="${userRegistForm.lastPhonetic}"/>
	<form:hidden path="sex" value="${userRegistForm.sex}"/>
	<form:hidden path="authorityId" value="${userRegistForm.authorityId}"/>
	<input type="submit" value="はい" type="hidden" name="flag"/>
	<input type="submit" value="いいえ" type="hidden" name="flag"/>
</form:form>
<br>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>