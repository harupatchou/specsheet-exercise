<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

		<form:form>
			<p>姓：<form:input path="firstName"/></p>
			<p>名：<form:input path="lastName"/></p>
			<p>セイ：<form:input path="firstPhonetic"/></p>
			<p>メイ：<form:input path="lastPhonetic"/></p>
		 	<p>スタッフID：<form:input path="staffId"/></p>
		 	<p>現在のパスワード：<form:input path="password"/></p>
			<p>新しいパスワード：<form:input path="newPassword"/></p>
			<p>新しいパスワード(再入力)：<form:input path="confirmPassword"/></p>
	 		<p>権限：
	 			<form:select path="authorityId">
					<option>管理者</option>
					<option>ユーザー</option>
				</form:select><br>
			</p>
	 		<input type="button" value="登録" onclick="location.href='menu.html'"/>
			<input class="button" type="button" value="メニューに戻る" onclick="location.href='/loginUser/toTheMenu'"/>
		</form:form>	

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>