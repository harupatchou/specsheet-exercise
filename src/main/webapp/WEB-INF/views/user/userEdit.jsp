<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

		<h1>ユーザー情報編集画面</h1>
		<p style="color: red"><form:errors path="userEditForm" /></p>
		<form:form modelAttribute="userEditForm" action="/userEdit/flowConfirm">
		
							<%--　　　　 管理者のみ表示 　　　　--%>
							
			<c:if test="${user.authorityId == 2}">			
				<p>姓：<form:input path="firstName" value="${userData.firstName}"/></p>
				<p>名：<form:input path="lastName" value="${userData.lastName}"/></p>
				<p>セイ：<form:input path="firstPhonetic" value="${userData.firstPhonetic}"/></p>
				<p>メイ：<form:input path="lastPhonetic" value="${userData.lastPhonetic}"/></p>
				<p>性別：
					<form:select path="sex">
						<option value="男">男</option>
						<c:if test="${userData.sex != '女'}">
							<option value="女">女</option>
						</c:if>
						<c:if test="${userData.sex == '女'}">
							<option value="女" selected>女</option>
						</c:if>
					</form:select>
				</p>
		 		<p>スタッフID：<form:input path="staffId" value="${userData.staffId}"/></p>
	 			<p>権限：
	 				<form:select path="authorityId">
						<option value="1">ユーザー</option>
						<c:if test="${userData.authorityId != 2}">
							<option value="2">管理者</option>
						</c:if>
						<c:if test="${userData.authorityId == 2}">
							<option value="2" selected>管理者</option>
						</c:if>
					</form:select><br>
				</p>
			</c:if>
			
							<%--　　　　 ここまで管理者のみ表示 　　　　--%>
			
		 	<p>現在のパスワード：<form:password path="password"/></p>
			<p>新しいパスワード：<form:password path="newPassword"/></p>
			<p>新しいパスワード(再入力)：<form:password path="confirmPassword"/></p>
			<form:hidden path="tempStaffId" value="${userData.staffId}"/>
			<input type="hidden" name="user" value="${user}">
	 		<input type="submit" value="登録"/>
			<input class="button" type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>
		</form:form>	

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>