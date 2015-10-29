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


<!-- <div class="printDemo noPrint"> -->
		
		<h3>スペックシート</h3>
		<!-- 		基本情報 -->
		<table class="speckDetailTable">
			<tr>
				<th>スタッフID</th>
				<td><c:out value="${submitForm.staffId}"/></td>
				<th>年齢</th>
				<td><c:out value="${age}"/></td>
				<th>性別</th>
				<td><c:out value="${sex}"/></td>
				<th>最寄駅</th>
				<td><c:out value="${submitForm.nearestStation}"/>駅</td>
				<th>稼働開始日</th>
				<td>応相談</td>
			</tr>
			<tr>
				<th rowspan="2">IT全体経験</th>
				<c:if test="${submitForm.allExpYear > 0 && submitForm.allExpMonth > 0}">
				<td rowspan="2" colspan="2">　
				<c:out value="${submitForm.allExpYear}"/>年　<c:out value="${submitForm.allExpMonth}"/>か月</td>
				</c:if>
				<c:if test="${submitForm.allExpYear > 0 && submitForm.allExpMonth == 0}">
				<td rowspan="2" colspan="2">　
				<c:out value="${submitForm.allExpYear}"/>年</td>
				</c:if>
				<c:if test="${submitForm.allExpYear == 0}">
				<td rowspan="2" colspan="2">　
				<c:out value="${submitForm.allExpMonth}"/>か月</td>
				</c:if> 
				<th rowspan="2">内訳</th>
				<th>サーバ・NW経験</th>
				<c:if test="${submitForm.serverNetworkExpYear > 0 && submitForm.serverNetworkExpMonth > 0}">
				<td colspan="2">　
				<c:out value="${submitForm.serverNetworkExpYear}"/>年　<c:out value="${submitForm.serverNetworkExpMonth}"/>か月</td>
				</c:if>
				<c:if test="${submitForm.serverNetworkExpYear > 0 && submitForm.serverNetworkExpMonth == 0}">
				<td colspan="2">　
				<c:out value="${submitForm.serverNetworkExpYear}"/>年</td>
				</c:if>
				<c:if test="${submitForm.serverNetworkExpYear == 0}">
				<td colspan="2">　
				<c:out value="${submitForm.serverNetworkExpMonth}"/>か月</td>
				</c:if>
				<th>SE経験</th>
				<c:if test="${submitForm.seExpYear > 0 && submitForm.seExpMonth > 0}">
				<td colspan="2">　
				<c:out value="${submitForm.seExpYear}"/>年　<c:out value="${submitForm.seExpMonth}"/>か月</td>
				</c:if>
				<c:if test="${submitForm.seExpYear > 0 && submitForm.seExpMonth == 0}">
				<td colspan="2">　
				<c:out value="${submitForm.seExpYear}"/>年</td>
				</c:if>
				<c:if test="${submitForm.seExpYear == 0}">
				<td colspan="2">　
				<c:out value="${submitForm.seExpMonth}"/>か月</td>
				</c:if>
			</tr>
			<tr>
				<th>システム開発経験</th>
				<c:if test="${submitForm.developmentExpYear > 0 && submitForm.developmentExpMonth > 0}">
				<td colspan="2">　
				<c:out value="${submitForm.developmentExpYear}"/>年　<c:out value="${submitForm.developmentExpMonth}"/>か月</td>
				</c:if>
				<c:if test="${submitForm.developmentExpYear > 0 && submitForm.developmentExpMonth == 0}">
				<td colspan="2">　
				<c:out value="${submitForm.developmentExpYear}"/>年</td>
				</c:if>
				<c:if test="${submitForm.developmentExpYear == 0}">
				<td colspan="2">　
				<c:out value="${submitForm.developmentExpMonth}"/>か月</td>
				</c:if>
				<th>PG・作業員経験</th>
				<c:if test="${submitForm.pgOperatorExpYear > 0 && submitForm.pgOperatorExpMonth > 0}">
				<td colspan="2">　
				<c:out value="${submitForm.pgOperatorExpYear}"/>年　<c:out value="${submitForm.pgOperatorExpMonth}"/>か月</td>
				</c:if>
				<c:if test="${submitForm.pgOperatorExpYear > 0 && submitForm.pgOperatorExpMonth == 0}">
				<td colspan="2">　
				<c:out value="${submitForm.pgOperatorExpYear}"/>年</td>
				</c:if>
				<c:if test="${submitForm.pgOperatorExpYear == 0}">
				<td colspan="2">　
				<c:out value="${submitForm.pgOperatorExpMonth}"/>か月</td>
				</c:if>
			</tr>
		</table><br>		

		<!-- 		スキル要約 -->
