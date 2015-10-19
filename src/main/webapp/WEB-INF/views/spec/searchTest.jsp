<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

<html ng-app xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/specSystem.css">
<link rel="stylesheet" href="../css/specDetail.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js"></script>
<title>スペックシート検索画面</title>
</head>
<body>
<div id="headerArea">
		<span id="heading" style="color: white">スペックシート検索画面</span><br>
		</div>	
	<%-- 	<form name="SystemForm"  novalidate>
			<input type="hidden" name="name" ng-model="name" ng-maxlength="16"> <input
			type="hidden" name="allExp" ng-model="allExp" required>
		</form> --%>
		<table class="speckDetailTable">
			<tr>
				<th>名前 </th>
				<th>状況</th>
				<th>言語</th>
				<th>関連技術</th>
				<th>IT全体経験</th>
				<th>年代</th>
				<th>最終更新日</th>
				<th>編集</th>
			</tr>
			<c:forEach var="spec" items="${specList}">
			<tr>
			<td><c:out value="${spec}"/></td>
<%-- 				<td><a href="/detail/?serchStaffId=${spec.staffId}"><c:out value="${spec.name}"/></a></td> --%>
<%-- 				<td><c:out value="${spec.stateFlag}"/></td> --%>
<!-- 				<td> -->
<%-- 				<c:forEach var="lang" items="${spec.language}" varStatus="langStatus"> --%>
<%-- 					<c:out value="${spec.langName}"/> --%>
<%-- 					<c:if test="${langStatus.last == false}"> --%>
<!-- 					,				 -->
<%-- 					</c:if> --%>
<%-- 				</c:forEach> --%>
				
<!-- 				 </td> -->
<%-- 				<td><c:out value="${spec.techList}"/> </td> --%>
<!-- 				<td> -->
<%-- 				<c:if test="${spec.division.quotient > 0 && spec.division.over > 0}"> --%>
<%-- 				<c:out value="${spec.division.quotient}"/>年<c:out value="${spec.division.over}"/>か月 --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${spec.division.quotient > 0 && spec.division.over == 0}"> --%>
<%-- 				<c:out value="${spec.division.quotient}"/>年 --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${spec.division.quotient == 0}"> --%>
<%-- 				<c:out value="${spec.division.over}"/>か月 --%>
<%-- 				</c:if>  --%>
<!-- 				</td> -->
<%-- 				<td><c:out value="${spec.age}"/> </td> --%>
<%-- 				<td><c:out value="${spec.date}"/> </td> --%>
			</tr>
				</c:forEach>
		</table><br>
</body>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>