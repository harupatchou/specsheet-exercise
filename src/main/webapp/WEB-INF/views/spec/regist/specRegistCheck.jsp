<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">


		<%--ここから下にコンテンツを挿入 --%>
<%-- 		<form:form modelAttribute="specForm" action="/spec/regist" --%>
<%-- 			name="SpecForm"> --%>
<!-- 			<h1 id="title">下記の内容で登録してよろしいですか？</h1> -->

<!-- 		<input type="submit" value="登録"/> -->

<%-- 		</form:form> --%>
<h1>登録完了しました</h1>
<input type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>
		<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>