<!-- 		<table class="speckDetailTable"> -->
<!-- 			<tr> -->
<!-- 				<th colspan="8">スキル要約</th> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<th colspan="2">言語</th> -->
<!-- 				<th colspan="2">開発関連技術</th> -->
<!-- 				<th colspan="2">環境(OS等)</th> -->
<!-- 				<th colspan="2">業務範囲(工程)</th> -->
<!-- 			</tr> -->

<%-- 				<c:if test="${skillsSummary.size() != 0}"> --%>
<%-- 				<c:forEach var="skills" items="${skillsSummary}" varStatus="status"> --%>
<%-- 					<td width="100"><c:out value="${skills}" /></td> --%>
<%-- 					<c:if test="${status.index % 8 == 7}"> --%>
<!-- 			 			<tr></tr>  -->
<%-- 					</c:if> --%>
<%-- 				</c:forEach> --%>
<%-- 			</c:if> --%>
<!-- 		</table><br> -->
		
		<!-- 		アピールポイント -->
		<table class="speckDetailTable">
			<tr>
				<th>アピールポイント</th>
			</tr>
			<tr class="tallHeight">
				<td><c:out value="${submitForm.appeal}"/></td>
			</tr>
		</table><br>

<!-- 		<!-- 開発経験のテーブル --> -->
<!-- 		<table class="speckDetailTable"> -->
<!-- 			<tr> -->
<!-- 				<th colspan="8">開発経験</th> -->
<!-- 			</tr> -->

<!-- 			<!-- 		繰り返し --> -->

<!-- 			<tr> -->
<!-- 				<th>No.</th> -->
<!-- 				<th>期間</th> -->
<!-- 				<th>プロジェクト概要</th> -->
<!-- 				<th colspan="2">環境、ツールなど</th> -->
<!-- 				<th>担当工程</th> -->
<!-- 				<th>担当役割</th> -->
<!-- 				<th>規模</th> -->
<!-- 			</tr> -->
<%-- 			<c:if test="${fn:length(developmentExperience) > 0 }" > --%>
<%-- 				<c:forEach var="devExp" items="${developmentExperience}" varStatus="i"> --%>
<!-- 					<tr> -->
<!-- 						　No -->
<%-- 						<td rowspan="5"><c:out value="${i.count}"/></td> --%>
<!-- 						開始時期 -->
<!-- 						<td rowspan="2"> -->
<%-- 							<fmt:formatDate value="${devExp.startDate}" pattern="yyyy/MM"/> --%>
<!-- 							～ -->
<%-- 							<c:if test="${devExp.finishDate == null}"> --%>
<!-- 								現在 -->
<%-- 							</c:if> --%>
<%-- 							<c:if test="${devExp.finishDate != null}"> --%>
<%-- 								<fmt:formatDate value="${devExp.finishDate}" pattern="yyyy/MM"/> --%>
<%-- 							</c:if> --%>
<!-- 						</td> -->
<!-- 						プロジェクト概要 -->
<!-- 						<td rowspan="4"> -->
<%-- 							<c:out value="${devExp.overview}"/> --%>
<!-- 						</td> -->
<!-- 						<th>OS</th> -->
<!-- 						<td> -->
<%-- 							<c:forEach var="os" items="${devExp.osNameList}" varStatus="j"> --%>
<%-- 								<c:out value="${os}"/> --%>
<%-- 								<c:if test="${j.last == false }">/</c:if> --%>
<%-- 							</c:forEach> --%>
<!-- 						</td> -->
<!-- 						担当工程 -->
<!-- 						<td rowspan="4"> -->
<%-- 							<c:forEach var="process" items="${devExp.processNameList}" varStatus="j"> --%>
<%-- 								<c:out value="${process }"/> --%>
<%-- 								<c:if test="${j.last == false}"> --%>
<!-- 									<br> -->
<%-- 								</c:if> --%>
<%-- 							</c:forEach> --%>
<!-- 						</td> -->
<!-- 						担当役割 -->
<!-- 						<td rowspan="4"> -->
<%-- 							<c:forEach var="role" items="${devExp.role}" varStatus="j"> --%>
<%-- 								<c:out value="${role}"/> --%>
<%-- 								<c:if test="${j.last == false}">/</c:if> --%>
<%-- 							</c:forEach> --%>
<!-- 						</td> -->
<!-- 						<th>チーム</th> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>言語</th> -->
<!-- 						<td> -->
<%-- 							<c:forEach var="language" items="${devExp.languageNameList}" varStatus="j"> --%>
<%-- 								<c:out value="${language}"/> --%>
<%-- 								<c:if test="${j.last == false}">/</c:if> --%>
<%-- 							</c:forEach> --%>
<!-- 						</td> -->
<!-- 						チーム人数 -->
<!-- 						<td> -->
<%-- 							<c:out value="${devExp.teamNum}"/> --%>
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td rowspan="2"> -->
<!-- 							開発期間 -->
<%-- 							<c:if test="${devExp.period / 12 >= 1}"> --%>
<%-- 								<fmt:formatNumber value="${devExp.period / 12}" pattern="###"/>年 --%>
<%-- 							</c:if> --%>
<%-- 							<c:out value="${devExp.period % 12}"/>カ月 --%>
<!-- 						</td> -->
<!-- 						<th rowspan="2">その他</th> -->
<!-- 						<td rowspan="2"> -->
<%-- 							<c:forEach var="other" items="${devExp.other}" varStatus="j"> --%>
<%-- 								<c:out value="${other}"/> --%>
<%-- 								<c:if test="${j.last == false}">/</c:if> --%>
<%-- 							</c:forEach> --%>
<!-- 						</td> -->
<!-- 						<th>開発全体</th> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						開発全体 -->
<!-- 						<td> -->
<%-- 							<c:out value="${devExp.allNum}"/> --%>
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th class="tallHeight">作業内容</th> -->
<!-- 						<td colspan="6"> -->
<%-- 							<c:out value="${devExp.content}"/> --%>
							
				
<!-- 						</td> -->
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<%-- 			</c:if> --%>
			
