<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

	<h1>ユーザー情報編集画面</h1>
		
	<h3>以下の内容で登録情報を変更します</h3>
	
							<%--　　　　 管理者のみ表示 　　　　--%>
							
		<table>
			<c:if test="${userData.authorityId == 2}">
				<c:if test="${userData.firstName != userEditForm.firstName}">
					<tr>
						<td>姓：</td>
						<td><c:out value="${userData.firstName}"/></td>
						<td>→<b><c:out value="${userEditForm.firstName}"/></b>					
					</tr>
				</c:if>
				<c:if test="${userData.lastName != userEditForm.lastName}">
					<tr>
						<td>名：</td>
						<td><c:out value="${userData.lastName}"/></td>
						<td>→<b><c:out value="${userEditForm.lastName}"/></b>					
					</tr>
				</c:if>
				<c:if test="${userData.firstPhonetic != userEditForm.firstPhonetic}">
					<tr>
						<td>セイ：</td>
						<td><c:out value="${userData.firstPhonetic}"/></td>
						<td>→<b><c:out value="${userEditForm.firstPhonetic}"/></b>					
					</tr>
				</c:if>
				<c:if test="${userData.lastPhonetic != userEditForm.lastPhonetic}">
					<tr>
						<td>メイ：</td>
						<td><c:out value="${userData.lastPhonetic}"/></td>
						<td>→<b><c:out value="${userEditForm.lastPhonetic}"/></b>					
					</tr>
				</c:if>
				<c:if test="${userData.sex != userEditForm.sex}">
					<tr>
						<td>性別：</td>
						<td><c:out value="${userData.sex}"/></td>
						<td>→<b><c:out value="${userEditForm.sex}"/></b>					
					</tr>
				</c:if>
				<c:if test="${userData.staffId != userEditForm.staffId}">
					<tr>
						<td>スタッフID：</td>
						<td><c:out value="${userData.staffId}"/></td>
						<td>→<b><c:out value="${userEditForm.staffIdFirst}"/>-<c:out value="${userEditForm.staffIdSecond}"/>-<c:out value="${userEditForm.staffIdThird}"/></b>					
					</tr>
				</c:if>
				<c:if test="${userData.authorityId != userEditForm.authorityId}">
					<tr>
						<td>権限：</td>
						<td>
							<c:if test="${userData.authorityId == 1}">
								一般ユーザー
							</c:if>
							<c:if test="${userData.authorityId == 2}">
								管理者
							</c:if>
						</td>
						<td>
							<c:if test="${userEditForm.authorityId == 1}">
								→一般ユーザー
							</c:if>
							<c:if test="${userEditForm.authorityId == 2}">
								→管理者
							</c:if>
						</td>					
					</tr>
				</c:if>
				
								<%--　　　　 ここまで管理者のみ表示 　　　　--%>
				
				<c:if test="${userData.password != userEditForm.newPassword}">
					<tr>
						<td>パスワード：</td>
						<td>表示されません</td>
						<td>→<b>表示されません</b>					
					</tr>
				</c:if>
			</c:if>
		</table>
	<form:form modelAttribute="userEditForm" action="/userEdit/update">
		<form:hidden path="staffIdFirst" value="${userEditForm.staffIdFirst}"/>
		<form:hidden path="staffIdSecond" value="${userEditForm.staffIdSecond}"/>
		<form:hidden path="staffIdThird" value="${userEditForm.staffIdThird}"/>
		<form:hidden path="firstName" value="${userEditForm.firstName }"/>
		<form:hidden path="lastName" value="${userEditForm.lastName }"/>
		<form:hidden path="firstPhonetic" value="${userEditForm.firstPhonetic}"/>
		<form:hidden path="lastPhonetic" value="${userEditForm.lastPhonetic}"/>
		<form:hidden path="sex" value="${userEditForm.sex}"/>
		<form:hidden path="authorityId" value="${userEditForm.authorityId}"/>
		<form:hidden path="newPassword" value="${userEditForm.newPassword}"/>
		<form:hidden path="tempStaffId" value="${userEditForm.tempStaffId}"/>
		<input type="submit" value="変更" type="hidden" name="flag"/><input type="submit" value="修正する" type="hidden" name="flag"/>
	</form:form>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>