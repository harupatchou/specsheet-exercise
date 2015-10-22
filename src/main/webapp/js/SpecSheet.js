/**
 * 現在の最終行の後ろに対して、開発経験行の追加を行う
 * @param tableIdName 追加したいテーブルのId名
 */
function AddDetail(tableIdName){
	var appendContent = 
		+ "<tr><td rowspan='5'>1</td>"
		+ "<td rowspan='4'>"
		+ "<form:input path='startDay' /><br>～<br><form:input path='finishDay' /></td>"
		+ "<td rowspan='4'><form:textarea path='overView' rows='10' cols='12' /></td>"
		+ "<th>OS</th><td><input type='button' value='OS選択' id='btnMini' /></td>"
		+ "<td rowspan='4'><input type='button' value='担当工程' id='btnMini' /></td>"
		+ "<td rowspan='4'><form:textarea path='role' id='inputResponsible'></form:textarea></td>" 
		+ "<th>チーム</th></tr><tr><th>言語</th><td><input type='button' value='言語選択' id='btnMini' /></td>"
	    + "<td><form:input path='teamNum' id='inputMini' />人</td></tr><tr><th rowspan='2'>開発関連技術</th>"
	    + "<td rowspan='2'><form:textarea path='other' id='inputOther'></form:textarea></td><th>開発全体</th></tr><tr>"
	    + "<td><form:input path='allNum' id='inputMini' />人</td></tr><tr><th class='tallHeight'>作業内容</th>"
	    + "<td colspan='6'><form:textarea path='content' id='inputWorkDetail'></form:textarea></td></tr>";
	
	$("#"+tableIdName).append(appendContent);
}


$(document).on("click", "[id='detailAdd']", function(e) {
//Noの最大値を取得
var max_no = $( '#sample_table > tbody > tr:last td:first' ).html();
//次のNoを生成
var next_no = parseInt(max_no) + 1;
//tbodyの最初の子供（ダミー行）をコピー
$("#sample_table > tbody > tr:first").clone(true).appendTo(
$("#sample_table > tbody")
);
//追加した行（最終行）を活性化させる。
$( '#sample_table > tbody > tr:last' ).css('display', '');
//追加した行のNoに値を入れる。
$( '#sample_table > tbody > tr:last td:first' ).html(next_no);
//追加した行の各テキストボックスのname属性を変更する。
$( '#sample_table > tbody > tr:last > td > input' ).each(function() {
var base_name = $(this).attr('name');
$(this).attr('name', base_name + "_" + next_no);
});
});