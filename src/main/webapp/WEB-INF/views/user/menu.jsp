<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>

		<h2>メニュー</h2>

		<c:if test="${user.authorityId  != null}">

<%-- 			<li><a href="/specedit/?staffId=${user.staffId}">スペックシート登録・編集</a><br></li> --%>
			<li><a href="/user/specMenu">スペックシート登録・編集</a><br></li>
			<li><a href="/detail/?staffId=${user.staffId}">スペックシート詳細</a><br></li>

		</c:if>

		<c:if test="${user.authorityId  == 2}">
			<li><a href="/search/">スペックシート検索</a><br></li>
			<li><a href="/system/">システム編集</a><br></li>
			<li><a href="/userRegist/">ユーザー新規登録</a><br></li>
		</c:if>

		<c:if test="${user.authorityId  != null}">
			<li><a href="/userEdit/?staffId=${user.staffId}">ユーザー編集</a><br></li>
		</c:if>

		<c:if test="${user != null}">
			<li><a href="/userLogout" >ログアウト</a></li>
		</c:if>


<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>