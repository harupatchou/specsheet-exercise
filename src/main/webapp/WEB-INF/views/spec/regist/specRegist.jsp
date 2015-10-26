<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="/js/spec/SpecSheet.js"></script>
<script src="/js/spec/windowsOpen.js"></script>
<script src="/js/lib/jquery-2.1.4.min.js"></script>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">


		<%--ここから下にコンテンツを挿入 --%>
		<form:form modelAttribute="specForm" action="/spec/regist"
			name="SpecForm">
			<h1 id="title">スペックシート登録</h1>
			<!-- 名前 -->
			<p>姓：<form:input path="firstName" value="${user.firstName}" /></p>
			<p>名：<form:input path="lastName" value="${user.lastName}" /></p>
			<!-- 勤務状況 -->
			<p>状況：
			<form:select path="stateFlag">
				<option value="0">現場</option>
				<option value="1">待機</option>
			</form:select><br>
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
					<td><select>
							<option>20代前半</option>
							<option>20代後半</option>
							<option>30代前半</option>
							<option>30代後半</option>
							<option>40代前半</option>
							<option>40代後半</option>
							<option>50代前半</option>
							<option>50代後半</option>
					</select><br></td>

					<th>性別</th>
					<td>${user.sex}</td>

					<th>最寄駅</th>
					<td><form:input id="inputMini" path="nearestStation" />駅</td>

					<th>稼働開始日</th>
					<td>応相談</td>

				</tr>

			</table>

			<!-- 経験年数 -->
			<table class="speckDetailTable">
				<tr>
					<th rowspan="2">IT全体経験</th>
					<td rowspan="2" colspan="2">
					<form:input id="inputMini" path="allExpYear"   value="${experience.allExpYear}"/>年
					<form:input id="inputMini" path="allExpMonth"  value="${experience.allExpMonth}"/>ヵ月</td> 
					<th rowspan="2">内訳</th>
					<th>サーバ・NW経験</th>
					<td colspan="2">
					<form:input id="inputMini"  path="serverNetworkExpYear"  value="${experience.serverNetworkExpYear}"/>年
					<form:input id="inputMini"  path="serverNetworkExpMonth"  value="${experience.serverNetworkExpMonth}"/>ヵ月</td> 
					<th>SE経験</th>
	 				<td colspan="2">
	 				<form:input id="inputMini" path="seExpYear" value="${experience.seExpYear}"/>年
	 				<form:input id="inputMini" path="seExpMonth" value="${experience.seExpMonth}"/>ヵ月</td> 
				</tr>
				<tr>
					<th>システム開発経験</th>
				<td colspan="2">
				<form:input id="inputMini" path="developmentExpYear"  value="${experience.developmentExpYear}"/>年
				<form:input id="inputMini" path="developmentExpMonth"  value="${experience.developmentExpMonth}"/>ヵ月</td> 
				<th>PG・作業員経験</th>
				<td colspan="2">
				<form:input id="inputMini" path="pgOperatorExpYear" value="${experience.pgOperatorExpYear}"/>年
				<form:input id="inputMini" path="pgOperatorExpMonth" value="${experience.pgOperatorExpMonth}"/>ヵ月</td> 
				</tr>
			</table>

			<br>
			<!-- スキル要約 -->
			<div class="inputSkill">
				<table class="speckDetailTable">
					<tr class="InputTr">
						<th colspan="9">スキル要約 <input type="button" value="行追加" /> <input
							type="button" value="最終行削除" />
						</th>
					</tr>
					<tr>
						<th colspan="3">言語</th>
						<th>開発関連技術</th>
						<th colspan="2">環境(OS等)</th>
					</tr>
					<tr>
						<td><select>
								<option>Java</option>
								<option>PHP</option>
								<option>Scala</option>
								<option>その他</option>
						</select></td>
						<td><input type="checkbox" id="check">実務</td>
						<td><input id="inputMini" type="text">ヵ月</td>
						<td><input type="text" /></td>
						<td><select>
								<option>Windows</option>
								<option>Linux</option>
								<option>Mac</option>
								<option>その他</option>
						</select><br></td>
						<td><input id="inputMini" type="text">ヵ月</td>
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
			<!--繰り返し -->
				<table class="speckDetailTable">
				<tr>
						<th colspan="9">
						開発経験
						<input type="button" value="行追加" id="detailAdd" 
						onclick="AddDetail('addTable',lastNo)" />
						</th>
					</tr>
				</table>
				
				<table id="addTable" class="speckDetailTable">
				</table>
				<table id="speckTable" class="speckDetailTable">
					<tbody class="speckDetailTable">
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
						<td rowspan="5" class="proNo" id="lastNo">1</td>
						<form:input type="hidden" path="projectNo" value="" />
					<!-- 開発時期 -->
						<td rowspan="4">
						<form:input path="startDay" /><br>
						～<br>
						<form:input path="finishDay" />
						</td>
						
					<!-- プロジェクト概要 -->
						<td rowspan="4">
						<form:textarea path="overview" rows="10" cols="12" />
						</td>
						
					<!-- OS -->
						<th>OS</th>
						<td>
						<form:input path="os"/>
						<input type="button" value="OS選択" id="btnMini"
							onclick="return openWin('/spec/osWindow?projectNo=1')" />
						</td>
					
					<!-- 担当工程 -->
						<td rowspan="4">
						<form:input path="process1" size="10"/>
						<input type="button" value="担当工程" id="btnMini"
							onclick="return openWin('/spec/processWindow?projectNo=1','osTest')" />
						</td>
						
					<!-- 担当役割 -->
						<td rowspan="4">
						<form:textarea path="role" id="inputResponsible"></form:textarea>
						</td>
			
						<th>チーム</th>
					</tr>
					
					<tr>
					<!-- 言語 -->
						<th>言語</th>
						<td>
						<form:input path="lang1"/>
						<input type="button" value="言語選択" id="btnMini"
							onclick="return openWin('/spec/langWindow?projectNo=1')" />
						</td>
						
					<!-- チーム人数 -->
						<td><form:input path="teamNum" id="inputMini" />人</td>
					</tr>
					
					<tr>
					<!-- 開発関連技術 -->
						<th rowspan="2">開発関連技術</th>
						<td rowspan="2"><form:textarea path="other" id="inputOther"></form:textarea></td>
						<th>開発全体</th>
					</tr>
					<tr>
						<td><form:input path="allNum" id="inputMini" />人</td>
					</tr>
					<tr>
						<th class="tallHeight">作業内容</th>
						<td colspan="7"><form:textarea path="content" id="inputWorkDetail"></form:textarea></td>
					</tr>
					<tr>
						<th colspan="9">
						この開発経験を削除 
						<input type="button" value="行削除" id="deleteAdd" 
						onclick="DeleteDetail('speckTable')" />
						</th>
					</tr>
				</tbody>
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

		<input type="submit" value="登録内容確認"/>
		<input class="button" type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>
		</form:form>
		<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>