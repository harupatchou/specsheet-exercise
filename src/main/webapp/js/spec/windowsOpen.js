var w = window;
function openWin(url) {
	if ((w == window) || w.closed) {
		w = open(url, "_blank", "width=300,height=300");
	} else {
		w.focus();
	}
	return (false);
}

function goBack(){
	var ckList=document.getElementsByName("cast");
	var value = "";
	for(var i=0;i<ckList.length;i++){
	if(ckList[i].checked)
	value+=(ckList[i].value)+",";
	}
	value = value.substr( 0 , (value.length-1) );
	window.opener.document.EventForm.cast.value=value;
	window.close();
	
}