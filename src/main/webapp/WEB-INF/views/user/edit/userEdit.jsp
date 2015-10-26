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
		<form:form id="formId" modelAttribute="userEditForm" action="/userEdit/flowConfirm">
		
							<%--　　　　 管理者のみ表示 　　　　--%>
							
			<c:if test="${user.authorityId == 2}">			
				<p>姓：<form:input path="firstName" value="${userData.firstName}" class="validate[required,maxSize[16]]"/></p>
				<p>名：<form:input path="lastName" value="${userData.lastName}" class="validate[required,maxSize[16]]"/></p>
				<p>セイ：<form:input path="firstPhonetic" value="${userData.firstPhonetic}" class="validate[required,maxSize[16]]"/></p>
				<p>メイ：<form:input path="lastPhonetic" value="${userData.lastPhonetic}" class="validate[required,maxSize[16]]"/></p>
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
		 	<%-- 	<p>スタッフID：<form:input path="staffId" value="${userData.staffId}" class="validate[required,maxSize[16]]"/></p> --%>
		 		<p>
		 			スタッフID:
		 			<form:select path="staffIdFirst">
		 				<option value="AP">AP</option>
		 			<c:if test="${userData.staffIdFirst != 'NW'}">
						<option value="NW">NW</option>
					</c:if>
					<c:if test="${userData.staffIdFirst == 'NW'}">
						<option value="NW" selected>NW</option>
					</c:if>
		 			</form:select>-
		 			<form:input path="staffIdSecond" value="${userData.staffIdSecond}" class="validate[required,custom[number],minSize[3],maxSize[3]]" size="4"/>-
		 			<form:input path="staffIdThird" value="${userData.staffIdThird}" class="validate[required,custom[number],minSize[4],maxSize[4]]" size="4"/>
		 		</p>
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
		 		<p>現在のパスワード：<form:password path="password" class="validate[required,maxSize[16]]"/></p>
				<p>新しいパスワード：<form:password path="newPassword" class="text-input"/></p>
				<p>新しいパスワード(再入力)：<form:password path="confirmPassword" class="validate[equals[newPassword]] text-input"/></p>
			</c:if>
			
							<%--　　　　 ここまで管理者のみ表示 　　　　--%>
			
			<c:if test="${user.authorityId == 1}">				
				<p>現在のパスワード：<form:password path="password" class="validate[required,maxSize[16]]"/></p>
				<p>新しいパスワード：<form:password path="newPassword" class="validate[required] text-input"/></p>
				<p>新しいパスワード(再入力)：<form:password path="confirmPassword" class="validate[required, equals[newPassword]] text-input"/></p>
			</c:if>
			
			<form:hidden path="tempStaffId" value="${userData.staffId}"/>
			<input type="hidden" name="user" value="${user}">
	 		<input type="submit" value="登録"/>
			<input class="button" type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>
		</form:form>	

<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>