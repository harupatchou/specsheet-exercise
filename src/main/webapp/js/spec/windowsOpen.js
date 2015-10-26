var w = window;
function openWin(url) {
	if ((w == window) || w.closed) {
		w = open(url, "_blank", "width=500,height=500");
	} else {
		w.focus();
	}
	return (false);
}

function goBackOs(proNo,te){
	var osList=document.getElementsByName("os");
	var test = "osTest"+proNo;
	var value = "";
	for(var i=0;i<osList.length;i++){
		if(osList[i].checked)
			value+=(osList[i].value)+"/";
		}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.getElementById(test).value=value;
	window.close();	
}

function goBackLang(proNo){
	var langList=document.getElementsByName("lang");
	var test = "lang"+proNo;
	var value = "";
	for(var i=0;i<langList.length;i++){
		if(langList[i].checked)
			value+=(langList[i].value)+"/";
		}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.SpecForm.elements[test].value=value;
	window.close();
}

function goBackProcess(proNo){
	var processList=document.getElementsByName("process");
	var test = "process"+proNo;
	var value = "";
	for(var i=0;i<processList.length;i++){
		if(processList[i].checked)
			value+=(processList[i].value)+"/";
		}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.SpecForm.elements[test].value=value;
	window.close();
}