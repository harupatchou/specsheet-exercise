<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

		<h1>ユーザー新規登録画面</h1>
		 <p style="color: red"><form:errors path="userRegistForm" /></p>
		<form:form modelAttribute="userRegistForm" action="/userRegist/flowConfirmation">
			<p>姓：<form:input path="firstName"/></p>
			<p>名：<form:input path="lastName"/></p>
			<p>セイ：<form:input path="firstPhonetic"/></p>
			<p>メイ：<form:input path="lastPhonetic"/></p>
			<p>性別：
				<form:select path="sex">
					<option value="男">男</option>
					<c:if test="${userRegistForm.sex != '女'}">
						<option value="女">女</option>
					</c:if>
					<c:if test="${userRegistForm.sex == '女'}">
						<option value="女" selected>女</option>
					</c:if>
				</form:select>
			</p>
		 	<p>スタッフID：<form:input path="staffId"/></p>
	 		<p>権限：
	 			<form:select path="authorityId">
					<option value="1">ユーザー</option>
					<c:if test="${userRegistForm.authorityId != 2}">
						<option value="2">管理者</option>
					</c:if>
					<c:if test="${userRegistForm.authorityId == 2}">
						<option value="2" selected>管理者</option>
					</c:if>
				</form:select><br>
			</p>
				<input type="submit" value="登録">
	 <%-- 		<input type="button" value="登録" onclick="location.href='/userRegist/flowConfirmation'"/> --%>
			<input class="button" type="button" value="メニューに戻る" onclick="location.href='/userLogin/flowMenu'"/>
		</form:form>		
		
<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>