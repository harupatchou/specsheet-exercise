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
		<c:out value="${userLogin.name}" />さんログイン中<br>
		</div>	
	<%-- 	<form name="SystemForm"  novalidate>
			<input type="hidden" name="name" ng-model="name" ng-maxlength="16"> <input
			type="hidden" name="allExp" ng-model="allExp" required>
		</form> --%>
		<form:form modelAttribute="specSearchForm" action="/search/user" name="SystemForm">
		<p>名前：<form:input path="name" ng-init="name='${searchData.name}'" ng-model="name" ng-maxlength="16"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.name.$error.maxlength">16文字以内で入力してください</span></p>
		<p>状況：<form:select path="stateFlag" items="${stateMap}"/> 
		<c:if test="${stateMap.key == 0}">
		<option selected="selected">---</option>
		</c:if> 
		
		</p>
	 	<p>言語：
		<form:select path="langList">
			<c:forEach var="lang" items="${languageList}" varStatus="langStatus">
			<c:if test="${lang.id == 0}">
				<option value="null" selected="selected">---</option>
			</c:if>
			<c:if test="${lang.id == searchData.langList}">
				<option value="${lang.id}" selected="selected"><c:out value="${lang.name}"/></option>
			</c:if>
			<c:if test="${lang.id != searchData.langList}">
				<option value="${lang.id}"><c:out value="${lang.name}"/></option>
			</c:if>
			</c:forEach>
		</form:select>
		<form:select path="langList2">
			<c:forEach var="lang2" items="${languageList}" varStatus="langStatus">
			<c:if test="${lang2.id == 0}">
				<option value="null" selected="selected">---</option>
			</c:if>
			<c:if test="${lang2.id == searchData.langList2}">
				<option value="${lang2.id}" selected="selected"><c:out value="${lang2.name}"/></option>
			</c:if>
			<c:if test="${lang2.id != searchData.langList2}">
				<option value="${lang2.id}"><c:out value="${lang2.name}"/></option>
			</c:if>
			</c:forEach>
		</form:select>
		<form:select path="langList3">
			<c:forEach var="lang3" items="${languageList}" varStatus="langStatus">
			<c:if test="${lang3.id == 0}">
				<option value="null" selected="selected">---</option>
			</c:if>
			<c:if test="${lang3.id == searchData.langList3}">
				<option value="${lang3.id}" selected="selected"><c:out value="${lang3.name}"/></option>
			</c:if>
			<c:if test="${lang3.id != searchData.langList3}">
				<option value="${lang3.id}"><c:out value="${lang3.name}"/></option>
			</c:if>
			</c:forEach>
		</form:select>
		</p>
		<p>開発関連技術：
		<form:input path="techFirst" ng-init="techFirst='${searchData.techFirst}'" ng-model="techFirst" ng-maxlength="1024"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.techFirst.$error.maxlength">1024文字以内で入力してください</span>
		<form:input path="techSecond" ng-init="techSecond='${searchData.techSecond}'" ng-model="techSecond" ng-maxlength="1024"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.techSecond.$error.maxlength">1024文字以内で入力してください</span>
		<form:input path="techThird" ng-init="techThird='${searchData.techThird}'" ng-model="techThird" ng-maxlength="1024"/>
		<span ng-cloak style="color: red" ng-show="SystemForm.techThird.$error.maxlength">1024文字以内で入力してください</span>
		</p>
		<p>IT全体経験：<form:input path="allExp" ng-init="allExp='${searchData.allExp}'" ng-model="allExp" ng-pattern="/^[0-9]+$/"/>ヵ月以上	
		<span ng-cloak style="color: red" ng-show="SystemForm.allExp.$error.pattern">数値を入力してください</span></p>
		
		<p>年齢：<form:select path="id" items="${ageMap}"/>
		
		</p>
		<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
	 	<input type="submit" value="検索" ng-disabled="SystemForm.$invalid"/>
	 	　<input type="button" value="メニューに戻る" onclick="location.href='/loginUser/toTheMenu'"/><br><br>
	 	</form:form>
	 	
	 	<!-- 		検索結果 -->
	 	<h2>検索結果</h2>     全<c:out value="${specList.size()}"/>件
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
				<td><a href="/detail/?serchStaffId=${spec.staffId}"><c:out value="${spec.name}"/></a></td>
				<td><c:out value="${spec.stateFlag}"/></td>
				<td>
				<c:forEach var="lang" items="${spec.language}" varStatus="langStatus">
					<c:out value="${lang}"/>
					<c:if test="${langStatus.last == false}">
					,				
					</c:if>
				</c:forEach>
				
				 </td>
				<td><c:out value="${spec.techList}"/> </td>
				<td>
				<c:if test="${spec.division.quotient > 0 && spec.division.over > 0}">
				<c:out value="${spec.division.quotient}"/>年<c:out value="${spec.division.over}"/>か月
				</c:if>
				<c:if test="${spec.division.quotient > 0 && spec.division.over == 0}">
				<c:out value="${spec.division.quotient}"/>年
				</c:if>
				<c:if test="${spec.division.quotient == 0}">
				<c:out value="${spec.division.over}"/>か月
				</c:if> 
				</td>
				<td><c:out value="${spec.age}"/> </td>
				<td><c:out value="${spec.date}"/> </td>
				<td>
				<form:form action="/userEdit/select?id=${spec.staffId}" method="post">
				<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
				<input type="submit" name="form" value="ユーザー編集" />
				</form:form>
				<form:form action="/specedit/editFlow?staffId=${spec.staffId}" method="post">
				<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
				<input type="submit" name="form" value="スペック編集" />
				</form:form>
				</td>
			</tr>
				</c:forEach>
		</table><br>
</body>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>