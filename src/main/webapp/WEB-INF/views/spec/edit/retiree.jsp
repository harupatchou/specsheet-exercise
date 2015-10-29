<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
	
		
<%--ここから下にコンテンツを挿入 --%>
<h1>スタッフID：${retireeStaffId}を退職者登録します</h1>

<input type="button" value="退職者登録を実行する" 
onclick="location.href='/userEdit/retiree/?staffId=${retireeStaffId}'" />
<input type="button" value="退職者登録せず、メニューに戻る" onclick="location.href='/flowMenu'"/>
<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>
