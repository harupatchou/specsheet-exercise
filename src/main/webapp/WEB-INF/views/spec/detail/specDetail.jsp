<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スペックシート詳細画面</title>
<link rel="stylesheet" href="../css/specSystem.css">
<link rel="stylesheet" href="../css/specDetail.css">
<link rel="stylesheet" href="../../css/print.css">


<script src="../../../js/spec/detail/print.js"></script>
<!-- <script src="../js/submitStop.js"></script> -->
<!-- <script src="../js/logoutConfirmationDialog.js"></script> -->
</head>
<body>


<div class="printDemo noPrint">
		<div id="headerArea">
		<span id="heading" style="color: white">スペックシート詳細画面</span><br>
		<c:out value="${userLogin.name}" />さんログイン中<br>
		
		<div>
		<div class="menu-button"></div>
			<div class="menu-button"><input type="button" value="ファイル出力"/></div>
			<div class="menu-button"><input type="submit" value="印刷" onclick="PrintScript();"/></div>
			<div class="menu-button"><input type="button" value="編集" onclick="location.href='/spec/registIndex/?staffId=${staffId}'"/></div>
			<c:if test="${userLogin.authorityId == 2}">
			<div class="menu-button"><input type="submit" value="退職者登録" onclick="location.href='/specDelete/?staffId=${staffId}'"/></div>
			</c:if>
			
			<div class="menu-button">
			<form:form action="/userEdit/initializationConfirmation" >
			<c:if test="${spec.staffId != null }">
			<input type="hidden" name="staffId" value="${spec.staffId }" />
			</c:if>
			<c:if test="${spec.staffId == null }">
			<input type="hidden" name="staffId" value="${userLogin.staffId }" />
			</c:if>
			<div class="menu-button"><input type="submit" value="パスワード初期化"/></div>
	 		<div class="menu-button"><input type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/></div>
	 		<div class="menu-button"><input type="button" value="ログアウト" onclick="location.href='/userLogout'" ></div>
	 		</form:form>
	 		</div>
	 	</div>
		</div>
<%-- 		<form:form modelAttribute="stationTimeForm" action="/detail/searchTime"> --%>
<%-- 			<form:input path="arrivalStation" class="inputMiddle"/>駅 --%>
<%-- 			<form:hidden path="nearStation" value="${spec.nearestStation}"/> --%>
<%-- 			<input type="hidden" name="staffId" value="${spec.staffId}"/> --%>
<!-- 			<input type="submit" value="最寄駅～アサイン先への時間検索"/> -->
<%-- 			</form:form> --%>
			<p><c:out value="${spec.nearestStation}"/>駅～<c:out value="${arrivalStation}"/>駅への時間　<c:out value="${stationHour}"/></p>
