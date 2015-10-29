<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>


		<form:form modelAttribute="specSearchForm" action="/search/searchSpec" name="SystemForm" id="formId">

		<p>氏：<form:input path="firstName" value="${searchData.firstName}" class="validate[maxSize[16]]"/></p>
		<p>名：<form:input path="lastName" value="${searchData.lastName}" class="validate[maxSize[16]]"/>
		<p>状況：<form:select path="stateFlag" items="${stateMap}"/> </p>
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
		<form:input path="tech1" value="${searchData.tech1}" class="validate[maxSize[1024]]"/>
		<form:input path="tech2" value="${searchData.tech2}" class="validate[maxSize[1024]]"/>
		<form:input path="tech3" value="${searchData.tech3}" class="validate[maxSize[1024]]"/>
		</p>
		<p>IT全体経験：<form:input path="allExp" value="${searchData.allExp}" class="validate[custom[number]]"/>ヵ月以上	
		
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
						<form:form action="/userEdit/select?staffId=${spec.staffId}">
							<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
							<input type="submit" name="form" value="ユーザー編集" />
						</form:form>
						<form:form action="/spec/index?staffId=${spec.staffId}" >
							<input type="submit" name="form" value="スペック新規登録" />
						</form:form>
					</td>
				</c:if>
				<c:if test="${spec.updateDate != null}">
					<td><a href="/detail/?staffId=${spec.staffId}"><c:out value="${spec.fullName}"/></a></td>
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
						<form:form action="/spec/index?staffId=${spec.staffId}" >
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