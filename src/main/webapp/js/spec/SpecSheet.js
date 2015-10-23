/**
 * 現在の最終行の後ろに対して、開発経験行の追加を行う
 * @param tableIdName 追加したいテーブルのId名
 */
var no = 1;
function AddDetail(tableIdName){
	no+=1;
	var appendContent = 
			"<tbody class='speckDetailTable'><tr><th>No.</th><th>期間</th><th>プロジェクト概要</th>" +
			"<th colspan='2'>環境、ツールなど</th><th>担当工程</th><th>担当役割</th><th>規模</th></tr>" +
			"<tr class='InputTr'><td rowspan='5' id='proNo'>" +
			"<input type='hidden' name='projectNo' value='"+ no +"'/>"
			+ no +
			"</td>" +
			"<td rowspan='4'><input name='startDay' /><br>～<br><input name='finishDay' /></td>" +
			"<td rowspan='4'><textarea name='overview' rows='10' cols='12' /></td><th>OS</th>" +
			"<td><input name='os" +
			no +
			"'/><input type='button' value='OS選択' id='btnMini' onclick=\"return openWin('/spec/osWindow?projectNo="
			+ no +
			"')\" /></td>" +
			"<td rowspan='4'><input type='button' value='担当工程' id='btnMini' onclick='location.href='selectOS.html'' /></td>" +
			"<td rowspan='4'><textarea name='role' id='inputResponsible'></textarea></td><th>チーム</th></tr>" +
			"<tr><th>言語</th><td><input type='button' value='言語選択' id='btnMini' onclick='location.href='selectLanguage.html'' /></td>" +
			"<td><input name='teamNum' id='inputMini' />人</td></tr><tr><th rowspan='2'>開発関連技術</th>" +
			"<td rowspan='2'><textarea name='other' id='inputOther'></textarea></td><th>開発全体</th></tr>" +
			"<tr><td><input name='allNum' id='inputMini' />人</td></tr><tr><th class='tallHeight'>作業内容</th>" +
			"<td colspan='6'><textarea name='content' id='inputWorkDetail'></textarea></td></tr></tbody>";
	
	$("#"+tableIdName).append(appendContent);

}

/**
 * 開発経験行の最終行削除を行う。
 * @param tableIdName 削除を行いたいテーブルのId名
 */
function DeleteDetail(tableIdName){
	no-=1;
	var work = $("#"+tableIdName+" .speckDetailTable").last();
	work.remove();
}