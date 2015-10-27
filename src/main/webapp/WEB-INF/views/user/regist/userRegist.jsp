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
		<form:form id="formId" modelAttribute="userRegistForm" action="/userRegist/flowConfirm">
			<p>姓：<form:input path="firstName" class="validate[required,maxSize[16]]"/></p>
			<p>名：<form:input path="lastName" class="validate[required,maxSize[16]]"/></p>
			<p>セイ：<form:input path="firstPhonetic" class="validate[required,maxSize[16]]"/></p>
			<p>メイ：<form:input path="lastPhonetic" class="validate[required,maxSize[16]]"/></p>
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
		 	<%-- <p>スタッフID：<form:input path="staffId" class="validate[required,maxSize[16]]"/></p> --%>
		 	<p>
		 		スタッフID:
		 		<form:select path="staffIdFirst">
		 			<option value="AP">AP</option>
		 			<c:if test="${userRegistForm.staffIdFirst != 'NW'}">
						<option value="NW">NW</option>
					</c:if>
					<c:if test="${userRegistForm.staffIdFirst == 'NW'}">
						<option value="NW" selected>NW</option>
					</c:if>
		 		</form:select>
		 		-<form:input path="staffIdSecond" class="validate[required,custom[number],minSize[3],maxSize[3]]" size="4"/>
		 		-<form:input path="staffIdThird" class="validate[required,custom[number],minSize[4],maxSize[4]]" xlsize="4"/>
		 	</p>
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
			<input class="button" type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>
		</form:form>		
		
<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>