<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/js/spec/edit/SpecSheetEdit.js"></script>
<script src="/js/spec/regist/LicenseColumnNumChange.js"></script>
<script src="/js/spec/SpecSheet.js"></script>
<script src="/js/spec/windowsOpen.js"></script>

<script src="/js/lib/jquery-2.1.4.min.js"></script>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">

		<%--ここから下にコンテンツを挿入 --%>
		<form:form modelAttribute="specForm" action="/spec/edit"
			name="SpecForm" id="formId">
			<h1 id="title">スペックシート編集</h1>
			<!-- 名前 -->
			<p>姓：<form:input path="firstName" value="${user.firstName}" class="validate[required,maxSize[16]]"/></p>
			<p>名：<form:input path="lastName" value="${user.lastName}" class="validate[required,maxSize[16]]"/></p>
			<!-- 勤務状況 -->
			<p>状況：
			<form:select path="stateFlag" class="validate[required]">
				<c:forEach var="stateKey" items="${stateMap.keySet()}">
					<c:choose>
						<c:when test="${stateKey == spec.stateFlag}">
							<option value="${stateKey}" selected="selected"><c:out value="${stateMap.get(stateKey)}"/></option>
						</c:when>
						<c:otherwise>
							<option value="${stateKey}"><c:out value="${stateMap.get(stateKey)}"/></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</form:select>
			<br>
			</p>
			<!-- コメント -->
			<p>編集時のコメント：
			<form:textarea path="comment" value="${spec.comment}" placeholder="(例)初期登録" class="validate[maxSize[1024]]"/>
			</p>

			<!-- 基本情報 -->
			<table class="speckDetailTable formMini">
				<tr>
					<th>スタッフID</th>
					<td><form:input path="staffId" value="${user.staffId}" class="validate[required,maxSize[16]]"/></td>

					<th>年齢</th>
					<td>
					<form:select path="ageFlag"  class="validate[required]">
						<c:forEach var="ageKey" items="${ageMap.keySet()}">
							<c:choose>
								<c:when test="${ageKey == spec.ageId}">
									<option value="${ageKey}" selected="selected"><c:out value="${ageMap.get(ageKey)}" /></option> 
								</c:when> 
 								<c:otherwise> 
 									<option value="${ageKey}" ><c:out value="${ageMap.get(ageKey)}" /></option> 
 								</c:otherwise> 
							</c:choose> 
 						</c:forEach> 
 					</form:select>
 					</td>
					<th>性別</th>
					<td><c:out value="${user.sex}" /></td>

					<th>最寄駅</th>
					<td><form:input id="inputMini" path="nearestStation" value="${spec.nearestStation}" class="validate[required,maxSize[16]]" />駅</td>

					<th>稼働開始日</th>
					<td>応相談</td>

				</tr>

			</table>

			<!-- 経験年数 -->
			<table class="speckDetailTable">
				<tr>
					<th rowspan="2">IT全体経験</th>
					<td rowspan="2" colspan="2">
					<form:input id="inputMini" path="allExpYear"   value="${spec.year}" class="validate[custom[number]]"/>年
					<form:input id="inputMini" path="allExpMonth"  value="${spec.month}" class="validate[custom[number],max[12]]"/>ヵ月</td> 
					<th rowspan="2">内訳</th>
					<th>サーバ・NW経験</th>
					<td colspan="2">
					<form:input id="inputMini"  path="serverNetworkExpYear"  value="${breakdown.serverNetworkExpYear}" class="validate[custom[number]]"/>年
					<form:input id="inputMini"  path="serverNetworkExpMonth"  value="${breakdown.serverNetworkExpMonth}" class="validate[custom[number],max[12]]"/>ヵ月</td> 
					<th>SE経験</th>
	 				<td colspan="2">
	 				<form:input id="inputMini" path="seExpYear" value="${breakdown.seExpYear}" class="validate[custom[number]]"/>年
	 				<form:input id="inputMini" path="seExpMonth" value="${breakdown.seExpMonth}" class="validate[custom[number],max[12]]"/>ヵ月</td> 
				</tr>
				<tr>
					<th>システム開発経験</th>
					<td colspan="2">
					<form:input id="inputMini" path="developmentExpYear"  value="${breakdown.developmentExpYear}" class="validate[custom[number]]"/>年
					<form:input id="inputMini" path="developmentExpMonth"  value="${breakdown.developmentExpMonth}" class="validate[custom[number],max[12]]"/>ヵ月</td> 
					<th>PG・作業員経験</th>
					<td colspan="2">
					<form:input id="inputMini" path="pgOperatorExpYear" value="${breakdown.pgOperatorExpYear}" class="validate[custom[number]]"/>年
					<form:input id="inputMini" path="pgOperatorExpMonth" value="${breakdown.pgOperatorExpMonth}" class="validate[custom[number],max[12]]"/>ヵ月</td> 
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
					
					<c:if test="${skillsSummary.size() == 0}">
						<tr>
							<td><form:select path="skillLangList" items="${langMap}"/></td>
							<td><form:checkbox path="expFlagInt" id="check" value="0"/>実務
								<form:checkbox path="expFlagInt" id="check" value="1"/>実務外</td>
							<td><form:input path="monthOfLangExp" id="inputMini" type="text"  class="validate[custom[number]]"/>ヵ月</td>
							<td><form:input path="relatedTech" value="${spec.relatedTech}"/></td>
							<td><form:select path="skillOsList" items="${osMap}"/><br></td>
							<td><form:input path="monthOfOsExp" id="inputMini" type="text"  class="validate[custom[number]]"/>ヵ月</td>
						</tr>
					</c:if>
					
					
					
					<c:if test="${skillsSummary.size() != 0}">
						<c:forEach var="skill" items="${skillsSummary}">
						<tr>
						
						<%--         経験言語                   --%>
						
						<td>
						<form:select path="skillLangList">
							<c:forEach var="langKey" items="${langMap.keySet()}">
								<c:choose>
									<c:when test="${langMap.get(langKey).equals(skill.language)}">
										<option value="${langKey}" selected="selected"><c:out value="${langMap.get(langKey)}"/></option>
									</c:when>
									<c:otherwise>
										<option value="${langKey}"><c:out value="${langMap.get(langKey)}"/></option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
						</td>
						
						<%--         実務経験フラグ                --%>
						
						<td>
						<c:if test="${skill.expFlag == null}">
								<form:checkbox path="expFlagInt" id="check" value="0" checked="checked"/>実務
								<form:checkbox path="expFlagInt" id="check" value="1"/>実務外
						</c:if>
						<c:if test="${skill.expFlag == 0}">
								<form:checkbox path="expFlagInt" id="check" value="0" checked="checked"/>実務
								<form:checkbox path="expFlagInt" id="check" value="1"/>実務外
						</c:if>
						<c:if test="${skill.expFlag == 1}">
								<form:checkbox path="expFlagInt" id="check" value="0"/>実務
								<form:checkbox path="expFlagInt" id="check" value="1"  checked="checked"/>実務外
						</c:if>
						</td>
						
						<%--         言語経験月数                      --%>
						
						<td><form:input path="monthOfLangExp" value = "${skill.monthOfLangExp}" id="inputMini" type="text"  class="validate[custom[number]]"/>ヵ月</td>
						
						<%--         開発関連技術               --%>
						
						<td><form:input path="relatedTech" value="${skill.relatedTech}"/></td>
						
						<%--         経験OS            --%>
						
						<td>
						<form:select path="skillOsList">
							<c:forEach var="osKey" items="${osMap.keySet()}">
								<c:choose>
									<c:when test="${osMap.get(osKey).equals(skill.os)}">
										<option value="${osKey}" selected="selected"><c:out value="${osMap.get(osKey)}"/></option>
									</c:when>
									<c:otherwise>
										<option value="${osKey}"><c:out value="${osMap.get(osKey)}"/></option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
						<br></td>
						
						<%--         OS経験月数            --%>
						
						<td><form:input path="monthOfOsExp" value="${skill.monthOfOsExp}"  id="inputMini" type="text"  class="validate[custom[number]]"/>ヵ月</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
			</div>
			<br>

			<!-- 		アピールポイント -->
			<table class="speckDetailTable">
				<tr>
					<th>アピールポイント</th>
				</tr>
				<tr class="tallHeight">
					<td><form:textarea path="appeal" class="validate[maxSize[1024]] appeal" rows="8" cols="107" ng-init ="appeal='${spec.appeal}'" ng-model="appeal" ng-maxlength="1024"></form:textarea></td>
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
					<tbody id="testTable${i.index+1}" class="speckDetailTable">
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
							<td rowspan="6" id="lastNo" class="proNo"></td>
							<form:input type="hidden" path="projectNo" value="${i.index+1}"/>
							<input type="hidden" name="lastHidden" id="lastHidden" value="1" />
						</c:if>
						<c:if test="${!i.last}">
							<td rowspan="6" class="proNo"></td>
							<form:input type="hidden" path="projectNo" value="${i.index+1}"/>
						</c:if>
					<!-- 開発時期 -->
						<td rowspan="4">
						<form:input path="startDay" value="${startDate[i.index]}" size="8" class="validate[required,custom[date],future[1900/01/01],past[NOW]]"/><br>
						～<br>
						<form:input path="finishDay" value="${finishDate[i.index]}" size="8" class="validate[required,custom[date],future[1900/01/01],past[NOW]]"/>
						</td>
						
					<!-- プロジェクト概要 -->
						<td rowspan="4">
						<form:textarea path="overview" rows="10" cols="12" class="overview validate[required,maxSize[64]]"/>
						<input type="hidden" id="overviewHidden${i.index}" value="${project.overview}"/>
						</td>
						
					<!-- OS -->
						<th>OS</th>
						<td>
						<form:input path="os" class="firstOs" value="${osEditList[i.index]}" size="30"/>
						<input type="button" value="OS選択" id="btnMini"
							onclick="return openWin('/spec/osWindow?btnNo=${(i.index+1)}')" />
						</td>
					
					<!-- 担当工程 -->
						<td rowspan="4">
						<form:input path="process" class="firstProcess" value="${processEditList[i.index]}" size="28"/>
						<input type="button" value="担当工程" id="btnMini"
							onclick="return openWin('/spec/processWindow?btnNo=${(i.index+1)}')" />
						</td>
						
					<!-- 担当役割 -->
						<td rowspan="4">
						<form:textarea path="role" id="inputResponsible" class="role" rows="10" cols="12"/>
						<input type="hidden" id="roleHidden${i.index}" value="${project.role}" class="validate[required,maxSize[128]]"/>
						</td>
			
						<th>チーム</th>
					</tr>
					
					<tr>
					<!-- 言語 -->
						<th>言語</th>
						<td>
						<form:input path="lang" class="firstLang" value="${langEditList[i.index]}" size="30"/>
						<input type="button" value="言語選択" id="btnMini"
							onclick="return openWin('/spec/langWindow?btnNo=${(i.index+1)}')" />
						</td>
						
					<!-- チーム人数 -->
						<td><form:input path="teamNum" id="inputMini" value="${project.teamNum}" class="validate[required,custom[number],maxSize[16]]"/>人</td>
					</tr>
					
					<tr>
					<!-- 開発関連技術 -->
						<th rowspan="2">開発関連技術</th>
						<td rowspan="2">
						<form:textarea path="other" id="inputOther" class="other" rows="4" cols="24"/>
						<input type="hidden" id="otherHidden${i.index}" value="${project.other}" class="validate[required,maxSize[256]]"/>
						</td>
						<th>開発全体</th>
					</tr>
					<tr>
						<td><form:input path="allNum" id="inputMini" value="${project.allNum}" class="validate[required,custom[number],maxSize[16]]"/>人</td>
					</tr>
					<tr>
						<th class="tallHeight">作業内容</th>
						<td colspan="7">
						<form:textarea path="content" id="inputWorkDetail" rows="12" cols="94" class="content"/>
						<input type="hidden" id="contentHidden${i.index}" value="${project.content}"/>
						</td>
					</tr>
					<tr>
						<th colspan="8">
						この開発経験を削除 
						<input type="button" value="行削除" id="deleteAdd" 
						onclick="DeleteDetail('testTable${i.index+1}')" />
						<c:if test="${i.last}">
						</c:if>
						</th>
					</tr>
				</tbody>
				</c:forEach>
				</table>
			<br>
			<input type="hidden" name="lastHidden" id="lastHidden" value="1" />

	<!-- 		資格要約 -->
