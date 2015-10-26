var w = window;
function openWin(url) {
	if ((w == window) || w.closed) {
		w = open(url, "_blank", "width=500,height=500");
	} else {
		w.focus();
	}
	return (false);
}

/**
 * os選択時の作業
 * 
 * 
 */
function goBackOs(proNo,te){
	var osList=document.getElementsByName("os");
	//最後のテーブルに持たせたlastHiddenの値1を取得
	var osId = window.opener.document.getElementById("lastHidden").value;
	var test = "os"+proNo;
	//proNoが最後のテーブルの値と同じであればtestの名前をosにする
	if(parseInt(osId)==proNo){
		test = "os";
	}
	//値をvalueに入れていく
	var value = "";
	for(var i=0;i<osList.length;i++){
		if(osList[i].checked)
			value+=(osList[i].value)+"/";
		}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.getElementById(test).value=value;
	window.close();	
}

/**
 * lang選択時の作業
 * 
 * 
 */
function goBackLang(proNo){
	var langList=document.getElementsByName("lang");
	//最後のテーブルに持たせたlastHiddenの値1を取得
	var langId = window.opener.document.getElementById("lastHidden").value;
	var test = "lang"+proNo;
	//proNoが最後のテーブルの値と同じであればtestの名前をlangにする
	if(parseInt(langId)==proNo){
		test = "lang";
	}
	//値をvalueに入れていく
	var value = "";	
	for(var i=0;i<langList.length;i++){
		if(langList[i].checked)
			value+=(langList[i].value)+"/";
		}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.getElementById(test).value=value;
	window.close();
}

/**
 * process選択時の作業
 * @param proNo
 */
function goBackProcess(proNo){
	var processList=document.getElementsByName("process");
	//最後のテーブルに持たせたlastHiddenの値1を取得
	var processId = window.opener.document.getElementById("lastHidden").value;
	var test = "process"+proNo;
	//proNoが最後のテーブルの値と同じであればtestの名前をprocessにする
	if(parseInt(processId)==proNo){
		test = "process";
	}
	//値をvalueに入れていく
	var value = "";
	for(var i=0;i<processList.length;i++){
		if(processList[i].checked)
			value+=(processList[i].value)+"/";
		}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.getElementById(test).value=value;
	window.close();
}