<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">
		
<%--ここから下にコンテンツを挿入 --%>
<!-- <div class="printDemo noPrint"> -->
		
		<h3>スペックシート</h3>
		<!-- 		基本情報 -->
		
		<c:out value="${SkillsSummary}"/>
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
			
		
				<c:forEach var="skills" items="${SkillsSummary}" varStatus="status">
					<td width="100"><c:out value="${skills}" /></td>
					<c:if test="${status.index % 8 == 7}">
			 			<tr></tr> 
					</c:if>
				</c:forEach>
		</table><br> 
		
		<!-- 		アピールポイント -->
		<table class="speckDetailTable">
			<tr>
				<th>アピールポイント</th>
			</tr>
			<tr class="tallHeight">
				<td><c:out value="${submitForm.appeal}"/></td>
			</tr>
		</table><br>

		<!-- 開発経験のテーブル -->
		<table class="speckDetailTable">
			<tr>
				<th colspan="8">開発経験</th>
			</tr>
			<tr>
				<th>No.</th>
				<th>期間</th>
				<th>プロジェクト概要</th>
				<th colspan="2">環境、ツールなど</th>
				<th>担当工程</th>
				<th>担当役割</th>
				<th>規模</th>
			</tr>
				<c:forEach var="devExp" items="${devPage.projectNo}" varStatus="i">
					<tr>
						<td rowspan="5"><c:out value="${devExp}"/></td>
						<td rowspan="4">
							<c:out value="${devPage.startDay.get(i.index)}"/><br>
							～<br>
							<c:if test="${devPage.finishDay.get(i.index) == null}">
								現在
							</c:if>
							<c:if test="${devPage.finishDay.get(i.index) != null}">
								<c:out value="${devPage.finishDay.get(i.index)}"/>
							</c:if>
						</td>
						<td rowspan="4">
							<c:out value="${devPage.overview.get(i.index)}"/>
						</td>
						<th>OS</th>
						<td>
							<c:out value="${devPage.os.get(i.index)}"/>
						</td>
						<td rowspan="4">
							<c:out value="${devPage.process.get(i.index)}"/>
						</td>
						<td rowspan="4">
							<c:out value="${devPage.role.get(i.index)}"/>
						</td>
						<th>チーム</th>
					</tr>
					<tr>
						<th>言語</th>
						<td>
							<c:out value="${devPage.lang.get(i.index)}"/>
						</td>
						<td>
							<c:out value="${devPage.teamNum.get(i.index)}"/>
						</td>
					</tr>
					<tr>
						<th rowspan="2">その他</th>
						<td rowspan="2">
							<c:out value="${devPage.other.get(i.index)}"/>
						</td>
						<th>開発全体</th>
					</tr>
					<tr>
						<td>
							<c:out value="${devPage.allNum.get(i.index)}"/>
						</td>
					</tr>
					<tr>
						<th class="tallHeight">作業内容</th>
						<td colspan="6">
							<c:out value="${devPage.content.get(i.index)}"/>
						</td>
					</tr>
				</c:forEach>
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
				<th>資格名</th>
				<th>取得日</th>
			</tr>
			<tr>
			<c:forEach var="license" items="${submitForm.lisenceName}" varStatus="i">
				<c:if test="${i.count % 4 == 0 }">
					</tr>
					<tr>
				</c:if>
				<td><c:out value="${license}"/></td>
				<td><c:out value="${submitForm.strAcquireDate[i.index]}"/></td>
			</c:forEach>                              
			</tr>                                      
		</table>                                       
	<!--PrintEnd-->                                              
	<form:form modelAttribute="specForm" action="/spec/regist"  >
		
		<input type="submit" value="登録する"/>
	</form:form>
	
	<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>
		
