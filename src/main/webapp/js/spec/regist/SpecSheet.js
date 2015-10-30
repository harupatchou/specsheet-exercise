//プロジェクト番号を指定するカラム
var no = 1; 
//最初の行のプロジェクト番号
var firstNo = 1;
//現状のプロジェクトの番号
var projectNo = 1;
//hidden用
var hiddenNo = 1;
//ボタンの番号
var btnNo = 1;

/**
 * 初期表示時の実行
 */
window.onload = function(){
	
	$(".firstOs").each(function(){
		$(this).attr("id","os"+btnNo)
		btnNo+=1;
	});
	btnNo=1;
	$(".firstLang").each(function(){
		$(this).attr("id","lang"+btnNo)
		btnNo+=1;
	});
	btnNo=1;
	$(".firstProcess").each(function(){
		$(this).attr("id","process"+btnNo)
		btnNo+=1;
	});
	btnNo=1;
	firstSetProNo();
	
}

/**
 * 現在の最終行の後ろに対して、開発経験行の追加を行う
 * @param tableIdName 追加したいテーブルのId名
 * @param 
 * @param
 */
function AddDetail(addTable){
	//追加のためnoを1にする(現状番号振り分けが逆になっている)
	no += 1;
	//ボタンの番号を増やす
	btnNo += 1;
	//現状のプロジェクト番号
	projectNo = 1;
	hiddenNo = 1;
	//追加したい表示コンテンツを書き込む
	var appendContent = 
			"<tbody id='testTable" + no + "' class='speckDetailTable'><tr><th>No.</th><th>期間</th><th>プロジェクト概要</th><th colspan='2'>環境、ツールなど</th>" +
			"<th>担当工程</th><th>担当役割</th><th>規模</th></tr>" +
			"</th></tr><tr class='InputTr'><td rowspan='6' class='proNo' >"+firstNo+"</td>" +
			"<input type='hidden' name='projectNo' class='setProNo' value='' />" +
			"<td rowspan='4'><input name='startDay' size='8'/><br>～<br><input name='finishDay' size='8'/></td>" +
			"<td rowspan='4'><textarea name='overview' rows='10' cols='12' /></td><th>OS</th>" +
			"<td><input name='os' id='os" + btnNo + "' size='30'/>" +
			"<input type='button' value='OS選択' id='osBtn" + btnNo + "'" +
			"onclick=\"return openWin('/spec/osWindow?btnNo="　+ btnNo +　"')\" /></td>" +
			"<td rowspan='4'>" +
			"<input name='process' id='process" + btnNo + "' size='28'/>" +
			"<input type='button' value='担当工程' id='proBtn" + btnNo + "'" +
			"onclick=\"return openWin('/spec/processWindow?btnNo="　+ btnNo +　"')\" /></td>" +
			"<td rowspan='4'><textarea name='role' id='inputResponsible' rows='10' cols='12'></textarea></td><th>チーム</th></tr>" +
			"<tr><th>言語</th><td><input name='lang' id='lang" + btnNo + "' size='30'/>" +
			"<input type='button' value='言語選択' id='langBtn" + btnNo + "'" +
			"onclick=\"return openWin('/spec/langWindow?btnNo="　+ btnNo +　"')\" /></td>" +
			"<td><input name='teamNum' id='inputMini' />人</td></tr><tr><th rowspan='2'>開発関連技術</th>" +
			"<td rowspan='2'><textarea name='other' id='inputOther' rows='4' cols='24'></textarea></td><th>開発全体</th></tr>" +
			"<tr><td><input name='allNum' id='inputMini' />人</td></tr><tr><th class='tallHeight'>作業内容</th>" +
			"<td colspan='6'><textarea name='content' id='inputWorkDetail' rows='12' cols='94'></textarea></td></tr>" +
			"<tr><th colspan='8'>この開発経験を削除 " +
			"<input type='button' value='行削除' id='deleteAdd' onclick='DeleteDetail(\"testTable"+no+"\")' />" +
			"<tr><td></td></tr></tbody>";
	
	$("#"+addTable).prepend(appendContent);
	setProNo();
}

/**
 * 開発経験行の最終行削除を行う。
 * @param tableIdName 削除を行いたいテーブルのId名
 */
function DeleteDetail(testTable){
	//削除した分番号を減らす
	var work = $("#"+testTable);
	work.remove();
	var hiddenId = 　document.getElementById("lastHidden").value;
	var lastId = 　document.getElementById("lastNo");
	//proNoが最後のテーブルの値と同じであればそのまま最終行の削除のみする
	if(parseInt(hiddenId)==parseInt(lastId)){
		$(".proNo").each(function(){
			if($(this).text()==no){
				$(this).attr('id', 'lastNo').value(1);
			}
		});	
		projectNo=1;
		setProNo();
	} else {
		firstNo=1;
		projectNo=1;
		hiddenNo=1;
		no-=1;
		setProNo();
	}
}

/**
 * 開発経験行の番号の自動采配を行う。
 * @param proNo プロジェクト番号を受けとり、采配して返す 
 * 
*/
function setProNo(){
	//ボタンを押すたび、番号の割り振り
	$(".setProNo").each(function(){
		$(this).attr("value",String(hiddenNo))
		hiddenNo+=1;
	});
	
	$(".proNo").each(function(){
		$(this).text(projectNo)
		projectNo+=1;
	});
	//最後のプロジェクトにはno（プロジェクト数のカウントしているカラム）を割り振る
	$("#lastNo").text(no)
	//最後のプロジェクトにはno（プロジェクト数のカウントしているカラム）を割り振る
	$("#projectNo").attr("value",no)
	
}

/**
 * 初期表示時に開発経験行の番号の自動采配を行う。
 * @param proNo プロジェクト番号を受けとり、采配して返す 
 * 
*/
function firstSetProNo(){
	//ボタンを押すたび、番号の割り振り
	$(".setProNo").each(function(){
		$(this).attr("value",String(hiddenNo))
		hiddenNo+=1;
	});
	
	$(".proNo").each(function(index){
		$(this).text(projectNo)
		projectNo+=1;
		no=index+1;
		btnNo=index+1;
	});
	
	hiddenNo=1;
	projectNo=1;
}
