<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/views/common/layout.jsp">
	<c:param name="content">


		<%--ここから下にコンテンツを挿入 --%>
		<form:form modelAttribute="specEditForm" action="/specedit/update"
			name="SpecForm">
			<h1 id="title">スペックシート更新</h1>

			<p>名前：</p>

			<p>
				待機： <select>
					<option>現場</option>
					<option>待機</option>
					<select>
						<br>
			</p>

			<p>
				編集時のコメント：
				<textarea>
				</textarea>
			</p>

			<table class="speckDetailTable formMini">
				<tr>
					<th>スタッフID</th>
					<td><input class="inputMiddle" type="text" /></td>

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
					<!-- 決め打ち -->
					<td>男性</td>

					<th>最寄駅</th>
					<td><input class="inputMiddle" type="text" />駅</td>

					<th>稼働開始日</th>
					<td>応相談</td>

				</tr>

			</table>

			<table class="speckDetailTable">
				<tr>
					<th rowspan="2">IT全体経験</th>
					<td rowspan="2" colspan="2"><input id="inputMini" type="text" />年<input id="inputMini" type="text" />ヵ月</td>
					<th rowspan="2">内訳</th>
					<th>サーバ・NW経験</th>
					<td colspan="2"><input id="inputMini" type="text" />年<input id="inputMini" type="text" />ヵ月</td>
					<th>SE経験</th>
					<td colspan="2"><input id="inputMini" type="text" />年<input id="inputMini" type="text" />ヵ月</td>
				</tr>
				<tr>
					<th>システム開発経験</th>
					<td colspan="2"><input id="inputMini" type="text" />年<input id="inputMini" type="text" />ヵ月</td>
					<th>PG・作業員経験</th>
					<td colspan="2"><input id="inputMini" type="text" />年<input id="inputMini" type="text" />ヵ月</td>
				</tr>
			</table>

			<br>

			<div class="inputSkill">
				<table class="speckDetailTable">
					<tr>
						<th colspan="9">スキル要約 <input type="button" value="行追加" /> <input
							type="button" value="最終行削除" />
						</th>
					</tr>
					<tr>
						<th colspan="3">言語</th>
						<th colspan="2">開発関連技術</th>
						<th colspan="2">環境(OS等)</th>
						<th colspan="2">業務範囲(工程)</th>
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
						<td><input type="text" /></td>
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
					<td><textarea class="appeal"></textarea></td>
				</tr>
			</table>
			
			<br>
			
			<!-- 		開発経験 -->
			<!-- 		繰り返し -->

			<div class="inputExperience">
				<table class="speckDetailTable">
					<tr>
						<th colspan="8">開発経験 <input type="button" value="行追加" /><input type="button" value="行削除" />
						</th>
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
					<tr>
						<td rowspan="5"><input id="inputNumber" type="text" /></td>
						<td rowspan="2"><input id="inputSpan" type="text" /></td>
						<td rowspan="4"><textarea id="inputProject"></textarea></td>
						<th>OS</th>
						<td><input type="button" value="OS選択" id="btnMini"
							onclick="location.href='selectOS.html'" /></td>
						<td rowspan="4"><textarea id="inputResponsible"></textarea></td>
						<td rowspan="4"><textarea id="inputResponsible"></textarea></td>
						<th>チーム</th>
					</tr>
					<tr>
						<th>言語</th>
						<td><input type="button" value="言語選択" id="btnMini"
							onclick="location.href='selectLanguage.html'" /></td>
						<td><input type="text" id="inputMini" />人</td>
					</tr>
					<tr>
						<td rowspan="2"><input id="inputSpan" type="text" /></td>
						<th rowspan="2">その他</th>
						<td rowspan="2"><textarea id="inputOther"></textarea></td>
						<th>開発全体</th>
					</tr>
					<tr>
						<td><input type="text" id="inputMini" />人</td>
					</tr>
					<tr>
						<th class="tallHeight">作業内容</th>
						<td colspan="6"><textarea id="inputWorkDetail"></textarea></td>
					</tr>
				</table>
			</div>

			<!-- 		繰り返し -->
			<div class="inputExperience">
				<table class="speckDetailTable">
					<tr>
						<th>No.</th>
						<th>期間</th>
						<th>プロジェクト概要</th>
						<th colspan="2">環境、ツールなど</th>
						<th>担当工程</th>
						<th>担当役割</th>
						<th>規模</th>
					</tr>
					<tr>
						<td rowspan="5"><input id="inputNumber" type="text" /></td>
						<td rowspan="2"><input id="inputSpan" type="text" /></td>
						<td rowspan="4"><textarea id="inputProject"></textarea></td>
						<th>OS</th>
						<td><input type="button" value="OS選択" id="btnMini"
							onclick="location.href='selectOS.html'" /></td>
						<td rowspan="4"><textarea id="inputResponsible"></textarea></td>
						<td rowspan="4"><textarea id="inputResponsible"></textarea></td>
						<th>チーム</th>
					</tr>
					<tr>
						<th>言語</th>
						<td><input type="button" value="言語選択" id="btnMini"
							onclick="location.href='selectLanguage.html'" /></td>
						<td><input type="text" id="inputMini" />人</td>
					</tr>
					<tr>
						<td rowspan="2"><input id="inputSpan" type="text" /></td>
						<th rowspan="2">その他</th>
						<td rowspan="2"><textarea id="inputOther"></textarea></td>
						<th>開発全体</th>
					</tr>
					<tr>
						<td><input type="text" id="inputMini" />人</td>
					</tr>
					<tr>
						<th class="tallHeight">作業内容</th>
						<td colspan="6"><textarea id="inputWorkDetail"></textarea></td>
					</tr>
				</table>
			</div>
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


		</form:form>
		<%--ここから上にコンテンツを挿入 --%>

	</c:param>
</c:import>