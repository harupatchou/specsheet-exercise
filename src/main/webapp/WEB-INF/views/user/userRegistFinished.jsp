<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

	<h1>ユーザー情報登録画面</h1>
		
	<h2>登録完了しました</h2>
	<input type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>