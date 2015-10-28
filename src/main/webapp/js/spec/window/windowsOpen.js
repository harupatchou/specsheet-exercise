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
function goBackOs(btnNo){
	//選択したosの名前を取得
	var osList=document.getElementsByName("os");
	//その他の入力情報取得
	var osOther=document.getElementsByName("osOther");
	var test = "os"+btnNo;
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
function goBackLang(btnNo){
	//選択したlangの名前を取得
	var langList=document.getElementsByName("lang");
	//その他の入力情報取得
	var langOther=document.getElementById("langOther").value;
	var test = "lang"+btnNo;
	//値をvalueに入れていく
	var value = "";	
	for(var i=0;i<langList.length;i++){
		if(langList[i].checked)
			value+=(langList[i].value)+"/";
		}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.getElementById(test).value=value
	window.close();
}

/**
 * process選択時の作業
 * @param proNo
 */
function goBackProcess(btnNo){
	//選択したprocessの名前を取得
	var processList=document.getElementsByName("process");
	//その他の入力情報取得
	var processOther=document.getElementsByName("processOther");
	var test = "process"+btnNo;
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