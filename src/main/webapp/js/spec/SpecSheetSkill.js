/**
 *スキル要約欄行追加削除
 *@author ueno
 * 
 */

function AddSkill(userSkillTable,langMap,osMap){
	
	//言語・OS一覧(文字列)を変数に
	var tempLangMap = langMap;
	var tempOsMap = osMap;
	
	//言語・OS一覧(文字列)の前後の{}を排除
	var tempLang = tempLangMap.substr( 1 , (tempLangMap.length-2) );
	var tempOs = tempOsMap.substr( 1 , (tempOsMap.length-2) );
	
	//言語・OS一覧(文字列)を,区切りで配列に格納
	var arrayLang = new Array();
	arrayLang =  tempLang.split(",");
	var arrayOs = new Array();
	arrayOs = tempOs.split(",");
	
	//完成系格納用変数
	var finishLangList = "";
	var finishOsList = "";
	
	//言語一覧selectタグの中身作成
	for(var i = 0; i < arrayLang.length; i++){
		if(i == 0){
			finishLangList += "<option value=" + i + ">" + arrayLang[i].substr(2,(arrayLang[i].length-1)) + "</option>";
		}
		if(0 < i && i < 10){
			finishLangList += "<option value=" + i + ">" + arrayLang[i].substr(3,(arrayLang[i].length-1)) + "</option>";
		}
		if(i >= 10){
			finishLangList += "<option value=" + i + ">" + arrayLang[i].substr(4,(arrayLang[i].length-1)) + "</option>";
		}
	}
	
	//OS一覧selectタグの中身作成
	for(var i = 0; i < arrayOs.length; i++){
		if(i == 0){
			finishOsList += "<option value=" + i + ">" + arrayOs[i].substr(2,(arrayOs[i].length-1)) + "</option>";
		}
		if(0 < i && i < 10){
			finishOsList += "<option value=" + i + ">" + arrayOs[i].substr(3,(arrayOs[i].length-1)) + "</option>";
		}
		if(i >= 10){
			finishOsList += "<option value=" + i + ">" + arrayOs[i].substr(4,(arrayOs[i].length-1)) + "</option>";
		}
	}
	
	var appendContent = 
		"<tr class='deleteFlag'>" +
		"	<td><select name='skillLangList'>" + finishLangList +
		"	</select></td>" +
		"	<td><input type='checkbox' name='expFlagInt' id='check' value='0'/>実務" +
		"		<input type='checkbox' name='expFlagInt' id='check' value='1'/>実務外</td>" +
		"	<td><input type='text' name='monthOfLangExp' id='inputMini'/>ヵ月</td>" +
		"	<td><input type='text' name='relatedTech'/></td>" +
		"	<td><select name='skillOsList'>" + finishOsList + 
		"	</select><br></td>" + 
		"	<td><input type='text' name='monthOfOsExp' id='inputMini'/>ヵ月</td>" +
		"</tr>";
	
	$("#" + userSkillTable).append(appendContent);
}

/**
 * スキル要約欄の最終行削除を行う。
 * @param tableIdName 削除を行いたいテーブルのId名
 */
function DelSkillColumn(userSkillTable){
	var work = $("#"+userSkillTable+" .deleteFlag").last();
	work.remove();
}