<%-- 		<form action="/findByStaffId" method="post"> --%>
<!-- 		<p>動作テスト<input type="text" name="staffId"/> -->
<!-- 	 		<input type="submit" value="登録"/><br><br> -->
<!-- 	 	</p> -->
<%-- 	 	</form> --%>
</div>
<!--PrintStart-->
<p align="right" class="printDemo noScreen">株式会社ラクス</p>
		<h3>スペックシート</h3>
		<!-- 		基本情報 -->
		<table class="speckDetailTable">
			<tr>
				<th>スタッフID</th>
				<td><c:out value="${spec.staffId}"/></td>
				<th>年齢</th>
				<td><c:out value="${age}"/></td>
				<th>性別</th>
				<td><c:out value="${sex}"/></td>
				<th>最寄駅</th>
				<td><c:out value="${spec.nearestStation}"/>駅</td>
				<th>稼働開始日</th>
				<td>応相談</td>
			</tr>
			<tr>
				<th rowspan="2">IT全体経験</th>
				<c:if test="${spec.year > 0 && spec.month > 0}">
				<td rowspan="2" colspan="2">　
				<c:out value="${spec.year}"/>年　<c:out value="${spec.month}"/>か月</td>
				</c:if>
				<c:if test="${spec.year > 0 && spec.month == 0}">
				<td rowspan="2" colspan="2">　
				<c:out value="${spec.year}"/>年</td>
				</c:if>
				<c:if test="${spec.year == 0}">
				<td rowspan="2" colspan="2">　
				<c:out value="${spec.month}"/>か月</td>
				</c:if> 
				<th rowspan="2">内訳</th>
				<th>サーバ・NW経験</th>
				<c:if test="${specDetailExpBreakdownPage.year[1] > 0 && specDetailExpBreakdownPage.month[1] > 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.year[1]}"/>年　<c:out value="${specDetailExpBreakdownPage.month[1]}"/>か月</td>
				</c:if>
				<c:if test="${specDetailExpBreakdownPage.year[1] > 0 && specDetailExpBreakdownPage.month[1] == 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.year[1]}"/>年</td>
				</c:if>
				<c:if test="${specDetailExpBreakdownPage.year[1] == 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.month[1]}"/>か月</td>
				</c:if>
				<th>SE経験</th>
				<c:if test="${specDetailExpBreakdownPage.year[3] > 0 && specDetailExpBreakdownPage.month[3] > 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.year[3]}"/>年　<c:out value="${specDetailExpBreakdownPage.month[3]}"/>か月</td>
				</c:if>
				<c:if test="${specDetailExpBreakdownPage.year[3] > 0 && specDetailExpBreakdownPage.month[3] == 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.year[3]}"/>年</td>
				</c:if>
				<c:if test="${specDetailExpBreakdownPage.year[3] == 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.month[3]}"/>か月</td>
				</c:if>
			</tr>
			<tr>
				<th>システム開発経験</th>
				<c:if test="${specDetailExpBreakdownPage.year[2] > 0 && specDetailExpBreakdownPage.month[2] > 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.year[2]}"/>年　<c:out value="${specDetailExpBreakdownPage.month[2]}"/>か月</td>
				</c:if>
				<c:if test="${specDetailExpBreakdownPage.year[2] > 0 && specDetailExpBreakdownPage.month[2] == 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.year[2]}"/>年</td>
				</c:if>
				<c:if test="${specDetailExpBreakdownPage.year[2] == 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.month[2]}"/>か月</td>
				</c:if>
				<th>PG・作業員経験</th>
				<c:if test="${specDetailExpBreakdownPage.year[4] > 0 && specDetailExpBreakdownPage.month[4] > 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.year[4]}"/>年　<c:out value="${specDetailExpBreakdownPage.month[4]}"/>か月</td>
				</c:if>
				<c:if test="${specDetailExpBreakdownPage.year[4] > 0 && specDetailExpBreakdownPage.month[4] == 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.year[4]}"/>年</td>
				</c:if>
				<c:if test="${specDetailExpBreakdownPage.year[4] == 0}">
				<td colspan="2">　
				<c:out value="${specDetailExpBreakdownPage.month[4]}"/>か月</td>
				</c:if>
			</tr>
		</table><br>

<!-- ここらへんテスト用 -->		
<c:forEach items="${specDetailPageList }" var="specDetailPage">
<c:out value="${specDetailPage.breakdownName }" />
</c:forEach>


		

		<!-- 		スキル要約 -->

		<table class="speckDetailTable">
			<tr>
				<th colspan="8">スキル要約</th>
			</tr>
			<tr>
				<th colspan="2">言語</th>
				<th colspan="2">開発関連技術</th>
				<th colspan="2">環境(OS等)</th>
				<th colspan="2">業務範囲(工程)</th>
			</tr>

