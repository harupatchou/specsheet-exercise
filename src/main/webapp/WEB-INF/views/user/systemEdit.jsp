<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js"></script>
<script src="../js/submitStop.js"></script>
<div id="headerArea">
<!-- 		<span id="heading" style="color: white">システム編集画面</span><br> -->
<%-- 		<c:out value="${userLogin.name}" />さんログイン中<br> --%>
	
	
		</div>
	<table>
	<tr>
		<td valign="top">
			<h4>言語項目</h4>
			<ul>
				<c:forEach var="language" items="${languageList}">
					<li><c:out value="${language.name}"/></li>
				</c:forEach>
			</ul>
			<form:form action="/system/editLanguage"   name="languageForm" id="formId">
				<p>言語追加：<input type="text" name="name" class="validate[maxSize[16]]" onKeyPress="return submitStop(event);"/>
				<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
		 		<input type="submit" value="言語登録" ng-disabled="languageForm.$invalid" /><br><br>
		 	</form:form>
		 </td>
		 <td valign="top">
		 	<h4>OS項目</h4>
			<ul>
				<c:forEach var="os" items="${osList}">
					<li><c:out value="${os.osName}"/></li>
				</c:forEach>
			</ul>
			<form:form action="/system/editOs" method="post" name="OsForm" id="formId2">
				<p>OS追加：<input type="text" name="osName"  class="validate[maxSize[16]]" onKeyPress="return submitStop(event);"/>
				<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
		 		<input type="submit" value="OS登録" ng-disabled="OsForm.$invalid" /><br><br>
		 	</form:form>
		</td>
	</tr>
	</table>
	<input type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>