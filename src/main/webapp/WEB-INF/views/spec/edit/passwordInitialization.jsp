<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>
<h1>スタッフID：${specStaffId}のパスワードを初期化します</h1>

<input type="button" value="初期化を実行する" 
onclick="location.href='/userEdit/passwordInitializationCompletion/?staffId=${specStaffId}'" />
<input type="button" value="初期化せず、メニューに戻る" onclick="location.href='/flowMenu'"/>
<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>