<!-- 		</table><br> -->


<!-- <!-- 	資格	 --> -->
<!-- 		<table class="speckDetailTable"> -->
<!-- 			<tr> -->
<!-- 				<th colspan="6">資格</th> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<th>資格名</th> -->
<!-- 				<th>取得日</th> -->
<!-- 				<th>資格名</th> -->
<!-- 				<th>取得日</th> -->
<!-- 				<th>資格名</th> -->
<!-- 				<th>取得日</th> -->
<!-- 			</tr> -->
			
<!-- 			<tr> -->
<%-- 			<c:forEach var="license" items="${specDetailLicensePageList}" varStatus="i"> --%>
<%-- 				<c:if test="${ ( i.index +1 ) % 4 == 0 }"> --%>
<!-- 					</tr> -->
<!-- 					<tr> -->
<%-- 				</c:if> --%>
<%-- 				<td><c:out value="${license.name}"/></td> --%>
<%-- 				<td><fmt:formatDate value="${license.acquireDate }" pattern="yyyy/MM/dd"/></td> --%>
				
<%-- 				<c:if test="${(i.last && (i.count - 1 ) == 0) || (i.last && (i.count - 1 ) % 3 == 0)}"> --%>
<!-- 				<td></td> -->                              
<!-- 				<td></td> -->                              
<!-- 				<td></td> -->                              
<!-- 				<td></td> -->                              
<%-- 				</c:if> --%>                               
						                                       
						                                       
<%-- 				<c:if test="${(i.last && (i.count - 1 )  = = 1) || (i.last && (i.count - 1 ) % 3 = 1)}"> --%>
<!-- 				<td></td> -->                              
<!-- 				<td></td> -->                              
<%-- 				</c:if> --%>                               
				                                               
<%-- 			</c:forEach> --%>                              
<!-- 			</tr> -->                                      
<!-- 		</table> -->                                       
	<!--PrintEnd-->	                                           
	${submitForm}                                                    
	<form:form modelAttribute="specForm" action="/spec/regist"  >
		
		<input type="submit" value="登録する"/>
	</form:form>
</body>
</html>