<%-- 			<c:if test="${page.allContents.size() != 0}"> --%>
<%-- 				<c:forEach var="skills" items="${page.allContents}" varStatus="status"> --%>
<%-- 					<td width="100"><c:out value="${skills}" /></td> --%>
<%-- 					<c:if test="${status.index % 8 == 7}"> --%>
<!-- 			 			<tr></tr>  -->
<%-- 					</c:if> --%>
<%-- 				</c:forEach> --%>
<%-- 			</c:if> --%>
				<c:if test="${skillsSummary.size() != 0}">
				<c:forEach var="skills" items="${skillsSummary}" varStatus="status">
					<td width="100"><c:out value="${skills}" /></td>
					<c:if test="${status.index % 8 == 7}">
			 			<tr></tr> 
					</c:if>
				</c:forEach>
			</c:if>
		</table><br>
		

		<!-- 		アピールポイント -->
		<table class="speckDetailTable">
			<tr>
				<th>アピールポイント</th>
			</tr>
			<tr class="tallHeight">
				<td><c:out value="${spec.appeal}"/></td>
			</tr>
		</table><br>

		<!-- 開発経験のテーブル -->
		
			${developmentExperience}
		<table class="speckDetailTable">
			<tr>
				<th colspan="8">開発経験</th>
			</tr>

			<!-- 		繰り返し -->

			<tr>
				<th>No.</th>
				<th>期間</th>
				<th>プロジェクト概要</th>
				<th colspan="2">環境、ツールなど</th>
				<th>担当工程</th>
				<th>担当役割</th>
				<th>規模</th>
			</tr>
			<c:if test="${fn:length(developmentExperience) > 0 }" >
				<c:forEach var="devExp" items="${developmentExperience}" varStatus="i">
					<tr>
						<!--　No -->
						<td rowspan="5"><c:out value="${i.count}"/></td>
						<!-- 開始時期 -->
						<td rowspan="2">
							<fmt:formatDate value="${devExp.startDate}" pattern="yyyy/MM"/>
							～
							<c:if test="${devExp.finishDate == null}">
								現在
							</c:if>
							<c:if test="${devExp.finishDate != null}">
								<fmt:formatDate value="${devExp.finishDate}" pattern="yyyy/MM"/>
							</c:if>
						</td>
						<!-- プロジェクト概要 -->
						<td rowspan="4">
							<c:out value="${devExp.overview}"/>
						</td>
						<th>OS</th>
						<td>
							<c:forEach var="os" items="${devExp.osName}" varStatus="j">
								<c:out value="${os}"/>
								<c:if test="${j.last == false }">/</c:if>
							</c:forEach>
						</td>
						<!-- 担当工程 -->
						<td rowspan="4">
							<c:forEach var="process" items="${devExp.processName}" varStatus="j">
								<c:out value="${process }"/>
								<c:if test="${j.last == false}">
									<br>
								</c:if>
							</c:forEach>
						</td>
						<!-- 担当役割 -->
						<td rowspan="4">
							<c:forEach var="role" items="${devExp.role}" varStatus="j">
								<c:out value="${role}"/>
								<c:if test="${j.last == false}">/</c:if>
							</c:forEach>
						</td>
						<th>チーム</th>
					</tr>
					<tr>
						<th>言語</th>
						<td>
							<c:forEach var="language" items="${devExp.languageName}" varStatus="j">
								<c:out value="${language}"/>
								<c:if test="${j.last == false}">/</c:if>
							</c:forEach>
						</td>
						<!-- チーム人数 -->
						<td>
							<c:out value="${devExp.teamNum}"/>
						</td>
					</tr>
					<tr>
						<td rowspan="2">
							<!-- 開発期間 -->
							<c:if test="${devExp.period / 12 >= 1}">
								<fmt:formatNumber value="${devExp.period / 12}" pattern="###"/>年
							</c:if>
							<c:out value="${devExp.period % 12}"/>カ月
						</td>
						<th rowspan="2">その他</th>
						<td rowspan="2">
							<c:forEach var="other" items="${devExp.other}" varStatus="j">
								<c:out value="${other}"/>
								<c:if test="${j.last == false}">/</c:if>
							</c:forEach>
						</td>
						<th>開発全体</th>
					</tr>
					<tr>
						<!-- 開発全体 -->
						<td>
							<c:out value="${devExp.allNum}"/>
						</td>
					</tr>
					<tr>
						<th class="tallHeight">作業内容</th>
						<td colspan="6">
							<c:out value="${devExp.content}"/>
							
				
<%--　　★とりあえずの印刷改ページ処理　⇒ --%><c:if test="${i.count % 3 == 0}"><div class="always"></div></c:if>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			
		</table><br>


<!-- 	資格	 -->
		<table class="speckDetailTable">
			<tr>
				<th colspan="6">資格</th>
			</tr>
			<tr>
				<th>資格名</th>
				<th>取得日</th>
				<th>資格名</th>
				<th>取得日</th>
			</tr>
			<c:forEach var="license" items="${specDetailLicensePageList}" varStatus="i">
				<c:if test="${i.index%2==0}">
					<tr>
				</c:if>
				<td>
					<c:out value="${license.name}"/>
				</td>
				<td>
					<fmt:formatDate value="${license.acquireDate }" pattern="yyyy/MM/dd"/>
				</td>
				<c:if test="${i.index%3==2}">
				</c:if>
			</c:forEach>
		</table>
	<!--PrintEnd-->	
	 	<br>
		<br>
		
<%-- 		<input type="button" value="編集" onclick="location.href='/specedit?staffId=${staffId}'"/> --%>
<%-- 	<form action="/specDelete/"> --%>
<!-- 		<input type="submit" value="退職者登録" /> -->
<%-- 	</form> --%>
<!-- 	<input type="button" value="パスワード初期化"/> -->
<!-- 	 	<input type="button" value="メニューに戻る" onclick="location.href='/menu'"/> -->
</body>
</html>