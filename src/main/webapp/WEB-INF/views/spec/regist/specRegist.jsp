<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/js/spec/regist/SpecSheet.js"></script>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">

		<%--ここから下にコンテンツを挿入 --%>
		<form:form modelAttribute="specForm" action="/spec/regist"
			name="SpecForm" id="calId">
			<h1 id="title">スペックシート登録</h1>
			<!-- 名前 -->
			<p>姓：<form:input path="firstName" value="${user.firstName}" /></p>
			<p>名：<form:input path="lastName" value="${user.lastName}" /></p>
			<!-- 勤務状況 -->
			<p>状況：
			<form:select path="stateFlag" items="${stateMap}" />
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
					<form:select path="ageFlag" items="${ageMap}" />
					<br></td>

					<th>性別</th>
					<td><c:out value="${user.sex}" /></td>

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
					<form:input id="inputMini" path="allExpYear" />年
					<form:input id="inputMini" path="allExpMonth" />ヵ月</td> 
					<th rowspan="2">内訳</th>
					<th>サーバ・NW経験</th>
					<td colspan="2">
					<form:input id="inputMini"  path="serverNetworkExpYear" />年
					<form:input id="inputMini"  path="serverNetworkExpMonth" />ヵ月</td> 
					<th>SE経験</th>
	 				<td colspan="2">
	 				<form:input id="inputMini" path="seExpYear" />年
	 				<form:input id="inputMini" path="seExpMonth" />ヵ月</td> 
				</tr>
				<tr>
					<th>システム開発経験</th>
					<td colspan="2">
					<form:input id="inputMini" path="developmentExpYear" />年
					<form:input id="inputMini" path="developmentExpMonth" />ヵ月</td> 
					<th>PG・作業員経験</th>
					<td colspan="2">
					<form:input id="inputMini" path="pgOperatorExpYear" />年
					<form:input id="inputMini" path="pgOperatorExpMonth" />ヵ月</td> 
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
						<td><form:input path="monthOfOsExp" id="inputMini"/>ヵ月</td>
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
					<td><form:textarea path="appeal" class="appeal" rows="8" cols="109.5" ng-init ="appeal='${spec.appeal}'" ng-model="appeal" ng-maxlength="1024"></form:textarea></td>
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
						onclick="AddDetail('addTable')" />
						</th>
					</tr>
				</table>
				
				<table id="addTable" class="speckDetailTable">
				</table>
				<table id="speckTable" class="speckDetailTable">
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
						<td rowspan="5" id="lastNo" class="proNo">1</td>
						<form:input type="hidden" path="projectNo" value="1"/>
					<!-- 開発時期 -->
						<td rowspan="4">
						<form:input path="startDay"/><br>
						～<br>
						<form:input path="finishDay"/><br>
						</td>
						
					<!-- プロジェクト概要 -->
						<td rowspan="4">
						<form:textarea path="overview" rows="10" cols="12" />
						</td>
						
					<!-- OS -->
						<th>OS</th>
						<td>
						<form:input path="os" class="firstOs"/>
						<input type="button" value="OS選択" id="osBtn"
							onclick="return openWin('/spec/osWindow?btnNo=1')" />
						</td>
					
					<!-- 担当工程 -->
						<td rowspan="4">
						<form:input path="process" class="firstProcess"/>
						<input type="button" value="担当工程" id="proBtn"
							onclick="return openWin('/spec/processWindow?btnNo=1')" />
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
						<form:input path="lang" class="firstLang"/>
						<input type="button" value="言語選択" id="langBtn"
							onclick="return openWin('/spec/langWindow?btnNo=1')" />
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
						onclick="DeleteDetail('testTable')" />
						</th>
					</tr>
				</tbody>
				</table>
			<br>
			<input type="hidden" name="lastHidden" id="lastHidden" value="1" />

	<!-- 		資格要約 -->
<div class="inputSkill">
<table class="speckDetailTable" id="userLicenseTable">
 <tr>
 	<th colspan="9">資格資格
		<input type="button" value="行追加" onclick="insertRow('userLicenseTable')" />
		<input type="button" value="最終行削除" onclick="deleteRow2('userLicenseTable')" />
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
</table>
</div>
	
	<script>
	/**
	 * 行追加
	 */
	function insertRow(id) {
	    // テーブル取得
	    var table = document.getElementById(id);
	    // 行を行末に追加
	    var row = table.insertRow(-1);
	    // セルの挿入
	    var cell1 = row.insertCell(-1);
	    var cell2 = row.insertCell(-1);
	    var cell3 = row.insertCell(-1);
	    var cell4 = row.insertCell(-1);
	    var cell5 = row.insertCell(-1);
	    var cell6 = row.insertCell(-1);
	    // ボタン用 HTML
	    var button = '<tr><input type="button" value="行削除" onclick="deleteRow(this)" />';
		var lisenceName = '<td><form:input path="lisenceName" name="lisenceName" /></td>';
		var strAcquireDate = '<td><form:input path="strAcquireDate" name="strAcquireDate"  placeholder="yyyy/MM/dd" /></td></tr>';
	    // 行数取得
	    var row_len = table.rows.length;
	 
	    // セルの内容入力
	    cell1.innerHTML =　lisenceName;
	    cell2.innerHTML = strAcquireDate;
	    
	    cell3.innerHTML =　lisenceName;
	    cell4.innerHTML = strAcquireDate;
	    
	    cell5.innerHTML =　lisenceName;
	    cell6.innerHTML = strAcquireDate;
	}
	 
	/**
	 * 行削除
	 */
	function deleteRow2(){    // 行削除 
		 var table = document.getElementById("userLicenseTable");
		  var rowCnt = table.rows.length; // 行数
		   if(rowCnt==3){alert("これ以上削除できません。");return;}
		   table.deleteRow(-1);// 末尾行を削除
		　　　　}
	 
	</script>
	 
	
		<input type="submit" value="登録内容確認"/>
		<input class="button" type="button" value="メニューに戻る" onclick="location.href='/flowMenu'"/>
		</form:form>
		<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>