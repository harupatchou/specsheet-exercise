<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

		<h1>ユーザー新規登録画面</h1>
		<form:form>
			<p>姓：<form:input path="firstName"/></p>
			<p>名：<form:input path="lastName"/></p>
			<p>セイ：<form:input path="firstPhonetic"/></p>
			<p>メイ：<form:input path="lastPhonetic"/></p>
			<p>性別：<form:input path="gender"/></p>
		 	<p>スタッフID：<form:input path="staffId"/></p>
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