<div class="inputSkill">
<table class="speckDetailTable" id="userLicenseTable">
 <tr>
 	<th colspan="9">資格
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
					
					
					<tr>
					<c:forEach items="${specDetailLicenseList }" var="specDetailLicenseList" varStatus="i"  >
					<c:if test="${(i.index + 1 ) % 4 == 0 }">
					</tr>
					<tr>
					</c:if>
					
						<td><form:input path='lisenceName' name='lisenceName' value="${specDetailLicenseList.name }" class="validate[maxSize[32]]"/></td>
		                <td><form:input path='strAcquireDate' name='strAcquireDate'  placeholder='yyyy/MM/dd' value="${licenseDate[i.index]}" class="validate[custom[date],future[1900/01/01],past[NOW]]"/></td>

						<c:if test="${(i.last && (i.count - 1 ) == 0) || (i.last && (i.count - 1 ) % 3 == 0)}">
						<td><form:input path='lisenceName' name='lisenceName' value="" class="validate[maxSize[32]]"/></td>
		                <td><form:input path='strAcquireDate' name='strAcquireDate'  placeholder='yyyy/MM/dd' class="validate[custom[date],future[1900/01/01],past[NOW]]"/></td>
		                <td><form:input path='lisenceName' name='lisenceName' value="" class="validate[maxSize[32]]"/></td>
		                <td><form:input path='strAcquireDate' name='strAcquireDate'  placeholder='yyyy/MM/dd' class="validate[custom[date],future[1900/01/01],past[NOW]]"/></td>
						</c:if>
						
						
						<c:if test="${(i.last && (i.count - 1 )  == 1) || (i.last && (i.count - 1 ) % 3 == 1)}">
						<td><form:input path='lisenceName' name='lisenceName' value="" class="validate[maxSize[32]]"/></td>
		                <td><form:input path='strAcquireDate' name='strAcquireDate'  placeholder='yyyy/MM/dd' class="validate[custom[date],future[1900/01/01],past[NOW]]"/></td>
		                </c:if>

					</c:forEach>
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
		var lisenceName = '<td><form:input path="lisenceName" name="lisenceName"  class="validate[maxSize[32]]"/></td>';
		var strAcquireDate = '<td><form:input path="strAcquireDate" name="strAcquireDate"  placeholder="yyyy/MM/dd"  class="validate[custom[date],future[1900/01/01],past[NOW]]"/></td></tr>';
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