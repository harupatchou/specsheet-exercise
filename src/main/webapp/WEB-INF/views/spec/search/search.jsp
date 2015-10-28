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
<%-- 		<c:out value="${userLogin.name}" />さんログイン中<br> --%>
		</div>	
	<%-- 	<form name="SystemForm"  novalidate>
			<input type="hidden" name="name" ng-model="name" ng-maxlength="16"> <input
			type="hidden" name="allExp" ng-model="allExp" required>
		</form> --%>
		<form:form modelAttribute="specSearchForm" action="/search/searchSpec" name="SystemForm">
		<p>氏：<form:input path="firstName" ng-init="firstName='${searchData.firstName}'" ng-model="firstName" ng-maxlength="16"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.firstName.$error.maxlength">16文字以内で入力してください</span></p>
		<p>名：<form:input path="lastName" ng-init="lastName='${searchData.lastName}'" ng-model="lastName" ng-maxlength="16"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.lastName.$error.maxlength">16文字以内で入力してください</span></p>
		<p>状況：<form:select path="stateFlag" items="${stateMap}"/> 
		
		</p>
	 	<p>言語：
		<form:select path="lang1">
			<c:forEach var="lang" items="${languageList}" varStatus="langStatus">
			<c:if test="${lang.id == 1}">
				<option value="null" selected="selected">---</option>
			</c:if>
			<c:if test="${lang.id == searchData.lang1}">
				<option value="${lang.id}" selected="selected"><c:out value="${lang.name}"/></option>
			</c:if>
			<c:if test="${lang.id != searchData.lang1}">
				<option value="${lang.id}"><c:out value="${lang.name}"/></option>
			</c:if>
			</c:forEach>
		</form:select>
		<form:select path="lang2">
			<c:forEach var="lang2" items="${languageList}" varStatus="langStatus">
			<c:if test="${lang2.id == 1}">
				<option value="null" selected="selected">---</option>
			</c:if>
			<c:if test="${lang2.id == searchData.lang2}">
				<option value="${lang2.id}" selected="selected"><c:out value="${lang2.name}"/></option>
			</c:if>
			<c:if test="${lang2.id != searchData.lang2}">
				<option value="${lang2.id}"><c:out value="${lang2.name}"/></option>
			</c:if>
			</c:forEach>
		</form:select>
		<form:select path="lang3">
			<c:forEach var="lang3" items="${languageList}" varStatus="langStatus">
			<c:if test="${lang3.id == 1}">
				<option value="null" selected="selected">---</option>
			</c:if>
			<c:if test="${lang3.id == searchData.lang3}">
				<option value="${lang3.id}" selected="selected"><c:out value="${lang3.name}"/></option>
			</c:if>
			<c:if test="${lang3.id != searchData.lang3}">
				<option value="${lang3.id}"><c:out value="${lang3.name}"/></option>
			</c:if>
			</c:forEach>
		</form:select>
		</p>
		<p>開発関連技術：
		<form:input path="tech1" ng-init="tech1='${searchData.tech1}'" ng-model="tech1" ng-maxlength="1024"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.techFirst.$error.maxlength">1024文字以内で入力してください</span>
		<form:input path="tech2" ng-init="tech2='${searchData.tech2}'" ng-model="tech2" ng-maxlength="1024"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.techSecond.$error.maxlength">1024文字以内で入力してください</span>
		<form:input path="tech3" ng-init="tech3='${searchData.tech3}'" ng-model="tech3" ng-maxlength="1024"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.techThird.$error.maxlength">1024文字以内で入力してください</span>
		</p>
		<p>IT全体経験：<form:input path="allExp" ng-init="allExp='${searchData.allExp}'" ng-model="allExp" ng-pattern="/^[0-9]+$/"/>ヵ月以上	
		<span ng-cloak style="color: red" ng-show="SystemForm.allExp.$error.pattern">数値を入力してください</span></p>
		
		<p>年齢：<form:select path="id" items="${ageMap}"/>
		
		</p>
		<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
	 	<input type="submit" value="検索" ng-disabled="SystemForm.$invalid"/>
	 	　<input type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/><br><br>
	 	</form:form>
	 	
	 	<!-- 		検索結果 -->
	 	<h2>検索結果</h2>
<%-- 	 	<c:if test="${specList != null && specList.size() >= 0}" --%>
	 		全　<c:out value="${specList.size()}"/>　件
<%-- 	 	</c:if> --%>
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
				<c:if test="${spec.updateDate == null}">
					<td><c:out value="${spec.fullName}"/></td>
					<td colspan="6" align="center">※スペックシート未登録※</td>
					<td>
						<form:form action="/userEdit/select?id=${spec.staffId}" method="post">
							<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
							<input type="submit" name="form" value="ユーザー編集" />
						</form:form>
						<form:form >
							<input type="submit" name="form" value="スペック編集" disabled="disabled"/>
						</form:form>
					</td>
				</c:if>
				<c:if test="${spec.updateDate != null}">
					<td><a href="/detail/?serchStaffId=${spec.staffId}"><c:out value="${spec.fullName}"/></a></td>
					<td><c:out value="${spec.state}"/></td>
					<td>
						<c:forEach var="lang" items="${spec.langList}" varStatus="langStatus">
							<c:out value="${lang}"/>
							<c:if test="${langStatus.last == false}">
								,
							</c:if>
						</c:forEach>		
					</td>
					<td><c:out value="${spec.relatedTech}"/> </td>
					<td>
						<c:if test="${spec.allExpArray[0] > 0 && spec.allExpArray[1] > 0}">
							<c:out value="${spec.allExpArray[0]}"/>年<c:out value="${spec.allExpArray[1]}"/>か月
						</c:if>
						<c:if test="${spec.allExpArray[0] > 0 && spec.allExpArray[1] == 0}">
							<c:out value="${spec.allExpArray[0]}"/>年
						</c:if>
						<c:if test="${spec.allExpArray[0] == 0}">
							<c:out value="${spec.allExpArray[1]}"/>か月
						</c:if> 
					</td>
					<td><c:out value="${spec.ageRange}"/> </td>
					<td><c:out value="${spec.updateDate}"/> </td>
					<td>
						<form:form action="/userEdit/?staffId=${spec.staffId}" method="post">
							<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
							<input type="submit" name="form" value="ユーザー編集" />
						</form:form>
						<form:form action="/specedit/editFlow?staffId=${spec.staffId}" method="post">
							<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
							<input type="submit" name="form" value="スペック編集" />
						</form:form>
					</td>
				</c:if>
			</tr>
		</c:forEach>
		</table><br>
</body>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>