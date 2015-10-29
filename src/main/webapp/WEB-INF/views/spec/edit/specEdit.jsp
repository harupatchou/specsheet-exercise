<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="/js/spec/edit/SpecSheetEdit.js"></script>
<script src="/js/spec/window/windowsOpen.js"></script>
<script src="/js/lib/jquery-2.1.4.min.js"></script>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">


		<%--ここから下にコンテンツを挿入 --%>
		<form:form modelAttribute="specForm" action="/spec/edit"
			name="SpecForm">
			<h1 id="title">スペックシート編集</h1>
			<!-- 名前 -->
			<p>姓：<form:input path="firstName" value="${user.firstName}" /></p>
			<p>名：<form:input path="lastName" value="${user.lastName}" /></p>
			<!-- 勤務状況 -->
			<p>状況：
			<form:select path="stateFlag" items="${stateMap}" value="${spec.stateFlag}" />
			<br>
			</p>
			<!-- コメント -->
			<p>編集時のコメント：
			<form:textarea path="comment" value="${spec.comment}" placeholder="(例)初期登録" />
			</p>

			<!-- 基本情報 -->
			<table class="speckDetailTable formMini">
				<tr>
					<th>スタッフID</th>
					<td><form:input path="staffId" value="${user.staffId}" /></td>

					<th>年齢</th>
					<td>
					<form:select path="ageFlag" items="${ageMap}" value="${spec.ageId}"/>
					<br></td>

					<th>性別</th>
					<td><c:out value="${user.sex}" /></td>

					<th>最寄駅</th>
					<td><form:input id="inputMini" path="nearestStation" value="${spec.nearestStation}" />駅</td>

					<th>稼働開始日</th>
					<td>応相談</td>

				</tr>

			</table>

			<!-- 経験年数 -->
			<table class="speckDetailTable">
				<tr>
					<th rowspan="2">IT全体経験</th>
					<td rowspan="2" colspan="2">
					<form:input id="inputMini" path="allExpYear"   value="${spec.year}"/>年
					<form:input id="inputMini" path="allExpMonth"  value="${spec.month}"/>ヵ月</td> 
					<th rowspan="2">内訳</th>
					<th>サーバ・NW経験</th>
					<td colspan="2">
					<form:input id="inputMini"  path="serverNetworkExpYear"  value="${breakdown.serverNetworkExpYear}"/>年
					<form:input id="inputMini"  path="serverNetworkExpMonth"  value="${breakdown.serverNetworkExpMonth}"/>ヵ月</td> 
					<th>SE経験</th>
	 				<td colspan="2">
	 				<form:input id="inputMini" path="seExpYear" value="${breakdown.seExpYear}"/>年
	 				<form:input id="inputMini" path="seExpMonth" value="${breakdown.seExpMonth}"/>ヵ月</td> 
				</tr>
				<tr>
					<th>システム開発経験</th>
					<td colspan="2">
					<form:input id="inputMini" path="developmentExpYear"  value="${breakdown.developmentExpYear}"/>年
					<form:input id="inputMini" path="developmentExpMonth"  value="${breakdown.developmentExpMonth}"/>ヵ月</td> 
					<th>PG・作業員経験</th>
					<td colspan="2">
					<form:input id="inputMini" path="pgOperatorExpYear" value="${breakdown.pgOperatorExpYear}"/>年
					<form:input id="inputMini" path="pgOperatorExpMonth" value="${breakdown.pgOperatorExpMonth}"/>ヵ月</td> 
				</tr>
			</table>

			<br>
			<!-- スキル要約 -->
			<div class="inputSkill">
				<table class="speckDetailTable" id="userSkillTable">
					<tr class="InputTr">
						<th colspan="9">スキル要約 <input type="button" value="行追加" id="detailAdd" 
						onclick="AddSkill('userSkillTable','${langMap}','${osMap}')" /> 
						<input type="button" value="最終行削除" onclick="DelSkillColumn('userSkillTable')"/>
						</th>
					</tr>
					<tr>
						<th colspan="3">言語</th>
						<th>開発関連技術</th>
						<th colspan="2">環境(OS等)</th>
					</tr>
					<tr>
						<td><form:select path="skillLangList" items="${langMap}"/></td>
						<td><form:checkbox path="expFlagInt" id="check" value="0"/>実務
							<form:checkbox path="expFlagInt" id="check" value="1"/>実務外</td>
						<td><form:input path="monthOfLangExp" id="inputMini" type="text"/>ヵ月</td>
						<td><form:input path="relatedTech" value="${spec.relatedTech}"/></td>
						<td><form:select path="skillOsList" items="${osMap}"/><br></td>
						<td><form:input path="monthOfOsExp" id="inputMini" type="text"/>ヵ月</td>
					</tr>
				</table>
			</div>
			<br>

			<!-- 		アピールポイント -->
			<table class="speckDetailTable">
				<tr>
					<th>アピールポイント</th>
				</tr>
				<tr class="tallHeight">
					<td><form:textarea path="appeal" class="appeal" rows="8" cols="107"></form:textarea></td>
				</tr>
			</table>
			
			<br>
			
			<!--開発経験 -->
				<table class="speckDetailTable">
				<tr>
						<th colspan="9">
						開発経験
						<input type="button" value="行追加" id="detailAdd" 
						onclick="AddDetail('addTable')" />
						</th>
					</tr>
				</table>
				
				<table id="addTable" class="speckDetailTable">
				</table>
				
			<!--繰り返し -->
				<table id="speckTable" class="speckDetailTable">
				<c:forEach var="project" items="${projectList}" varStatus="i">
					<tbody id="testTable" class="speckDetailTable">
					<tr>
						<th>No.</th>
						<th>期間</th>
						<th>プロジェクト概要</th>
						<th colspan="2">環境、ツールなど</th>
						<th>担当工程</th>
						<th>担当役割</th>
						<th>規模</th>
					</tr>
					<tr class="InputTr">
					<!-- プロジェクト番号 -->
						<c:if test="${i.last}">
							<td rowspan="5" id="lastNo" class="proNo" ></td>
							<form:input type="hidden" path="projectNo" value="${i.index+1}"/>
							<input type="hidden" name="lastHidden" id="lastHidden" value="1" />
						</c:if>
						<c:if test="${!i.last}">
							<td rowspan="5" class="proNo"></td>
							<form:input type="hidden" path="projectNo" value="${i.index+1}"/>
						</c:if>
					<!-- 開発時期 -->
						<td rowspan="4">
						<form:input path="startDay" value="${project.startDate}"/><br>
						～<br>
						<form:input path="finishDay" value="${project.finishDate}" />
						</td>
						
					<!-- プロジェクト概要 -->
						<td rowspan="4">
						<form:textarea path="overview" class="overview" rows="10" cols="12" />
						<input type="hidden" id="overviewHidden${i.index}" value="${project.overview}"/>
						</td>
						
					<!-- OS -->
						<th>OS</th>
						<td>
						<form:input path="os" class="firstOs" value="${osEditList[(i.index)]}" />
						<input type="button" value="OS選択" id="btnMini"
							onclick="return openWin('/spec/osWindow?btnNo=${(i.index+1)}')" />
						</td>
					
					<!-- 担当工程 -->
						<td rowspan="4">
						<form:input path="process" class="firstProcess"/>
						<input type="button" value="担当工程" id="btnMini"
							onclick="return openWin('/spec/processWindow?btnNo=${(i.index+1)}')" />
						</td>
						
					<!-- 担当役割 -->
						<td rowspan="4">
						<form:textarea path="role" id="inputResponsible" class="role" />
						<input type="hidden" id="roleHidden${i.index}" value="${project.role}"/>
						</td>
			
						<th>チーム</th>
					</tr>
					
					<tr>
					<!-- 言語 -->
						<th>言語</th>
						<td>
						<form:input path="lang" class="firstLang"/>
						<input type="button" value="言語選択" id="btnMini"
							onclick="return openWin('/spec/langWindow?btnNo=${(i.index+1)}')" />
						</td>
						
					<!-- チーム人数 -->
						<td><form:input path="teamNum" id="inputMini" value="${project.teamNum}"/>人</td>
					</tr>
					
					<tr>
					<!-- 開発関連技術 -->
						<th rowspan="2">開発関連技術</th>
						<td rowspan="2">
						<form:textarea path="other" id="inputOther" class="other" />
						<input type="hidden" id="otherHidden${i.index}" value="${project.other}" />
						</td>
						<th>開発全体</th>
					</tr>
					<tr>
						<td><form:input path="allNum" id="inputMini" value="${project.allNum}"/>人</td>
					</tr>
					<tr>
						<th class="tallHeight">作業内容</th>
						<td colspan="7">
						<form:textarea path="content" id="inputWorkDetail" class="content" />
						<input type="hidden" id="contentHidden${i.index}" value="${project.content}"/>
						</td>
					</tr>
					<tr>
						<th colspan="9">
						この開発経験を削除 
						<input type="button" value="行削除" id="deleteAdd" 
						onclick="DeleteDetail('testTable')" />
						<c:if test="${i.last}">
						</c:if>
						</th>
					</tr>
				</tbody>
				</c:forEach>
				</table>
			<br>

			<!-- 		資格要約 -->
			<div class="inputSkill">
				<table class="speckDetailTable">
					<tr>
						<th colspan="9">資格 <input type="button" value="行追加" /> <input
							type="button" value="最終行削除" />
						</th>
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
						<td>○○資格</td>
						<td>2015/07/20</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>○○資格</td>
						<td>2015/07/20</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
			<br>
		<input type="submit" value="更新内容確認"/>
		<input class="button" type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>
		</form:form>
		<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>