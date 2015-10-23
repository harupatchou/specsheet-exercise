var w = window;
function openWin(url) {
	if ((w == window) || w.closed) {
		w = open(url, "_blank", "width=300,height=300");
	} else {
		w.focus();
	}
	return (false);
}

function goBackOs(proNo){
	var osList=document.getElementsByName("os");
	var test = "os"+proNo;
	var value = "";
	for(var i=0;i<osList.length;i++){
		if(osList[i].checked)
			value+=(osList[i].value)+"/";
		}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.SpecForm.test.value=value;
	window.close();
	
}